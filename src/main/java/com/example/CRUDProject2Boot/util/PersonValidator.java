package com.example.CRUDProject2Boot.util;

import com.example.CRUDProject2Boot.models.Person;
import com.example.CRUDProject2Boot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    Person person=(Person) target;
    if(personService.getPersonByFullName(person.getFullName()).isPresent())
        errors.rejectValue("fullName","Person with such full name already exists");
    }
}
