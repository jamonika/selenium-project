package popus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import popus.helpers.SwitchWindowsHelper;

import java.nio.file.Path;

public class AttachmentPopupPage extends Page {
    private SwitchWindowsHelper switchWindowsHelper;

    @FindBy(id = "fileUpload1")
    private WebElement chooseFileButton;


    public AttachmentPopupPage(WebDriver driver, SwitchWindowsHelper switchWindowsHelper) {
        super(driver);
        this.switchWindowsHelper = switchWindowsHelper;
    }

    @Override
    public String getUrl() {
        return null;
    }

    public void selectFileToAttach(Path path) {
        chooseFileButton.sendKeys(path.toAbsolutePath().toString());
    }

    public void closePopup() {
        driver.close();
        switchWindowsHelper.switchToInitialPage();
    }
}
