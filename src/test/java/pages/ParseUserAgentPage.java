package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParseUserAgentPage extends Page{

    @FindBy(css = "#parse-controls > input")
    private WebElement parseButton;

    @FindBy(className = "simple-major")
    private WebElement parsedUserAgentText;

    public ParseUserAgentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "https://developers.whatismybrowser.com/useragents/parse/?analyse-my-user-agent=yes";
    }

    public void clickParseButton() {
        waitForElement(parseButton);
        parseButton.click();
    }

    public String getParsedUserAgentText() {
        waitForElement(parsedUserAgentText);
        return parsedUserAgentText.getText();
    }
}
