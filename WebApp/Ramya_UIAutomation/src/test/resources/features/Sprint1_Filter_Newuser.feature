
#Given the web application,
#http://ec2-54-84-52-184.compute-1.amazonaws.com:8080/admin/
#§  Define and Implement Automated Tests in Java.
#§  Define and implement tests for New User Screen.
#§  Define and implement tests for User - Filters.
#§  Demonstrate usage of best practices in UI test automation

Feature: verify and Test Admin page and New user
  Background:  run the for steps
#    Given As user open the browser and enter the application url
#    When As user validate the ladingpage and click on Users on menu bar







#  Scenario: for Given web application verify the user- filters
#    Given As user open the browser and enter the application url
#    When As user validate the ladingpage and click on Users on menu bar
#    Then validate fields usernamedropdown,userinputvalue,emildropdown,emailinput,frominput,toinput


#  Scenario Outline: for given Web application validate verify filter button option
#      Given As user open the browser and enter the application url
#      When As user validate the ladingpage and click on Users on menu bar
#      And Enter the values in "<usernamedropdown>","<userinputvalue>","<emildropdown>","<emailinput>","<frominput>","<toinput>"
#      And Click on Filter button
#      Then validate data output based input data"<outputvalidation>"
#
#      Examples:
#      |usernamedropdown|userinputvalue|emildropdown|emailinput        |frominput  |toinput  |outputvalidation|
#      |Contains        |ra            |           |                   |           |         |                |
#      |Equals          |ramakrishnaz  |           |                   |           |         |No Users found |
#      |Starts with     |@ra           |           |                   |           |         |No Users found |
#      |Ends with       |@ra           |           |                   |           |         |No Users found |
#


    #test 2 verify reset value for all fields
#    Scenario Outline: for given Web application validate verify Clear filter option
#      And Enter the values in "<usernamedropdown>","<userinputvalue>","<emildropdown>","<emailinput>","<frominput>","<toinput>"
#      And Click on Clear Filters button
#      Then Verify input fields reset back default values "<resetusernamedropdown>","<resetuserinputvalue>","<resetemildropdown>","<resetemailinput>","<resetfrominput>","<resettoinput>"
#     Examples:
#      |usernamedropdown|userinputvalue|emildropdown|emailinput        |frominput  |toinput    |resetusernamedropdown|resetuserinputvalue|resetemildropdown|resetemailinput|resetfrominput|resettoinput|
#      |Contains        |Test123       |Contains    |@yahoo.com        |2019-04-30 |2019-04-30 |Contains             |               |Contains         |           |          |        |
#      |Equals          |rama          |Equals      |test123@gmail.com |2019-03-30 |2019-04-30 |Contains             |               |Contains         |           |          |        |
#      |Starts with     |Johan         |Starts with |a                 |2019-01-30 |2019-04-30 |Contains             |               |Contains         |           |          |        |
#      |Ends with       |Kirshna       |Ends with   |.com              |2019-02-26 |2019-04-30 |Contains             |               |Contains         |           |          |        |
#


##Test date verification
#Scenario Outline: for Give Web Application validate input from to input dates
#    When As user validate "<fromdt>" and "<todate>"
#    Then validate Error Message for different input "<validdateMessge>"
#      #valid- fromdt is greaeter then todate    #valid - fromdt is equal to todate
#      #invalid - fromdt is less then todate      #validdate
#     Examples:
#    |fromdt    |todate    |validdateMessge|
#    |2019-04-01|2018-12-29|Created at greater or equal to|


  Scenario Outline: Create a new user for give page
    When As user validate the ladingpage and click on Users on menu bar
    Given  As user Click on  New User button
    When As user Enter "<UserName>","<Password>","<emailid>"
    And User click on CreateUser
    Then As User verify the data from the list
    Examples:
      |UserName   |Password|emailid|
      |Ramya2019Test|@Lt12345|ramya@gmail.com|