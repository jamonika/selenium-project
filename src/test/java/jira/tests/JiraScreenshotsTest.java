package jira.tests;

import configuration.BasicTestSetup;
import jira.pages.JiraLoginPage;
import jira.pages.MenuPage;
import jira.pages.MenuItemPage;
import jira.pages.Screenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class JiraScreenshotsTest extends BasicTestSetup {

    @Test
    public void takeScreenshotsTest() throws IOException, InterruptedException {
        JiraLoginPage loginPage = new JiraLoginPage(webDriver);
        Screenshot screenshot = new Screenshot(webDriver);
        loginPage.openPage();
        MenuPage menuPage = new MenuPage(webDriver);
        menuPage.waitForCreateButton();
        List<String> menuElemets = menuPage.getMenuElements();
        for (String element : menuElemets) {
            WebElement menuItem = menuPage.getMenuElementByText(element);
            menuItem.click();
            List <WebElement> suboptions = webDriver.findElements(By.cssSelector(".aui-dropdown2-in-header a"));
            MenuItemPage menuItemPage = new MenuItemPage(webDriver, menuItem, suboptions);
            menuItemPage.clickSubOption();
//            new WebDriverWait(webDriver, 10).until(
//                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            Thread.sleep(2000);
            screenshot.takeScreenshot();
        }
    }

}
