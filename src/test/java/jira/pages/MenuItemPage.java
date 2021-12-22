package jira.pages;

import lombok.Getter;
import org.openqa.selenium.*;
import pages.Page;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
public class MenuItemPage extends Page {
    private WebElement menuOption;

    //@FindBy(css = ".aui-dropdown2-in-header a")
    private List<WebElement> menuSubOptions;

    public MenuItemPage(WebDriver driver, WebElement menuOption, List<WebElement> menuSuboptions) {
        super(driver);
        this.menuOption = menuOption;
        this.menuSubOptions = menuSuboptions;
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
