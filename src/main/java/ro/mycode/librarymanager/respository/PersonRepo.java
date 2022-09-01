package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ro.mycode.librarymanager.models.Person;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Long> {

    Person getPersonById(long id);

    @Modifying
    void deleteByFullName(String name);

    @Modifying
    @Query("update Person p set p.weight = :weight, p.age = :age where p.id = :id")
    void updateAgeAndWeight(long id, double weight, int age);

    List<Person> getAllByAgeBetween(int minAge, int maxAge);

    List<Person> getAllByAgeBefore(int age);
}
