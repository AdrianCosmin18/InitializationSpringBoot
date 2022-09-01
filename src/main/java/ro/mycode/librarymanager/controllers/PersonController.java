package ro.mycode.librarymanager.controllers;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import ro.mycode.librarymanager.LibraryManagerApplication;
import ro.mycode.librarymanager.models.Person;
import ro.mycode.librarymanager.respository.PersonRepo;

import java.util.List;

@RestController
public class PersonController {

    private PersonRepo personRepo;

    public PersonController(PersonRepo personRepo){
        this.personRepo = personRepo;
    }

    @PostMapping("add-person")
    public void addPerson(@RequestBody Person p){
        personRepo.save(p);
    }

    @GetMapping("get-all-persons")
    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }

    @GetMapping("/get-person-by-id/{id}")
    public Person getPersonById(@PathVariable long id){
        return personRepo.getPersonById(id);
    }

    @DeleteMapping("/delete-by-name")
    public void deleteByName(@RequestParam(value = "name") String name){
        personRepo.deleteByFullName(name);
    }

    //500 Error
    @PutMapping("/update-age-and-weight/{id}")
    public void updateAgeAndWeight(@PathVariable long id ,@RequestParam(value = "age")int age, @RequestParam(value = "weight")double weight){
        personRepo.updateAgeAndWeight(id, weight, age);
    }

    @GetMapping("/get-age-between")
    public List<Person> getPeronByAgeBetween(@RequestParam(value = "minAge")int mAge, @RequestParam(value = "maxAge")int MAge){
        return personRepo.getAllByAgeBetween(mAge, MAge);
    }

    @GetMapping("/get-minors")
    public List<Person> getMinors(){
        return personRepo.getAllByAgeBefore(18);
    }




}
