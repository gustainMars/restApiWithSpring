package br.com.gustainMars.mapper.custom;

import br.com.gustainMars.data.dto.v2.PersonDTOv2;
import br.com.gustainMars.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

    public PersonDTOv2 convertEntityToDTO(Person person) {
        PersonDTOv2 dto = new PersonDTOv2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        dto.setBirthDay(person.getBirthDay());
        return dto;
    }

    public Person convertDtoToEntity(PersonDTOv2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setBirthDay(person.getBirthDay());
        return entity;
    }
}
