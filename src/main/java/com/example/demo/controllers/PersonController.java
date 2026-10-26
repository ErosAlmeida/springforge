package com.example.demo.controllers;

import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{
  //private PersonService service = new PersonService();

    @Autowired
    private PersonService service;
}
