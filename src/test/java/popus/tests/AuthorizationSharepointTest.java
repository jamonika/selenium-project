package popus.tests;

import configuration.BasicTestSetup;
import org.testng.annotations.Test;
import popus.pages.SharepointPage;

public class AuthorizationSharepointTest extends BasicTestSetup {

    @Test
    public void authenticate() {
        SharepointPage sharepointPage = new SharepointPage(webDriver);
        sharepointPage.openPage();
        System.out.println("de");
    }
}
