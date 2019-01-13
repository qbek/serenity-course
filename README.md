# Serenity course

## Set up Stage and Cast

First of all we need to setup our `Stage` object. It represents an execution environment for scenario.  `Stage` object contains a `Cast` - a manager for all our actors in scenario.

`OnStage` is a thread safe stage manager for scenarios. Using it gives you support for safe parallel test execution. OnStage object will manage separate Stage object for each scenario, so you are sure, that one scenario doesn't overwrite test data form another scenario executed at the same time.

I created a `setup()` function, marked with Cucumber `@Before` hook, so this function executes at beginning of scenario. This is a good place to setup or `Stage` with new, empty `Cast`.

```java
public class CardBalanceSteps {
    @Before
    public void setup() {
        OnStage.setTheStage(new Cast());
    }    
    
    //...
}
```

Once we have `Stage` created we can start to call our first actor. I've created a step function for first step of example scenario. User name is injected as a parameter to handling function. I use this name to get our first `Actor` object using function `theActorCalled(name)` from global `OnStage` object - so I'm sure that received `Actor` is a deciated object for this scenario.

Function `theActorCalled(name)` does:
1. Check if `Actor` with name was already created in `Cast` object and returns him.
2. If there is no such `Actor` creted before - it creates a new `Actor`, adds it to the `Cast` and returns him.
3. For both cases it also sets a `spotlight` on that `Actor` (more details in a moment)

```java
    @Given("^(\\w+) is a card user with active account$")
    public void carlIsACardUserWithActiveAccount(String name) throws Throwable {
        // Checks if actor was already created
        // If not - creates a new one and stores in Cast object
        Actor user = OnStage.theActorCalled(name);
    }
```

To retrieve already created `Actor` we have 3 options:
1. Use `theActorCalled(name)` function
2. Use `theActorCalled(pronoun)` - same as above, but when you pass 'he', 'she'... it will return an `Actor` marked with `spotlight` - so it is last used, default, one.
3. Use 'theActorInTheSpotlight()' function to also return `Actor` marked with spotlight`. This function is used in steps, where we cannot pass name or pronoun for `Actor` selection

Let's try way 2 or 3 in next step implementation:

```java
    @And("^(\\w+) is logged in his account$")
    public void heIsLoggedInHisAccount(String name) throws Throwable {
            // Last used actor has set spotlight on him
            // can be used in steps without actor name    
            Actor user = OnStage.theActorInTheSpotlight();
            
            // same result with using pronun: 'he', 'she'...
            // Actor user = OnStage.theActorCalled(name);
            System.out.println("Actor in the spotlight is: " + user.getName());
        }
```

## Previous chapters:
1. Development environment setup, git repository tag: [01_env_setup](https://github.com/qbek/serenity-course/tree/01_env_setup)