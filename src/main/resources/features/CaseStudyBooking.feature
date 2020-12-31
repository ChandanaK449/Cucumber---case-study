Feature: Testing Hotel Booking page

Scenario: Validate the error message when required fields are not entered
Given User is in Hotel Booking page
When First name is not entered
When Last name is not entered
When Email is not entered
When Mobile number is not entered
When Invalid mobile number is entered  
When address details are not entered 
When Payment details are not entered

Scenario: Enter the valid details for Hotel booking
Given User is in Hotel Booking page
When Valid details of the customer and payment are given
Then Booking should be successful
Then close the broswer