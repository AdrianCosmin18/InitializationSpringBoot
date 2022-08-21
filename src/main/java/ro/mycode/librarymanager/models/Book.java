package ro.mycode.librarymanager.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Book")
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private Integer year;
    private Integer pageNumber;
    private Boolean available;

    public Book(String name, String author, Integer year, Integer pageNumber, Boolean available) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.pageNumber = pageNumber;
        this.available = available;
    }


}
