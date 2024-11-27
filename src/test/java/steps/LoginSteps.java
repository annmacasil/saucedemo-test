package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import java.io.IOException;

public class LoginSteps {
    private LoginPage login = new LoginPage();

    @Given("I am on the SauceDemo page")
    public void i_am_on_the_sauce_demo_page() throws IOException {
        login.navigateTo("https://www.saucedemo.com/");
    }

    @When("I login using a valid username and password")
    public void loginValidCredentials(){
        login.login("standard_user","secret_sauce");
    }

    @Then("I should be able to login successfully")
    public void successfulLogin(){
        login.navigatedToNextPage();
    }

    @And("I see the {string} page")
    public void iSeeTheSwagLabPage(String pageName) throws Exception {
        login.verifyPageName(pageName);
    }
}
