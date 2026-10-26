
package com.example.demo.controllers;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalArgumentException("Os valores devem ser numéricos");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number) {
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {

        validateNumbers(numberOne, numberTwo);
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public double multiply(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        validateNumbers(numberOne, numberTwo);
        return convertToDouble(numberOne) * convertToDouble(numberTwo);

    }

    @RequestMapping("/divide/{numberOne}/{numberTwo}")
    public double divide(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        validateNumbers(numberOne, numberTwo);
        return convertToDouble(numberOne) / convertToDouble(numberTwo);

    }
    private void validateNumbers(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new IllegalArgumentException(
                    "Os valores devem ser numéricos"
            );
        }
    }
}
