Feature: Get top user with more songs liked

  Background:
    Given A data of users is in the database

  Scenario: Get top 3 user with more liked songs
    When is required to get top 3 of users
    Then the system return the top 3 of user