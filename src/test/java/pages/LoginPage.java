package pages;

import common.BasePage;
import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By nextPage = By.xpath("//*[@class='app_logo']");

    public void login(String username, String password){
        enterText(usernameField,username);
        enterText(passwordField,password);
        click(loginButton);

    }

    public void navigatedToNextPage(){
        waitVisibility(nextPage);

    }
    public void verifyPageName(String pageName) throws Exception {
        isDisplayed(nextPage);
        assertEquals(getText(nextPage), pageName);

    }

}
