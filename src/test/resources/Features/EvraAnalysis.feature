Feature: Evra property analysis

  Background: User is logged in
    Given Patrice Evra visits evra application
    And Patrice clicks login button
    When Submit username and password
    Then Patrice see Property Search Bar on the home page


  Scenario: User should be able to see Sample Property
    Given Patrice see Property Search Bar on the home page
    Then Patrice see tabs on the page header
      | Property Due Diligence |
      | Property Map           |
      | Insights Portal        |
    When he clicks View Sample Property link below Property search bar
    Then he should be navigated to Evra analysis page and see tab Overview with subsections
      | Property Details    |
      | Neighborhood        |
      | Location Benchmarks |
      | Sales Comps         |
