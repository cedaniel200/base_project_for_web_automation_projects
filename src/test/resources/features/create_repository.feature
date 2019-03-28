Feature: Create repository
  I want to create a repository in github

  Scenario: Creation of the repository
    Given I want to start versioning
    When I create a repository in github
    Then I should see the repository created