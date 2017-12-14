Feature: Login to PGS

Background: 
   Given User navigates to Webpage  
   
Scenario: Check the Webpage Tiltle
When Enter URL and check page title
Then Page title should be Google 

Scenario: Login with Valid Credentials
When Enter valid UserName and Password
Then User should be able to login Successfully

Scenario: Login with Invalid Credentials
When Enter invalid UserName and Password
Then User fail to log in 