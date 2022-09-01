package ro.mycode.librarymanager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.librarymanager.models.Book;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    @Modifying
    @Query("update Book b set b.author = :author, b.year = :year, b.available = :av, b.name = :name, b.pageNumber = :pgNr where b.id = :id")
    void updateById(long id, String author, int year, boolean av, String name, int pgNr);
    List<Book> getBookByPageNumberIsGreaterThan(int nr);

    @Query("select b from Book b where b.available = true")
    List<Book> getAvailableBooks();

//    @Query("delete from Book b where b = :authorName")
    void deleteByAuthor(String name);
}
