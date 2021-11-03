package tests;

import configuration.BasicTestSetup;
import configuration.EmulatedFirefoxTestSetup;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.ParseUserAgentPage;
import pages.UserAgentPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserAgentTest extends BasicTestSetup {

    @Test
    public void checkThatUserAgentIsCorrect() {
        UserAgentPage userAgentPage = new UserAgentPage(webDriver);
        userAgentPage.openPage();
        String testUserAgent = userAgentPage.getUserAgentText();
        assertTrue(testUserAgent.contains("Chrome"));
    }

    @Test
    public void checkThatIsParsedCorrectly() {
        UserAgentPage userAgentPage = new UserAgentPage(webDriver);
        userAgentPage.openPage();
        ParseUserAgentPage parseUserAgentPage = userAgentPage.selectUserAgentText();
        parseUserAgentPage.clickParseButton();
        String parsedUserAgentText = parseUserAgentPage.getParsedUserAgentText();
        assertTrue(parsedUserAgentText.contains("Chrome"));
        assertTrue(parsedUserAgentText.contains("Windows 10"));

        webDriver.navigate().back();
        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(currentUrl, parseUserAgentPage.getUrl());

        webDriver.navigate().back();
        String currentUrl2 = webDriver.getCurrentUrl();
        assertEquals(currentUrl2, userAgentPage.getUrl());
    }

    @Test
    public void checkTokenCookieTest() {
        UserAgentPage userAgentPage = new UserAgentPage(webDriver);
        userAgentPage.openPage();
        ParseUserAgentPage parseUserAgentPage = userAgentPage.selectUserAgentText();
        Cookie tokenCookie = webDriver.manage().getCookieNamed("csrftoken");
        System.out.println("d");
    }
}
