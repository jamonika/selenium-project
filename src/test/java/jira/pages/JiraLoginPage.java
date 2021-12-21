package jira.pages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class JiraLoginPage extends Page {
    public JiraLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://jira.s3group.com/";
    }
}
