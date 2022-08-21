package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.librarymanager.models.Book;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
