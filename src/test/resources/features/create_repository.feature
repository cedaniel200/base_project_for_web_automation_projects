Feature: Create repository
  As a free user
  I want to create a repository
  So that start with the version of my source code

  Scenario: Creation of the repository
    Given Cesar wants to start versioning
    When Cesar creates a repository
    Then Cesar should see the repository created

