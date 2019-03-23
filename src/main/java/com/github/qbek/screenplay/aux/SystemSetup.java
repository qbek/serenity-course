package com.github.qbek.screenplay.aux;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.qbek.screenplay.abilities.Card;
import com.github.qbek.screenplay.abilities.Credentials;

public interface SystemSetup {
    void setupCredentials(Credentials credentials) throws JsonProcessingException;
    void setupCard(Card card) throws JsonProcessingException;;
}
