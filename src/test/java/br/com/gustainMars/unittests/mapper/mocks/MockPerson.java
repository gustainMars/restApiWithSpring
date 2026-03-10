package br.com.gustainMars.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.gustainMars.data.dto.PersonDTO;
import br.com.gustainMars.model.Person;

import static br.com.gustainMars.mapper.ObjectMapper.parseObject;

public class MockPerson {

    public Person mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockDTO() {
        return mockDTO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockDTOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public PersonDTO mockDTO(Integer number) {
        return parseObject(mockEntity(number), PersonDTO.class);
    }

    public static Person mockEntity(Integer number) {
        var person = new Person();
        person.setId(number.longValue());
        person.setFirstName("First Name Test" + number);
        person.setLastName("Last Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setAddress("Address Test" + number);
        return person;
    }
}