# Serenity course

# Create first ability

`Ability` object is a screenplay way to manage test data. Let's create our first such object called `Card` - it will store a plastic card details needed for our scenario.

I've created a new class in `src/` directory, in package `com.github.qbek.screenplay.testdata` with content:

```java
public class Card implements Ability {
    private String pan;
    private String expDate;
    private double balance;

    public Card (String pan, String expDate, double balance) {
        this.pan = pan;
        this.expDate = expDate;
        this.balance = balance;
    }

    public String getPan() {
        return pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
```

As you can see, `Card` class stores pan, expiration date and balance, and only for balance we have setter. Pan and expiration date can be set only via `Card` constructor. Why? Because actor in our system cannot change PAN of his card. As a standard card user he can change only a balance of it. So, our class represents it - it will secure data, which cannot be changed, to prevent some silly mistakes in scenario.

Now in step, where a card is mentioned for the first time, I created a new card (using faker library to generate some funny random data).

```java
    Faker faker = new Faker();

    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        // Checks if actor was already created
        // If not - creates a new one and stores in Cast object
        Actor user = OnStage.theActorCalled(name);
        
        Card card = new Card(
                faker.numerify("1100 01## #### ####"),
                faker.business().creditCardExpiry(),
                faker.number().randomDouble(2, 100, 2123)
        );
    }
```

## Exercise

Create `Account` class with credential details (username, password). Do not forget to create also `Account` object in correct step. 


## Previous chapters:
1. Development environment setup, git repository tag: [01_env_setup](https://github.com/qbek/serenity-course/tree/01_env_setup)
2. Set up Stage and Cast, git repository tag: [02_stage_and_cast](https://github.com/qbek/serenity-course/tree/02_stage_and_cast)