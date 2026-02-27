package br.com.gustainMars.controllers;

import br.com.gustainMars.exception.UnsupportedMathOperationException;
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
    ) throws UnsupportedMathOperationException {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (isNotNumeric(strNumber)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNotNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) {
            return true;
        }

        String number = strNumber.replace(",", ".");
        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
