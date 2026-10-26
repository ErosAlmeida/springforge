
package com.example.demo.service;

import com.example.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private static final Logger logger =
            LoggerFactory.getLogger(PersonService.class);

    public Person findById(String id) {
        logger.info("findById chamado com id: {}", id);

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("yuumi");
        person.setLastName("shu");
        person.setAddress("minass");
        person.setGender("male");

        return person;
    }
}
