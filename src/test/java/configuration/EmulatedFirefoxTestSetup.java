package configuration;

import driver.ChromeDriverWrapper;
import driver.DriverWrapper;
import org.testng.annotations.BeforeTest;

public class EmulatedFirefoxTestSetup extends BasicTestSetup{

    @Override
    @BeforeTest
    public void beforeTest() {
        webDriver = new ChromeDriverWrapper().createEmulateDriver();
        webDriver.manage().window().maximize();
    }
}
