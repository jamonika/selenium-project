package popus.pages.ikea;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class LocationPopUpPage extends Page {

    @FindBy(id = "hnf-btn-locpick-method-manual")
    private WebElement chooseStoreManuallyButton;

    @FindBy(id = "hnf-btn-locpick-close")
    private WebElement closePopupButton;

    @FindBy(className = "nf-locpick-sheets")
    private WebElement locationPopUp;

    public LocationPopUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void openChooseStoreManuallyPopup() {
        waitForElement(chooseStoreManuallyButton);
        chooseStoreManuallyButton.click();
    }

    public void closePopup() {
        closePopupButton.click();
    }

    public boolean checkIfPopupIsDisplayed() {
        return checkIfElementIsDisplayed(locationPopUp);
    }
}
