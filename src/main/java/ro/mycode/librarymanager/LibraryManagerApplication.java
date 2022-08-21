package ro.mycode.librarymanager;

import com.github.javafaker.Faker;
import jdk.jfr.Percentage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.librarymanager.models.Book;
import ro.mycode.librarymanager.models.Car;
import ro.mycode.librarymanager.models.Person;
import ro.mycode.librarymanager.respository.BookRepo;
import ro.mycode.librarymanager.respository.CarRepo;
import ro.mycode.librarymanager.respository.PersonRepo;

@SpringBootApplication
public class LibraryManagerApplication {

    public static void main(String[] args) {SpringApplication.run(LibraryManagerApplication.class, args);}


    @Bean
    CommandLineRunner commandLineRunner(BookRepo bookRepo, CarRepo carRepo, PersonRepo personRepo){

        return args -> {
            Faker faker = new Faker();

            for (int i=1;i<=5;i++) {

                Book book = new Book(faker.book().title(), faker.book().author(), faker.number().numberBetween(1900, 2000), faker.number().numberBetween(250, 800), faker.bool().bool());
                bookRepo.save(book);
            }

            for (int i=1;i<=5;i++){

                Car car = new Car(faker.company().name(), faker.app().name(), faker.number().numberBetween(2010, 2022), faker.color().name(), (double) faker.number().numberBetween(1200, 2100));
                carRepo.save(car);
            }

            for(int i=0;i<5;i++){

                Person p = new Person(faker.name().fullName(), faker.number().numberBetween(19912348, 99999999), faker.number().numberBetween(1, 99), faker.number().randomDouble(1,20,130));
                personRepo.save(p);
            }
        };
    }



}
