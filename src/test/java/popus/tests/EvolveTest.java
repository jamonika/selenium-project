package popus.tests;

import configuration.BasicTestSetup;
import org.testng.annotations.Test;
import popus.pages.evolve.DevicesPage;
import popus.pages.evolve.LoginPage;
import popus.pages.evolve.MenuPage;

public class EvolveTest extends BasicTestSetup {

    @Test
    public void devicesTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openPage();
        loginPage.login();
        MenuPage menuPage = new MenuPage(webDriver);
        DevicesPage devicesPage = menuPage.goToDevicesPage();
        devicesPage.checkIfDevicesHasMessages();
        System.out.println("o");
    }
}
