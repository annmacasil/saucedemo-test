Feature: Complete Purchase Order

  Rule: Successful completion of purchase order
    Scenario Outline: Verify user is able to successfully checkout items
      Given I am on the login page
      When I login using a valid username and password
      And I am navigated to the "Products" page
      And I sort the products by price from high to low
      And I see that products are sorted from high to low
      And I select two products that are $15.99 each
      And I click on the cart icon
      And On the "Your Cart" page, I see the products I have selected "<product1>" and "<product2>" are displayed
      And I click on Checkout button
      And On the "Checkout: Your Information" page, I entered the "<firstName>", "<lastName>" and "<zipCode>"
      And I click on Continue button
      And On the "Checkout: Overview" page, I see the products I have selected "<product1>" and "<product2>" are displayed
      And I see the Payment Information "<paymentInfo>", Shipping Information "<shippingInfo>" and Price Total "<totalPrice>"
      And I click on Finish button
      And I am navigated to the "Checkout: Complete!" page
      And I logout and being navigated to the login page
      And On the login page, I login using a "<lockedOutUsername>"
      Then I see an error message "Epic sadface: Sorry, this user has been locked out."
      And I am not able to login successfully

      Examples:

        | firstName | lastName | zipCode | paymentInfo      | shippingInfo                | totalPrice   | lockedOutUsername | product1                | product2                           |
        | Mary Ann  | Macasil  | 6000    | SauceCard #31337 | Free Pony Express Delivery! | $34.54       | locked_out_user   | Sauce Labs Bolt T-Shirt | Test.allTheThings() T-Shirt (Red)  |





