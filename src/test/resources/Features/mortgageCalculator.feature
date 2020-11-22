Feature: Mortgage Calculator

  @CalculateApr
  Scenario Outline: Calculate Real APR
    Given user is in Mortgage Calculator Home Page
    And user navigate to Real Apr page
    When user clicks on calculate button upon entering "<HomePrice>", "<DownPayment>" and "<InterestRate>"
    Then validate that Real Apr is "<AprRate>"

    Examples:
    |HomePrice|DownPayment|InterestRate|AprRate|
    |200000   |15000      |3           |3.130% |