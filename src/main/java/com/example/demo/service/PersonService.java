
package com.example.demo.service;

import com.example.demo.controllers.TestLogController;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private java.util.logging.Logger logger = (Logger) LoggerFactory.getLogger(TestLogController.class.getName());

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all People!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one Person!");

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No records found for this ID!"));

        repository.delete(entity);
    }
}
