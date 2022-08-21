package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mycode.librarymanager.models.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
