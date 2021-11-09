package popus.tests;

import configuration.BasicTestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import popus.helpers.SwitchWindowsHelper;
import popus.pages.AttachmentPopupPage;
import popus.pages.HomePage;
import popus.pages.LoginPage;
import popus.pages.NewRequestPage;

import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

public class PopupTest extends BasicTestSetup {

    @Test
    public void addAttachmentInItRequest() {
        LoginPage loginPage = new LoginPage(webDriver);

        loginPage.openPage();
        loginPage.typeEmailToInput("monika@s3connectedhealth.com");
        HomePage homePage = loginPage.submitEmail();
        NewRequestPage newRequestPage = homePage.clickNewRequestButton();
        AttachmentPopupPage attachmentPopupPage = newRequestPage.clickAttachFilesButton();
        attachmentPopupPage.selectFileToAttach(Path.of("D:", "selenium-project","src","main","resources","results","drag_drop_results.csv"));
        attachmentPopupPage.closePopup();
        newRequestPage.typeInTitleInput("Cokolwiek");
    }

    //test bazujący na napisanym już teście, otworzyć nową zakładkę i wykonać jakieś akcje
    @Test
    public void openNewTabAndPerformActions() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openPage();
        loginPage.typeEmailToInput("monika@s3connectedhealth.com");
        SwitchWindowsHelper switchWindowsHelper = new SwitchWindowsHelper(webDriver);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.open('https://www.google.com/', '_blank');");
        switchWindowsHelper.switchToNewPage();
        webDriver.findElement(By.id("L2AGLb")).click();
        webDriver.findElement(By.name("q")).sendKeys("Selenium");
        webDriver.findElements(By.name("btnK")).get(1).click();
        switchWindowsHelper.switchToInitialPage();
        assertTrue(webDriver.getCurrentUrl().contains("helpdesk.s3group.com"));
    }
}
