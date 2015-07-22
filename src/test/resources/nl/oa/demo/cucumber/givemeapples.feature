Feature: Give me apples
  Give the customer the amount of apples he wants

  Scenario: Give the customer 1 apple
    Given the seller has '10' apples to sell
    When the customer asks for '1' apple
    Then the customer gets '1' apple from the seller
