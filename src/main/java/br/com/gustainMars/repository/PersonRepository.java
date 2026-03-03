package br.com.gustainMars.repository;

import br.com.gustainMars.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
