package popus.pages.evolve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class LoginPage extends Page {

    @FindBy(css = "body > app-root > main > ng-component > section > ng-component > div > form > div:nth-child(1) > input")
    private WebElement loginInput;

    @FindBy(css = "body > app-root > main > ng-component > section > ng-component > div > form > div:nth-child(2) > input")
    private WebElement passwordInput;

    @FindBy(css = "body > app-root > main > ng-component > section > ng-component > div > form > div:nth-child(3) > button")
    private WebElement sumbitLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://192.168.82.168/";
    }

    public void login() {
        waitForElement(loginInput);
        loginInput.sendKeys("admin");
        waitForElement(passwordInput);
        passwordInput.sendKeys("admin123");
        waitForElement(sumbitLogin);
        sumbitLogin.click();
    }
}
