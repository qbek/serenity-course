# Serenity course

## Ability factories plus

We can use our test data factories (abilities) to inject generated data into our system under test. In real life project it can be a SQL insert command, or exposed REST api. 

In our case I will use mock-server to simulate such action.

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
5. Ability factories plus