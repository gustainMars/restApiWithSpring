package br.com.gustainMars.services;

import br.com.gustainMars.data.dto.v1.PersonDTO;
import br.com.gustainMars.exception.ResourceNotFoundException;
import br.com.gustainMars.exception.message.PersonExceptionEnum;
import static br.com.gustainMars.mapper.ObjectMapper.parseListObject;
import static br.com.gustainMars.mapper.ObjectMapper.parseObject;

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

    public List<PersonDTO> findAll() {
        logger.info("Listing all persons!");
        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Find one person!");
        var entity = findByIdEntity(id);
        return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        Person entity = findByIdEntity(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        Person entity = findByIdEntity(id);
        logger.info("Deleting one person!");
        repository.delete(entity);
    }

    private Person findByIdEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PersonExceptionEnum.NO_RECORD_FOUND_FOR_ID.getMessage()));
    }
}
