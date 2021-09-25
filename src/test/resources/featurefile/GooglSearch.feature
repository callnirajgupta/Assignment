@Google
Feature: Google search

  @login1
  Scenario: Open Google, search for "J. P. Morgan", click the first result returned by Google, verify that the J.P. Morgan logo is shown.
    Given user navigates to Google search page
    When user search for "J. P. Morgan" in Google search page
    And user click the first result returned by Google
    Then verify that the J.P. Morgan logo is displayed
    
   