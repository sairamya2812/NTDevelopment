Feature: Verifying Open Cart Application
Scenario: User Login the application
When User clicks the Login link
And User enters user name and password
And User clicks the Login button
Then User verifies if the title is "My account"

Scenario Outline: Verify order placement from search textbox
Given: User has logged in and is on the Myaccount page 
When: User enters the "<Product>" name in search box and clicks search icon
And User select a "<Product>" from search results
And User clicks Add to cart
And User moves to the cart and proceed to checkout
Then User should be able to get the order confirmation
Examples: 
|Product|
|iPod Classic|
|iPod Nano|
|iPod Touch|

 Scenario: User Logs out of the Application
 When: User clicks Logout button option
 Then User should be on the Home Page
