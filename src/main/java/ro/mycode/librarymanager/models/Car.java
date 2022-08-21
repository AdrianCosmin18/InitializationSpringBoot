package ro.mycode.librarymanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Car")
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String color;
    private Double weight;

    public Car(String brand, String model, Integer year, String color, Double weight) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.weight = weight;
    }
}
