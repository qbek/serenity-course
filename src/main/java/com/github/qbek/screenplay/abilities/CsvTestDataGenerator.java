package com.github.qbek.screenplay.abilities;

public class CsvTestDataGenerator implements TestDataGenerator {
    @Override
    public UseCards createDebitCard() {
        System.out.println("Karta debetowa z pliku CSV");
        return null;
    }

    @Override
    public UseCards createCreditCard() {
        System.out.println("Karta kredytowa z pliku CSV");
        return null;
    }

    @Override
    public UseAccount createAccount() {
        System.out.println("Kredentials z pliku CSV");
        return null;
    }
}
