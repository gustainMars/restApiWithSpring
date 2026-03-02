package br.com.gustainMars.services;

import br.com.gustainMars.exception.UnsupportedMathOperationException;
import br.com.gustainMars.exception.message.MathExceptionEnum;
import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public Double subtraction(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public Double multiply(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    public Double divide(String strNumberOne, String strNumberTwo) {
        Double numberOne = convertToDouble(strNumberOne);
        Double numberTwo = convertToDouble(strNumberTwo);

        if (numberOne == 0 || numberTwo == 0) {
            throw new UnsupportedMathOperationException(MathExceptionEnum.CANT_DIVIDE_ZERO.getMessage());
        }

        return numberOne / numberTwo;
    }

    public Double mean(String strNumberOne, String strNumberTwo) {
        Double numberOne = convertToDouble(strNumberOne);
        Double numberTwo = convertToDouble(strNumberTwo);

        return (numberOne + numberTwo)/ 2;
    }

    public Double squareRoot(String strNumberOne) {
        Double numberOne = convertToDouble(strNumberOne);

        return Math.sqrt(numberOne);
    }

    @Nonnull
    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (isNotNumeric(strNumber)) {
            throw new UnsupportedMathOperationException(MathExceptionEnum.SET_NUMERIC_VALUE.getMessage());
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
