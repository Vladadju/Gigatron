Feature: Sorting

# Sorting options: score, rastuci, opacajuci, naziv, rejting
  Scenario Outline: Sort by "<sortingMethod>"
    Given I am on products page
    When I click sort by "<sortingMethod>"
    Then I should see products sorted "<sortingMethod>"

    Examples:
      | sortingMethod |
#      | rastuci       |
#      | opadajuci     |
      | naziv     |
#      | rejting   |
#      | score     |
