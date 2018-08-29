Feature: Create repository
  I want to create a repository in github

  Scenario: Creation of the repository
    Given I want to start versioning
    When you create a repository in github
    Then I should see the repository created

  Scenario Outline: Creation of the repository with data
    Given I want to start versioning in GitHub
      |   username  |  password   |
      |   <username>  |   <password>    |
    When you create a repository in github with the data
    |    <name>    |         <description>         |
    Then I should see the "<name>" repository created

  Examples:
  |   username  |  password   |    name    |         description         |
  | an_username | a_password  | TEST_BDD_2 |  repository for bdd tests 2 |
  | an_username | a_password  | TEST_BDD_3 |  repository for bdd tests 3 |