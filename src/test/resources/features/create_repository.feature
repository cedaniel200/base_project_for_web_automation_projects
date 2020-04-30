Feature: Create repository
  I as a free user I want to create a repository to start with the version of my source code

  # Falla
  Scenario: Creation of the repository
    Given Cesar wants to start versioning
    When Cesar creates a repository
    Then Cesar should see the repository created

    # Error
  Scenario: Creation of the repository from home
    Given Cesar authenticates from home
    Given Cesar wants to start versioning
    When Cesar creates a repository
    Then Cesar should see the repository created

    # Comprometida
  Scenario: Creation of the repository verifying connection
    Given Cesar realizes that there is connection
    Given Cesar wants to start versioning
    When Cesar creates a repository
    Then Cesar should see the repository created