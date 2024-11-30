package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    private long DEFAULT_TIMEOUT = 10;


    public BasePage(WebDriver driver){
        this.driver = driver;

    }


    public void click(By locator){
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        e.click();
        log.info("Element is clicked.." + e );

    }

    public void enterText(By locator, CharSequence... keysToSend) {
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        e.sendKeys(keysToSend);
        log.info("Text is entered.." + keysToSend);

    }

    public void selectFromDropdown(By locator, String option) {
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        Select dropdown = new Select(e);
        dropdown.selectByVisibleText(option);
        log.info("Dropdown option is selected.." + option);

    }

    public void isDisplayed(By locator){
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        e.isDisplayed();
        log.info("Element is displayed.." + e);

    }
    public void isEnabled(By locator) throws Exception{
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        e.isEnabled();
        log.info("Element is enabled.." + e);

    }

    public String getText(By locator) {
        WebElement e = driver.findElement(locator);
        waitForVisibility(e);
        String text = e.getText().toString();
        log.info("Element text is.." + text);
        return text;
    }

    public List<WebElement> findElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements;
    }


    public void waitPresenceOfElement(By locator){
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void waitForVisibility(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));

    }


}
