Feature: Habr search

  Scenario: Search
    Given Open site habr
    When Search text 'cucumber'
    Then Search results should contain 'cucumber'
