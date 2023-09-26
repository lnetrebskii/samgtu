import com.example.repository.DataRepository;
import com.example.model.*;

import com.example.model.Person;
import com.example.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataRepositoryTest {

    private DataRepository repository;

    @BeforeEach
    public void setUp() {
        Address address1 = new Address("Green Street", "5a");
        Address address2 = new Address("Blue Street", "10b");
        Address address3 = new Address("Green Street", "7");
        Address address4 = new Address("Red Street", "3");

        Person person1 = new Person("Doe", LocalDate.of(1990, 1, 10), address1);
        Person person2 = new Person("Smith", LocalDate.of(1985, 5, 20), address2);
        Person person3 = new Person("Doe", LocalDate.of(2000, 7, 15), address3);
        Person person4 = new Person("Taylor", LocalDate.of(1995, 11, 30), address4);

        repository = new DataRepository(Arrays.asList(person1, person2, person3, person4));
    }

    @Test
    public void testFindByLastName() {
        List<Person> result = repository.findByLastName("Doe");
        assertEquals(2, result.size());
    }

    @Test
    public void testFindByAddressAttribute() {
        List<Person> resultStreet = repository.findByAddressAttribute("Green Street");
        assertEquals(2, resultStreet.size());

        List<Person> resultHouse = repository.findByAddressAttribute("5a");
        assertEquals(1, resultHouse.size());
    }

    @Test
    public void testFindBetweenDates() {
        List<Person> result = repository.findBetweenDates(LocalDate.of(1985, 1, 1), LocalDate.of(1999, 12, 31));
        assertEquals(3, result.size());
    }

    @Test
    public void testFindOldest() {
        Person result = repository.findOldest();
        assertEquals("Smith", result.getLastName());
    }

    @Test
    public void testFindYoungest() {
        Person result = repository.findYoungest();
        assertEquals("Doe", result.getLastName());
    }

    @Test
    public void testFindByStreet() {
        List<Person> result = repository.findByStreet("Green Street");
        assertEquals(2, result.size());
    }
}
