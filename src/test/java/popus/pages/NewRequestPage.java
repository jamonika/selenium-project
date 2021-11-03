package popus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;
import popus.helpers.SwitchWindowsHelper;

public class NewRequestPage extends Page {
    @FindBy(id = "newAttach_textSpan")
    private WebElement attachFilesButton;

    @FindBy(id = "cmt")
    private WebElement titleInput;

    public NewRequestPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public AttachmentPopupPage clickAttachFilesButton() {
        SwitchWindowsHelper switchWindowsHelper = new SwitchWindowsHelper(driver);
        attachFilesButton.click();
        switchWindowsHelper.switchToNewPage();
        return new AttachmentPopupPage(driver, switchWindowsHelper);
    }

    public void typeInTitleInput(String text) {
        titleInput.sendKeys(text);
    }
}
