Feature: Login Action

  Scenario Outline: Successful Login with example keyword
    Given User navigates to Bank Guru Home Page "http://demo.guru99.com/v4"
    When User input "<username>" and "<password>"
    And Click Login button
    And I verify "<username>" is displayed correctly
    Then Close Chrome browser

    Examples: 
      | username   | password |
      | mngr227323 | rEsUpUz |
      | mngr227325 | EbAhUre |
      | mngr227326 | jemUdAh |
