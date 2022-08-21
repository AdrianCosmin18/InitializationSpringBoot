package ro.mycode.librarymanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@Entity(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private Integer cnp;
    private Integer age;
    private double weight;

    public Person(String fullName, Integer cnp, Integer age, double weight) {
        this.fullName = fullName;
        this.cnp = cnp;
        this.age = age;
        this.weight = weight;
    }
}
