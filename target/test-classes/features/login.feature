Feature: Test Login Page Functions

Scenario Outline: Validate multiple login data
Given User is on OrangeHRM login page
When User enter <Username> and <Password>
Then Validate login <Message> in the login page

Examples:
|Username|Password|Message|
|Admin|admin123|[blank]|
|AdminWrong|admin123|Invalid credentials|
|Admin|admin123Wrong|Invalid credentials|
|AdminWrong|admin123Wrong|Invalid credentials|

Scenario: Validate display of HRM logo
Given User is on OrangeHRM login page
Then Validate HRM Logo is displayed

Scenario: Validate Forgot your password function
Given User is on OrangeHRM login page
When Click on find your password button and input "Admin"
Then Validate confirmation "A reset password link has been sent to you via email." message

