Feature: Booking Hotel room

#Background: Login page should be launched


Scenario: Validate error message when credentials are not entered for login page
Given User is on the Login page
Given Title of the page
When Username is not sent
Then Validate the error thrown
When password is not sent
Then Validate the error 

Scenario: Case study - solution Hotel booking Handling all errors
Given User is on the Login page
Given Title of the page
Then enter valid username and password
Then user login should be successful
Then Enter the details for Hotel Booking page
And confirm and verify if the booking is successful


Scenario: Successful Hotel booking using datatable
Given User is on the Login page
Given Title of the page
Then enter valid credentials
|admin|admin|
Then user login should be successful
Then Enter the details in the Hotel Booking page
|Firstname|Lastname|email|phone|City|state|NoOfGuests|CHname|CardNumber|CVV|Expmnth|ExpYear|
|Test|Automation|abc@gmail.com|9345167896|Hyderabad|Telangana|3|test|4564456445644564|152|12|25|
And confirm and verify if the booking is successful

