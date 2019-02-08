Feature: Query URL 

@dashboard-access
Scenario: To check if kubernetes dashboard is installed after application is deployed
Given download WebService Response In LocalFile
When get String From WebService
Then validate result
