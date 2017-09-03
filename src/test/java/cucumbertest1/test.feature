Feature: Dashboard access 
Scenario: To check if kubernetes dashboard is installed after application is deployed
Given go To Kubernetes dashboard
When check webelement access
Then validate result
