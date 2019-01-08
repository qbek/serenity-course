Feature: Card balance

  Scenario: Card user can check his card balance

    Given Carl is a card user with active account
    And he is logged in his account
    When Carl checks his card balance
    Then correct balance is presented