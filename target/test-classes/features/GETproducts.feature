#Author: Solomon A. Habtu
Feature: Validate GET method is working for Products from the Product Pipeline API

  Background: Endpoint Configuration
    Given The endpoint is already configured

  @run
  Scenario Outline: Get products by name for product pipeline API is working
    When perform GET request with name "<name>"
    Then status code 200 OK should be returned
    And the return body "<key>" should have "<value>"

    Examples: 
      | name | key      | value                  |
      | java | prodName | java                   |
      | jira | prodDesc | defect management tool |

  @run
  Scenario: Get the right data for a valid product name
    When I input a valid product name "java"
    Then I should have the status code 200
    And content type should be in "JSON" format
    And the body response content should be matched
      | key      | value                                |
      | id       | 5a956ae6c9e77c0001566e24             |
      | prodName | java                                 |
      | prodDesc | object oriented programming language |

  @run
  Scenario: Get "product not found" message for invalid product name
    When I input a valid product name "java"
    Then "message": "prdouct not found" message should be returned
