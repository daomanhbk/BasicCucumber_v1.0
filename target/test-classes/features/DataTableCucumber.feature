Feature: Log In
  
   
Scenario: Log In success: 

	Given New User navigates to Bank Guru Home Page "http://demo.guru99.com/v4"
	And I type account with user and pass 
		|username|password|
		|mngr226887|YtAgAnU|
	And User Click Login button
	And User verifies message log in successfully welcome to manager "Welcome To Manager"
	And User End chrome browser