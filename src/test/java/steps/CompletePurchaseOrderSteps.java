package steps;

import common.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CompletePurchaseOrderPage;

import java.io.IOException;

public class CompletePurchaseOrderSteps {

    public CompletePurchaseOrderPage order;
    WebDriver driver;

    @Before
    public void setUp() throws IOException {
        WebDriverConfig config = new WebDriverConfig();
        driver = config.initializeWebDriver();
        this.order = new CompletePurchaseOrderPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        order.verifyLoginPage();
    }

    @When("I login using a valid username and password")
    public void i_login_using_a_valid_username_and_password() {
        order.login();
    }

    @And("I am navigated to the {string} page")
    public void i_am_navigated_to_the_page(String pageName) {
        order.verifyPage(pageName);
    }

    @And("I sort the products by price from high to low")
    public void i_sort_the_products_by_price_from_high_to_low() {
        order.selectSortPriceHighToLow();
    }

    @And("I see that products are sorted from high to low")
    public void i_see_that_products_are_sorted_from_high_to_low() {
        order.verifyProductsAreSortedFromHighToLow();
    }

    @And("I select two products that are $15.99 each")
    public void i_select_products_with_price() {
        order.selectProducts();
    }

    @And("I click on the cart icon")
    public void i_click_on_the_cart_icon()  {
        order.clickCartIcon();
    }

    @And("On the {string} page, I see the products I have selected {string} and {string} are displayed")
    public void on_the_page_the_items_i_have_selected_are_displayed(String pageName, String product1, String product2) {
        order.verifyPage(pageName);
        order.verifyItemsAreDisplayed(product1,product2);
    }

    @And("I click on Checkout button")
    public void i_click_on_checkout_button() {
        order.clickCheckoutButton();
    }

    @And("I click on Continue button")
    public void i_click_on_continue_button() {
        order.clickContinueButton();
    }

    @And("I click on Finish button")
    public void i_click_on_finish_button() {
        order.clickFinishButton();
    }

    @And("On the {string} page, I entered the {string}, {string} and {string}")
    public void on_the_page_i_entered_the_and(String pageName, String firstName, String lastName, String zipCode) {
        order.verifyPage(pageName);
        order.enterPersonalInformation(firstName, lastName, zipCode);
    }

    @And("I see the Payment Information {string}, Shipping Information {string} and Price Total {string}")
    public void i_see_the_payment_information_shipping_information_and_price_total(String paymentInfo, String shippingInfo, String totalPrice) {
        order.verifyPaymentInformation(paymentInfo, shippingInfo, totalPrice);

    }

    @And("I logout and being navigated to the login page")
    public void i_logout_and_being_navigated_to_the_login_page() {
        order.clickLogout();
        order.verifyLoginPage();
    }

    @And("On the login page, I login using a {string}")
    public void on_the_login_page_i_login_a_username(String lockedOutUsername)  {
        order.enterLockedOutAccount(lockedOutUsername);
    }

    @Then("I see an error message {string}")
    public void i_see_an_error_message(String errorMessage) {
        order.verifyErrorMessage(errorMessage);
    }

    @Then("I am not able to login successfully")
    public void i_am_not_able_to_login_successfully() {
        order.verifyLoginPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
