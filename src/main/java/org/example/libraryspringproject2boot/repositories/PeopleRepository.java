package org.example.libraryspringproject2boot.repositories;

import org.example.libraryspringproject2boot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional<Person> getByFullName(String fullName);

}
