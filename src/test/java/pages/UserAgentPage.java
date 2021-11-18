package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAgentPage extends Page{

    @FindBy(id = "detected_value")
    private WebElement userAgent;

    public UserAgentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://www.whatismybrowser.com/detect/what-is-my-user-agent";
    }

    public String getUserAgentText() {
        waitForElement(userAgent);
        return userAgent.getText();
    }

    public ParseUserAgentPage selectUserAgentText() {
        waitForElement(userAgent);
        userAgent.click();
        closeAd();
        return new ParseUserAgentPage(driver);
    }

    private void closeAd() {
        WebElement dismissButton = driver.findElement(By.id("dismiss-button"));
        dismissButton.click();
    }
}
