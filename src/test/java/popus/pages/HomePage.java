package popus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class HomePage extends Page {
    @FindBy(id = "tb_submit")
    private WebElement newRequestButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public NewRequestPage clickNewRequestButton() {
        newRequestButton.click();
        return new NewRequestPage(driver);
    }
}
