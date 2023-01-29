Feature: Order an item

Scenario Outline: Search and and Order an item in BigCommerce site

Given I have a product in my cart
When I complete the checkout process
Then I am presented with a purchase confirmation page for my order