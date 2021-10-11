#Author: 

Feature: Test DemoQA Site

 @sanityQA
 Scenario: Test DemoQA Dashboard page
  Given I want to load DemoQA page
 	When The page got loaded
 	Then Validate the box present at first
 		|element|Forms|Alerts, Frame & Windows|Widgets|Interactions|Book Store Application|
 	