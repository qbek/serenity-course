# Serenity course


## Ability description in report

I've added following code to `UseCard` class:

```java
    public String toString() {
        return "use following card: " + pan + ", with balance: " + balance;
    }
```

It's a simple toString method, which sets ability description in Serenity Report

Let generate report from our test and check it out! In project root directory execute commands:

```bash
    mvn clean verify
    mvn serenity:aggrefate 
```

Now open `target/site/serenity/index.html` in your favourite browser, navigate to test scenario and check "Cast" section.
It looks great now! ;)

### Exercise

Add some description to `UseAccount` ability.


## Previous chapters:
1. Development environment setup, git repository tag: `01_env_setup`
2. Set up Stage and Cast, git repository tag: `02_stage_and_cast`
3. Creating abilities