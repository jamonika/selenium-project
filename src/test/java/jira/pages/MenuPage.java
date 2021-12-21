package jira.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MenuPage extends Page {
    @FindBy(id = "create_link")
    WebElement createButton;

    @FindBy(css = ".aui-nav-link")
    List<WebElement> menuList;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void waitForCreateButton() {
        waitForElement(createButton, 60);
    }

    public List<WebElement> filterMenuElements() {
        return menuList.stream()
                .filter(w -> !w.getText().isEmpty()).collect(Collectors.toList());
                //.map(w -> new MenuSuboptionsPage(driver, w)).collect(Collectors.toList());
                //menuList.stream().filter(webElement -> !webElement.findElement(By.tagName("a")).getText().isEmpty());
                //.map(menuOption -> new MenuItemPage(driver, menuOption)).collect(Collectors.toList());
    }

    public List<MenuItemPage> getMenuElements() {
        List<WebElement> menuElemets = filterMenuElements();
        List<MenuItemPage> suboptionsPages = new ArrayList<>();
        for (WebElement menuItem : menuElemets) {
            menuItem.click();
            suboptionsPages.add(new MenuItemPage(driver, menuItem));
            menuItem.click();
        }
        return suboptionsPages;
    }
}
