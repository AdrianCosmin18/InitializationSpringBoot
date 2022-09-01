package ro.mycode.librarymanager.controllers;


import org.springframework.web.bind.annotation.*;
import ro.mycode.librarymanager.models.Car;
import ro.mycode.librarymanager.respository.CarRepo;

import java.util.List;

@RestController
public class CarController {

    private CarRepo carRepo;

    public CarController(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping("/toate-masinile")
    public List<Car> getAllCars(){
        return  carRepo.findAll();
    }

    @PostMapping("/adauga-masina")
    public void addCar(@RequestBody Car car){
        carRepo.save(car);
    }

    @DeleteMapping("/delete-car/{id}")
    public void eraseCar(@PathVariable Long id){
        carRepo.deleteById(id);
    }

    @PutMapping("/update-car/{id}")
    public Car update(@PathVariable Long id, @RequestBody Car car){

        Car existingCar = carRepo.findById(id).get();
        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setColor(car.getColor());
        existingCar.setWeight(car.getWeight());
        existingCar.setYear(car.getYear());
        carRepo.save(existingCar);
        return existingCar;
    }

    //ce returneaza masina cea mai noua
    @GetMapping("/max-year")
    public Car getMaxYear(){
        return carRepo.oldestCar();
    }

    //5 functionati

    @GetMapping("/all-cars-bigger-than")
    public List<Car> getCarsByMinimumYear(@RequestParam(value = "year") Integer year){
        return carRepo.getCarsByMinimumYear(year);
    }

    @GetMapping("/all-cars-by-max-weight/{maxWeight}")
    public List<Car> getCarByMaxWeight(@PathVariable double maxWeight){
        return carRepo.findCarsByWeightBefore(maxWeight);
    }

    @DeleteMapping("/delete-by-max-and-min-weight")
    public void delete (@RequestParam(value = "minWeight") Double minWeight, @RequestParam(value = "maxWeight") Double maxWeight){

        carRepo.deleteCars(minWeight, maxWeight);
    }

    @PutMapping("/update-car-color-by-brand")
    public void updateColorByBrand(@RequestParam(value = "brand") String brand, @RequestParam(value = "color") String color){

        carRepo.updateCarColorByBrand(brand, color);
    }

    //tema 1)
    @PutMapping("/update-car-color-weight-by-id/{id}")
    public void updateColorAndWeightById(@PathVariable Long id, @RequestParam(value = "color") String color, @RequestParam(value = "weight") Double weight){
        carRepo.updateColorAndWeightById(id, color, weight);
    }
    //2)
    @DeleteMapping("/delete-car-by-model-and-year")
    public void deleteByModelAndYear(@RequestParam(value = "model") String model, @RequestParam(value = "year") int year){
        carRepo.deleteCarsByModelAndYear(model, year);
    }

    //3)
    @PutMapping("/update-car2/{id}")
    public void updateCarById(@PathVariable long id, @RequestBody Car car){
        carRepo.updateCarById(id, car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getWeight());
    }

    //4) nu merge <=> nu ret nimic
    @GetMapping("cars-by-year-and-max-weight/{year}")
    public List<Car> getCarsByYearAndMaxWeight(@PathVariable int year, @RequestParam(value = "weight") double weight){
        return carRepo.findCarsByYearAndMaxWeight(year, weight);
    }



}
