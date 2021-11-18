package popus.tests;

import configuration.BasicTestSetup;
import org.testng.annotations.Test;
import popus.pages.ikea.IkeaHomePage;
import popus.pages.ikea.LocationPopUpPage;

import static org.testng.Assert.assertFalse;

public class InAppPopupTest extends BasicTestSetup {

    @Test
    public void inAppPopupTest() {
        IkeaHomePage homePage = new IkeaHomePage(webDriver);
        homePage.openPage();
        homePage.openLocationPopup()
                .openChooseStoreManuallyPopup();
        LocationPopUpPage locationPopUpPage = new LocationPopUpPage(webDriver);
        locationPopUpPage.closePopup();
        boolean popupDisplayed = locationPopUpPage.checkIfPopupIsDisplayed();
        assertFalse(popupDisplayed);
    }
}
