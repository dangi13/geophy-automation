Feature: Property Map interactions

  Background: User is logged in
    Given Patrice is already logged in

  Scenario: User should be able to filter by units
    Given Patrice is on Property Map screen
    And he filter by units with minValue "36" maxValue "40"
    Then Patrice see all resulted properties have Units in the range provided

  Scenario: User should be able to filter by Year Built
    Given Patrice is on Property Map screen
    And he filter by Year Built with minValue "1993" maxValue "1995"
    Then Patrice see all resulted properties have Year Built in the range provided

  Scenario: User should be able to filter by Neighborhood Type
    Given Patrice is on Property Map screen
    And he filter by Neighborhood Type with Urban Core and Inner Suburb
    Then Patrice see all resulted properties have Neighborhood Type that he selected

  Scenario: User should see an option to get in touch for Customize Evra insights
    Given Patrice is on Insights Portal screen
    And he sees heading on page [Customize Evra insights for your needs]
    And he see a blue button with text [GET IN TOUCH]
    And this button has link to email "mailto:evra.support@geophy.com"
