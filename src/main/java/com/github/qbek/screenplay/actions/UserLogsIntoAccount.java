package com.github.qbek.screenplay.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.github.qbek.screenplay.questions.Questions.authorization;
import static org.junit.Assert.assertTrue;


public class UserLogsIntoAccount implements Task {

    @Override
    public <T extends Actor> void performAs(T user) {
        boolean isAuthorized = user.asksFor(authorization());
        assertTrue("User is not logged in", isAuthorized);
    }
}
