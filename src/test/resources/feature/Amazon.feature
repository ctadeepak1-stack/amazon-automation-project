Feature: Amazon Automation

  Scenario: Search product and add to cart
    Given user opens Amazon website
    When user searches for "iphone"
    And user selects first product
    And user adds product to cart
    Then product should be added successfully