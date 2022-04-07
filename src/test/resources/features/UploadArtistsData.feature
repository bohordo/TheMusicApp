Feature: Upload the artists data to the database
  Scenario: Upload the artists data to the database
    Given A valid users data file
    When when the data is uploaded
    Then the system return a valid response