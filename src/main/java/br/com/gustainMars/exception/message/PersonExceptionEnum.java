package br.com.gustainMars.exception.message;

public enum PersonExceptionEnum {
    NO_RECORD_FOUND_FOR_ID("No record found for this id!");

    private final String message;

    PersonExceptionEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
