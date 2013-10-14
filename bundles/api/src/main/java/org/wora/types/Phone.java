package org.wora.types;

public class Phone {
    final String countryCode;
    final String stdCode;
    final String number;

    public Phone(String countryCode, String stdCode, String number) {
        this.countryCode = countryCode;
        this.stdCode = stdCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", countryCode, stdCode, number);
    }
}
