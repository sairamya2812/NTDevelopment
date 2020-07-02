Feature: Open Cart Application
Scenario: Verify Login Func
Given User on the Home Page
When User enters valid login id and password and clicks login button
Then User must be on page with title

Scenario Outline: Verify order placement from search box
Given User has logged in the app
When User enters a "<Product>" name in search box
And User adds the product to Cart and checkout
Then User should be able to confirm the order placement
When User clicks logout button
Then User should be logged out

Examples:
|Product|
|iPod Classic|
|iPod|
|iPod Touch|



 