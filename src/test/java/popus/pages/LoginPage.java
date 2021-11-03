package popus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class LoginPage extends Page {

    @FindBy(name = "CUSTM")
    private WebElement emailInput;

    @FindBy(className = "button")
    private WebElement submitEmail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://helpdesk.s3group.com/MRcgi/MRlogin.pl?USER=customer&PASSWORD=helpme";
    }

    public void typeEmailToInput(String email) {
        emailInput.sendKeys(email);
    }

    public HomePage submitEmail() {
        submitEmail.click();
        return new HomePage(driver);
    }

}
