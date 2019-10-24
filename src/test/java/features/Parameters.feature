Feature: upload product
  
   
Scenario: Log In success: 

	When I navigate to Log in Bank guru page "http://demo.guru99.com/v4"
	And I input account with username "mngr226918" and password "erEqepa" 
	And Click Login 
	And User verify message log in successfully welcome to manager "Welcome To Manager"
	And User closes chrome browser