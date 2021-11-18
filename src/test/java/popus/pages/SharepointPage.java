package popus.pages;

import org.openqa.selenium.WebDriver;
import pages.Page;

public class SharepointPage extends Page {
    public SharepointPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://hr.s3group.com/Administration/Pages/Pre-return to office form - Wroc%c5%82aw.aspx";
    }
}
