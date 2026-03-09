package br.com.gustainMars.enums;

public enum GenderEnum {
    M("Male"),
    F("Female");

    private final String message;

    GenderEnum(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }
}
