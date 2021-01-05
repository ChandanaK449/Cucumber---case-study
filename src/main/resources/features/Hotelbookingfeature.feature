Feature: Testing the login page

#Background: Login page should be launched


Scenario: Validate error message when credentials are not entered
Given User is on the Login page
Given Title of the page
When Username is not sent
Then Validate the error thrown
When password is not sent
Then Validate the error 


Scenario: Logging in valid credentials  and validating errors in Hotel Booking page
Given User is on the Login page
Then enter valid username and password
Then user login should be successful
#Scenario: Booking Hotel
Then Validate the error when first name is ""
And Enter the firstname
Then validate the error when Last name is empty
And Enter the Last name
Then Validate the error when email is not entered
And enter a valid Email
Then Validate the error when phone is not entered
Then Validate the error message when phone number is invalid
And enter a valid phone
And Enter Address 
When City is not selected throw error and select a city from the list
When State is not selected throw error and select a State from the list
And Enter the number of persons staying at the hotel
When Card holder name is not entered validate the error thrown
Then Enter the card holder name
When debit card number is not entered validate the error thrown
Then Enter the debit card number
When CVV is not entered validate the error thrown
Then Enter the cvv
When Expiration month is not entered validate the error thrown
Then Enter the Expiration month
When Expiration year is not entered validate the error thrown
Then Enter the Expiration year


Scenario: Successful Hotel booking
Given User is on the Login page
Then enter valid username and password
Then user login should be successful
Then Enter the details in the Hotel Booking page
|Firstname|Lastname|email|phone|City|state|NoOfGuests|CHname|CardNumber|CVV|Expmnth|ExpYear|
|Test|Automation|abc@gmail.com|9345167896|Hyderabad|Telangana|3|test|4564456445644564|152|12|25|
And confirm and verify if the booking is successful

