Feature: Table user creation and deletion

  @Tc01
  Scenario Outline: Add user to table

    Given User launch the URL '<URL>' successfully
    And verify page title
    And Click on add User
    Then fill out form
    And click on save button
    Then verify Data is added to the table


    Examples:
      | URL       |
      | base_url |

  @Tc02
  Scenario Outline: delete user from table

    Given User launch the URL '<URL>' successfully
    And verify page title
    And verify userName is preset in the table '<user_name>'
    Then verify user deleted from table


    Examples:
      | URL       |user_name|
      | base_url |  novak |




