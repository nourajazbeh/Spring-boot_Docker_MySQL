package com.docker.spring.service;

import com.docker.spring.model.Person;
import com.docker.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    
    public Person authenticate(String username, String password) {
        Person person = personRepository.findById(username).orElse(null);
        if (person != null && person.getPassword().equals(password)) {
            return person;
        }
        return null; // Rückgabe null, wenn die Authentifizierung fehlschlägt
    }
}