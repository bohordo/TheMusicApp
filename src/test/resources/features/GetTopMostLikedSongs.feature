Feature: Get top most liked songs

  Background:
    Given A data of songs is in the database

  Scenario: Get top 5 most liked artists
    When is required to get top 5 of liked songs
    Then the system return the top 5 liked songs

  Scenario: Get top 10 most liked artists
    When is required to get top 10 of liked songs
    Then the system return the top 10 liked songs

  Scenario: Get top 15 most liked artists
    When is required to get top 15 of liked songs
    Then the system return the top 15 liked songs
