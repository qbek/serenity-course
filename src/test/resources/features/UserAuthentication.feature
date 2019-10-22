Feature: User authentication

  Scenario: Basic user authentication
    Given Helmut has an active account
    When he sends his credentials
    Then he is logged in


  Scenario: AuthToken user authentication
    Given Mark has active account with authToken authentication
    When he sends his credentials
    Then he is logged in
