package popus.pages.evolve;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class MessagesPage extends Page {
    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://192.168.82.168/dashboard/messages";
    }
}
