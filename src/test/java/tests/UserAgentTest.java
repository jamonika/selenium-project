package tests;

import configuration.BasicTestSetup;
import configuration.EmulatedFirefoxTestSetup;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pages.ParseUserAgentPage;
import pages.UserAgentPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Slf4j
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
        log.info("Step 1: Open browser");
        UserAgentPage userAgentPage = new UserAgentPage(webDriver);
        userAgentPage.openPage();
        log.info("Step 2: Select user agent text");
        ParseUserAgentPage parseUserAgentPage = userAgentPage.selectUserAgentText();
        log.info("Step 3: Click parse button");
        parseUserAgentPage.clickParseButton();
        String parsedUserAgentText = parseUserAgentPage.getParsedUserAgentText();
        log.error("Error abc");
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
