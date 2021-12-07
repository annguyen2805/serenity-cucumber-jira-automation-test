Feature: Search by keyword
@BOOK-1436
Scenario Outline: Searching for a term
Given Sergey is researching things on the internet test 123
When he looks up "<Cucumber>" abds
Then he should see information about "<Cucumber>" 3456
Examples:
| Cucumber | hai |
| 1234     | mot |
