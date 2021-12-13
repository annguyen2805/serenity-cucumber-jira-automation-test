Feature: Search by keyword

  Scenario Outline: Searching for a term
    Given Sergey is researching things on the internet
    When he looks up "<key>"
    Then he should see information about "<key>"
    Examples:
      | key      |
      | Cucumber |
      | Selenium |

