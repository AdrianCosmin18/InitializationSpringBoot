package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.mycode.librarymanager.models.Car;

import java.util.List;


@Repository
@Transactional
public interface CarRepo extends JpaRepository<Car, Long> {

    @Query("select c from Car c where  c.year in (SELECT max(t.year) from Car t)")
    Car oldestCar();

    @Query("select c from Car c where c.year >= ?1")
    List<Car> getCarsByMinimumYear(int year);

    List<Car> findCarsByWeightBefore(double maxWeight);

    @Modifying
    @Query("delete from Car c where c.weight between ?1 and ?2")
    void deleteCars(double min, double max);

    @Modifying
    @Query("update Car c set c.color = :col where c.brand = :br")
    void updateCarColorByBrand(String br, String col);

    //tema
    @Modifying
    @Query("update Car c set c.color = :col, c.weight = :wgh where c.id = :id")
    void updateColorAndWeightById(long id, String col, double wgh);

    @Modifying //nu merge cu queryDSL
    @Query("delete from Car c where c.model = :m and c.year = :y")
    void deleteCarsByModelAndYear(String m, int y);

    @Modifying
    @Query("update Car c set c.brand = :brand, c.weight = :weight, c.model = :model, c.year = :year, c.color = :color where c.id = :id")
    void updateCarById(long id, String brand, String model, int year, String color, double weight);

}
