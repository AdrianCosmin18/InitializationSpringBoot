package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.librarymanager.models.Car;

public interface CarRepo extends JpaRepository<Car, Long> {
}
