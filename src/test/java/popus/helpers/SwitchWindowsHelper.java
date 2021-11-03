package popus.helpers;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SwitchWindowsHelper {
    private Set<String> handlesBefore;
    private WebDriver driver;

    public SwitchWindowsHelper(WebDriver driver) {
        this.driver = driver;
        handlesBefore = driver.getWindowHandles();
    }

    public void switchToNewPage() {
        Set<String> handlesAfter = driver.getWindowHandles();
        driver.switchTo().window(handlesAfter.stream().filter(h -> !handlesBefore.contains(h)).findAny().get());
    }

    public void switchToInitialPage() {
        driver.switchTo().window(String.valueOf(handlesBefore.toArray()[0]));
    }
}
