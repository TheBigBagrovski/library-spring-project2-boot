package org.example.libraryspringproject2boot.util;

import org.example.libraryspringproject2boot.models.Person;
import org.example.libraryspringproject2boot.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(peopleRepository.getByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "Человек с таким ФИО уже существует");
        }
    }

}
