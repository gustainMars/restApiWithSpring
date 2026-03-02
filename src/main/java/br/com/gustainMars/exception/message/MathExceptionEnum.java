package br.com.gustainMars.exception.message;

public enum MathExceptionEnum {
    SET_NUMERIC_VALUE("Please set a numeric value!"),
    CANT_DIVIDE_ZERO("It's not possible to divide a number by zero!");

    private final String message;

    MathExceptionEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
