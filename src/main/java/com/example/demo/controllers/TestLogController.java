
package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private static final Logger logger =
            LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/test")
    public String testLog() {
        logger.info("INFO");
        logger.warn("WARNING");
        logger.warn("WARNING");

        return "testLog";
    }
}
