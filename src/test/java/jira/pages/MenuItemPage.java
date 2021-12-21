package jira.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.List;

@Getter
public class MenuItemPage extends Page {
    private WebElement menuOption;

    @FindBy(css = ".aui-dropdown2-in-header a")
    List<WebElement> menuSubOptions;

    public MenuItemPage(WebDriver driver, WebElement menuOption) {
        super(driver);
        this.menuOption = menuOption;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public WebElement returnFirstSubOption() {
        return menuSubOptions.get(0);
    }

    public void clickSubOption() {
        WebElement subOption = returnFirstSubOption();
        waitForElement(subOption);
        subOption.click();
        System.out.println();
    }
}
