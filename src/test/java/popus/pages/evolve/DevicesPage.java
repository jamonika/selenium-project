package popus.pages.evolve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevicesPage extends Page {

    @FindBy(className = "mat-row")
    private List<WebElement> deviceRow;

    public DevicesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://192.168.82.168/dashboard/devices";
    }

    public Map<String, Boolean> checkIfDevicesHasMessages() {
        Map<String, Boolean> deviceMessagesPresence = new HashMap<>();
        waitForElement(deviceRow);
        for(WebElement row : deviceRow) {
            row.click();
            By idSelector = By.id("div.ng-star-inserted mat-form-field:nth-child(1)");
            waitForElement(idSelector);
            WebElement deviceIdField = driver.findElement(idSelector);
            String deviceId = deviceIdField.getText();
            Boolean enabled = driver.findElement(By.cssSelector("#mat-dialog-0 > ac-dialog > div > div.ac-dialog-buttons-container.mat-dialog-actions > div.ng-star-inserted > button")).isEnabled();
            deviceMessagesPresence.put(deviceId, enabled);
            driver.findElement(By.className("ac-dialog-x-close")).click();
        }
        return deviceMessagesPresence;
    }
}
