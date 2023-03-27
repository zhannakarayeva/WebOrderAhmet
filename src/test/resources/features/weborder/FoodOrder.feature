Feature: WebOrder Page Food Functionality

  Scenario: Testing the happy path food order for My House
    Given User provides 'guest1@microworks.com' and 'Guest1!' for WebOrder
    And User validates the 'ORDER DETAILS - Weborder' title from homepage
    When User clicks Group Order Box and Next Button
    And User sends the word 'I love Cucumber' for note to the Invitees Section
    And User sends e-mail address which are 'ahmet@gmail.com' and 'mehmet@gmail.com' to the Invite List
    And User chooses the delivery adress 'My House' and validates the address '3137 Laguna Street'
    And User clicks the create Group Order Button
    Then User validates the header of page 'View Group Order'