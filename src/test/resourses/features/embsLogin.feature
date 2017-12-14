Feature: As a user I want to Login to EMBS so then I can access to the EMBS test environment  


Background: RMIT Staff account enabled for EMBS 
# Given User has an active RMIT Staff account that has been granted a suitable level of access for the EMBS test environment 
Given I access the EMBS _application URL 


Scenario: Checking the EMBS page load successfully 
Then I will see page title 

#positiveScenario  
Scenario: Check for Successful login   
When I enter correct RMIT_ID and Password  
When I click Login_to_Bookings 
Then I will be redirected to the EMBS_Main_Menu  


#negativeScenario  
Scenario: Checking for Unsuccessful login   
When I enter incorrect RMIT_ID and Password  
When I click Login_to_Bookings  
Then I will see an Error message 'Login error : either username or password was not recognised - please try again!' 