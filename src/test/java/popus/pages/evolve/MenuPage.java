package popus.pages.evolve;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class MenuPage extends Page {
    @FindBy(css = "body > app-root > main > ac-dashboard > div > div > ul > li:nth-child(3) > a")
    private WebElement devices;

    @FindBy(css = "body > app-root > main > ac-dashboard > div > div > ul > li:nth-child(3) > a")
    private WebElement messages;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public DevicesPage goToDevicesPage() {
        waitForElement(devices);
        devices.click();
        return new DevicesPage(driver);
    }

    public MessagesPage goToMessagesPage() {
        waitForElement(messages);
        messages.click();
        return new MessagesPage(driver);
    }
}
