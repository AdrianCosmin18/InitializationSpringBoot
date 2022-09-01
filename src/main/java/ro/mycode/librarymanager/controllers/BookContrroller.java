package ro.mycode.librarymanager.controllers;

import org.springframework.web.bind.annotation.*;
import ro.mycode.librarymanager.models.Book;
import ro.mycode.librarymanager.respository.BookRepo;

import java.util.List;

@RestController
public class BookContrroller {

    private BookRepo bookRepo;

    public BookContrroller(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping("add-book")
    public void addCar(@RequestBody Book b){
        bookRepo.save(b);
    }

    @GetMapping("all-books")
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    @DeleteMapping("delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable long id){
        bookRepo.deleteById(id);
    }

    //500 error
    @PutMapping("update-book-by-id/{id}")
    public Book updateBook(@PathVariable long id, @RequestBody Book b){
        bookRepo.updateById(id, b.getAuthor(), b.getYear(), b.getAvailable(),b.getName(),b.getPageNumber());
        return bookRepo.getById(id);
    }

    @GetMapping("get-book-by-minimum-page-number")
    public List<Book> getBooksByMinPageNumber(@RequestParam(value = "nrPg") int nrPg){
        return bookRepo.getBookByPageNumberIsGreaterThan(nrPg);
    }

    @GetMapping("get-book-available-books")
    public List<Book> getAvailableBooks(){
        return bookRepo.getAvailableBooks();
    }

    @DeleteMapping("delete-by-author")
    public void deleteByAuthorName(@RequestParam(value = "authorName") String name){
        bookRepo.deleteByAuthor(name);
    }






}
