package br.com.gustainMars.services;

import br.com.gustainMars.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            persons.add(mock(i));
        }

        logger.info("Listing all persons!");
        return persons;
    }

    public Person findById(String id) {
        logger.info("Find one person!");
        return mock(1);
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }

    private Person mock(int i) {
        logger.info("Find one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gustavo" +  i);
        person.setLastName("Marques" + i);
        person.setAddress("Rua dos testes, " + i);
        person.setGender("Male");
        return person;
    }
}
