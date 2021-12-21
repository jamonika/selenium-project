package jira.tests;

import configuration.BasicTestSetup;
import jira.pages.JiraLoginPage;
import jira.pages.MenuPage;
import jira.pages.MenuItemPage;
import org.testng.annotations.Test;

import java.util.List;

public class JiraScreenshotsTest extends BasicTestSetup {

    @Test
    public void takeScreenshots() {
        JiraLoginPage loginPage = new JiraLoginPage(webDriver);
        loginPage.openPage();
        MenuPage menuPage = new MenuPage(webDriver);
        menuPage.waitForCreateButton();
        List<MenuItemPage> menuElements = menuPage.getMenuElements();
        for (MenuItemPage m : menuElements) {
            m.clickSubOption();
        }

    }

}
