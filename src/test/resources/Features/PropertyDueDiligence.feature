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

  Scenario: User should be able to search property and run valuation
    Given Patrice see Property Search Bar on the home page
    And Patrice searches this address "555 N. College Avenue, Tempe, AZ, 85281" and selects
    And Patrice clicks on Valuation Tab
    And Patrice enters valuation inputs
      | Number of Units | Year of Construction | Net Operating Income |
      |             200 |                 2000 | $2,000,000           |
    And Patrice clicks on RUN VALUATION button
    Then Patrice sees Property Details section