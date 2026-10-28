package com.example.demo.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestLogController {

    private Logger logger = (Logger) LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog(){
        logger.info("INFO");
        logger.warning("WARNING");
        logger.warning("WARNING");
        return "testLog";
    }
}
