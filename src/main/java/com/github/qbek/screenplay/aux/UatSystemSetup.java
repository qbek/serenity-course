package com.github.qbek.screenplay.aux;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.Credentials;

public class UatSystemSetup implements SystemSetup {
    @Override
    public void setupCredentials(Credentials credentials) throws JsonProcessingException {}

    @Override
    public void setupCard(Card card) throws JsonProcessingException {

    }
}
