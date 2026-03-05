package br.com.gustainMars.services;

import br.com.gustainMars.exception.ResourceNotFoundException;
import br.com.gustainMars.exception.message.PersonExceptionEnum;
import br.com.gustainMars.model.Person;
import br.com.gustainMars.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        logger.info("Listing all persons!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Find one person!");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PersonExceptionEnum.NO_RECORD_FOUND_FOR_ID.getMessage()));
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Person person) {
        Person entity = findById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Person entity = findById(id);
        logger.info("Deleting one person!");
        repository.delete(entity);
    }
}
