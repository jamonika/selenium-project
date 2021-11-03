package popus.tests;

import configuration.BasicTestSetup;
import org.testng.annotations.Test;
import popus.pages.AttachmentPopupPage;
import popus.pages.HomePage;
import popus.pages.LoginPage;
import popus.pages.NewRequestPage;

import java.nio.file.Path;

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
}
