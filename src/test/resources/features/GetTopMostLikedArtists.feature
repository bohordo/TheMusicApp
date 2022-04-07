Feature: Get top most liked artists based on how many likes hey have in their songs

  Background:
    Given A data of artist is in the database

  Scenario: Get top 3 most liked artists
    When is required to get top 3 of liked artist
    Then the system return the top 3 liked artist

  Scenario: Get top 5 most liked artists
    When is required to get top 5 of liked artist
    Then the system return the top 5 liked artist
