package com.github.qbek.screenplay.abilities;

public interface TestDataGenerator {
    UseCards createDebitCard();
    UseCards createCreditCard();
    UseAccount createAccount();
}
