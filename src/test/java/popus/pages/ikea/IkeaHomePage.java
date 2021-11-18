package popus.pages.ikea;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class IkeaHomePage extends Page {

    @FindBy(className = "hnf-header__profile-link")
    private WebElement loginIcon;

    @FindBy(id = "hnf-header-locpick")
    private WebElement locationIcon;

    public IkeaHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://www.ikea.com/pl/pl/";
    }

    public LocationPopUpPage openLocationPopup() {
        waitForElement(locationIcon);
        locationIcon.click();
        return new LocationPopUpPage(driver);
    }
}
