# Serenity course

## Ability factories

We have developed a lot of code. So this is a good moment to clean it up a little.

I've renamed `CardBalanceSteps.java` to `PreconditionSteps.java` (as it better describes what types of steps are handled. 
I've also moved all *Steps classes to `com.github.qbek.screenplay.step` package.

Next step is to clean up our step logic functions - the problem is that currently precondition step functions do to much. Let's use factory pattern, and create separate class specialized in Card abilities creation.

Inside `com.github.qbek.screenplay.abilities` package, I've created new `CardFactory` class, with following content:

```java
public class CardFactory {

    private static Faker faker = new Faker();


    public static UseCard useValidCard() {
        return new UseCard(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );
    }

    //In case when we have a specialized class in creating card abilities
    //we can crate many types of cards... for example a expired one.
    public static UseCard useExpiredCard() {
        return new UseCard(
                faker.numerify("1100 01## #### ####"),
                "10/18",
                faker.number().randomDouble(2, 100, 2123)
        );
    }
}
```

Now precondition step looks better:

```java
    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        // Checks if actor was already created
        // If not - creates a new one and stores in Cast object
        Actor user = OnStage.theActorCalled(name);

        UseAccount useAccount = new UseAccount(
                faker.dragonBall().character(),
                faker.superhero().power()
        );

        // Now we are creating our card ability using static CardFactory function.
        user.can(useValidCard());
        user.can(useAccount);
    }
```

### Exercise

Next step is yours! Write your own AccountFactory, and clean more our precondition step.

### Solution

I've created `AccountFactory` class next to `CardFactory` class, with following content:

```java
public class AccountFactory {

    private static Faker faker = new Faker();

    //for now both functions looks quite similar....
    public static UseAccount useActiveAccount() {
        return generateAccount();
    }

    //...well, they are the same to be honest
    //but it will change in a moment ;)
    public static UseAccount useInactiveAccount() {
        return generateAccount();
    }

    private static UseAccount generateAccount() {
        return new UseAccount(
                faker.dragonBall().character(),
                faker.superhero().power()
        );
    }
}
```


## Previous chapters:
1. Development environment setup, git repository tag: `01_env_setup`
2. Set up Stage and Cast, git repository tag: `02_stage_and_cast`
3. Creating abilities
4. Ability description in report
