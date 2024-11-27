package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage extends WebDriverConfig{
    public WebDriver driver;

    private long DEFAULT_TIMEOUT = 10;

    public void navigateTo(String url) throws IOException {
        driver = initializeWebDriver();
        driver.get(url);
        log.info("Opening url: " + url );
    }

    public void click(By locator){
        WebElement e = driver.findElement(locator);
        e.click();
        log.info("Element is clicked.." );

    }

    public void enterText(By locator, String text){
        WebElement e = driver.findElement(locator);
        e.sendKeys(text);
        log.info("String is entered.." + text);

    }

    public void selectFromDropdown(By locator, String option) throws Exception{
        WebElement e = driver.findElement(locator);
        Select dropdown = new Select(e);
        dropdown.selectByVisibleText(option);
        log.info("Dropdown option is selected.." + option);

    }

    public void isDisplayed(By locator) throws Exception{
        WebElement e = driver.findElement(locator);
        e.isDisplayed();
        log.info("Element is displayed..");

    }
    public void isEnabled(By locator) throws Exception{
        WebElement e = driver.findElement(locator);
        e.isEnabled();
        log.info("Element is enabled..");

    }

    public String getText(By locator) {
        WebElement e = driver.findElement(locator);
        String text = e.getText().toString();
        return text;
    }

    public void waitForElement(By locator, long timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        WebElement e = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void waitVisibility(By locator){
        waitForElement(locator, DEFAULT_TIMEOUT);

    }


}
