Feature: Upload the songs data to the database
  Scenario: Upload the song data to the database
    Given A valid songs data file
    When when the data is uploaded
    Then the system return a valid response