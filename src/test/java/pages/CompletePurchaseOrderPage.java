package pages;

import common.BasePage;
import common.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotsUtil;

import java.io.IOException;
import java.util.Properties;

import static net.bytebuddy.description.type.TypeList.Generic.ForDetachedTypes.attach;
import static org.testng.AssertJUnit.assertEquals;

public class CompletePurchaseOrderPage extends BasePage {
    Properties property;
    public byte[] screenshot;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginPageTitle = By.xpath("//*[@class='login_logo']");
    private final By pageNameTitle = By.xpath("//*[@class='title']");
    private final By cartIcon = By.id("shopping_cart_container");
    private final By MenuIcon = By.id("react-burger-menu-btn");
    private final By logoutMenu = By.id("logout_sidebar_link");
    private final By checkoutButton = By.id("checkout");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By paymentInfoLocator = By.cssSelector("[data-test='payment-info-value']");
    private final By shippingInfoLocator = By.cssSelector("[data-test='shipping-info-value']");
    private final By totalPriceLocator = By.cssSelector("[data-test='total-label']");
    private final By finishButton = By.id("finish");
    private final By errorMessageLocator = By.xpath("//*[@class='error-message-container error']");
    private final By sortLocator = By.xpath("//*[@class='product_sort_container']");
    private final By displayedProductsLocator = By.xpath("//*[@class='inventory_item_name']");
    private final By product1Locator = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By product2Locator = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private final By product1Display = By.id("item_1_title_link");
    private final By product2Display = By.id("item_3_title_link");


    public CompletePurchaseOrderPage(WebDriver driver) throws IOException {
        super(driver);
        WebDriverConfig config = new WebDriverConfig();
        this.property = config.loadFileConfig();
        this.screenshot = ScreenshotsUtil.takeScreenshot(driver);

    }

    public void login() {
            enterText(usernameField, property.getProperty("username"));
            enterText(passwordField, property.getProperty("password"));
            click(loginButton);

    }

    public void verifyLoginPage() {
        isDisplayed(loginPageTitle);

    }

    public void verifyPage(String pageName) {
        isDisplayed(pageNameTitle);
        assertEquals(pageName, getText(pageNameTitle));

    }

    public void clickCartIcon() {
        click(cartIcon);
    }

    public void clickCheckoutButton() {
        click(checkoutButton);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public void clickFinishButton() {
        click(finishButton);
    }

    public void clickLogout() {
        click(MenuIcon);
        click(logoutMenu);
    }

    public void enterPersonalInformation(String firstName, String lastName, String zipCode) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(zipCodeField, zipCode);
    }

    public void enterLockedOutAccount(String lockedOutUsername) {

        enterText(usernameField, lockedOutUsername);
        enterText(passwordField, property.getProperty("password"));
        click(loginButton);

    }

    public void verifyPaymentInformation(String paymentInfo, String shippingInfo, String totalPrice) {
        assertEquals(paymentInfo, getText(paymentInfoLocator));
        assertEquals(shippingInfo, getText(shippingInfoLocator));
        assertEquals("Total: " + totalPrice, getText(totalPriceLocator));

    }

    public void verifyErrorMessage(String errorMessage) {
        assertEquals(errorMessage, getText(errorMessageLocator));

    }

    public void selectSortPriceHighToLow() {
        selectFromDropdown(sortLocator, "Price (high to low)");

    }

    public void verifyProductsAreSortedFromHighToLow() {

    }


    public void selectProducts() {
        click(product1Locator);
        click(product2Locator);
    }

    public void verifyItemsAreDisplayed(String product1, String product2) {
        assertEquals("Product is displayed: ", product1, getText(product1Display));
        assertEquals("Product is displayed: ", product2, getText(product2Display));

    }


}
