package jira.tests;

import configuration.BasicTestSetup;
import jira.pages.JiraLoginPage;
import jira.pages.MenuPage;
import jira.pages.MenuItemPage;
import jira.pages.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class JiraScreenshotsTest extends BasicTestSetup {

    @Test
    public void takeScreenshotsTest() throws IOException {
        JiraLoginPage loginPage = new JiraLoginPage(webDriver);
        Screenshot screenshot = new Screenshot(webDriver);
        loginPage.openPage();
        MenuPage menuPage = new MenuPage(webDriver);
        menuPage.waitForCreateButton();
        List<WebElement> menuElemets = menuPage.getMenuElements();
        for (WebElement menuItem : menuElemets) {
            menuItem.click();
            List <WebElement> suboptions = webDriver.findElements(By.cssSelector(".aui-dropdown2-in-header a"));
            MenuItemPage menuItemPage = new MenuItemPage(webDriver, menuItem, suboptions);
            menuItemPage.clickSubOption();
            screenshot.takeScreenshot();
            //menuItem.click();
        }
    }

}
