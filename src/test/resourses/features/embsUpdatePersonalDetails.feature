#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)

Feature: As a User I want to update my personal details in EMBS so then I can keep my data up to date 

Background: Logged In and viewed personal details
Given User is logged in to EMBS application
#And User has viewed personal details 



#positiveScenario 
Scenario: Update Campus Code to City
When I select Campus Code as City
When I click Update_User_Details
When I click Return_to_My_Account
When I click My_Personal_Details
Then I will be able to view Campus Code as City