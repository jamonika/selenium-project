package tests;

import configuration.EmulatedFirefoxTestSetup;
import org.testng.annotations.Test;
import pages.UserAgentPage;

import static org.testng.Assert.assertTrue;

public class ModifiedUserAgentTest extends EmulatedFirefoxTestSetup {

    @Test
    public void checkThatUserAgentIsCorrect() {
        UserAgentPage userAgentPage = new UserAgentPage(webDriver);
        userAgentPage.openPage();
        String testUserAgent = userAgentPage.getUserAgentText();
        assertTrue(testUserAgent.contains("Firefox"));
    }
}
