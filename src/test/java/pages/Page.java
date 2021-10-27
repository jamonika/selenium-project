package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public abstract class Page {

    protected WebDriver driver;

    public Page (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage () {
        driver.navigate().to(getUrl());
    }

    public abstract String getUrl ();

    protected boolean checkIfElementIsDisplayed (WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NotFoundException | StaleElementReferenceException | ElementNotVisibleException e) {
            return false;
        }
    }

    protected void waitForElement (WebElement webElement) {
        await().atMost(5, TimeUnit.SECONDS).until(() -> checkIfElementIsDisplayed(webElement));
    }
}
