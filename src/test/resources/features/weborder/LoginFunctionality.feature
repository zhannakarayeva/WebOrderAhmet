Feature: Testing Login functionality of WebOrder Page
  Scenario: Testing positive login(correct username+correct password)
    When User provides {login} and {password} for WebOrder
    Then User validates the {title} title from homepage