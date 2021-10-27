package pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.fail;

public class DragAndDropPage extends Page{

    @FindBy(className = "ui-draggable")
    List<WebElement> draggables;

    @FindBy(id = "amt8")
    WebElement creditSideAmountDroppable;

    @FindBy(id = "loan")
    WebElement creditSideAccountDroppable;

    @FindBy(id = "amt7")
    WebElement debitSideAmountDroppable;

    @FindBy(id = "bank")
    WebElement debitSideAccountDroppable;

    @FindBy(css = "#equal a")
    WebElement result;

    private Actions actions;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    @Override
    public String getUrl() {
        return "http://demo.guru99.com/test/drag_drop.html";
    }

    public WebElement findDraggableByName (String name) {
        Optional<WebElement> element = draggables.stream().filter(d -> d.getText().trim().equals(name)).findAny();
        if (!element.isPresent()) {
            fail("No such draggable on page");
        }
        return element.get();
    }

    private void dragAndDrop (WebElement draggable, WebElement destination) {
        waitForElement(draggable);
        waitForElement(destination);
        actions.dragAndDrop(draggable, destination).build().perform();
    }

    public void dragAndDrop (String draggable, String destination) {
        WebElement destinationWebElement = null;

        switch (destination) {
            case "Debit Side Account":
                destinationWebElement = debitSideAccountDroppable;
                break;
            case "Debit Side Amount":
                destinationWebElement = debitSideAmountDroppable;
                break;
            case "Credit Side Account":
                destinationWebElement = creditSideAccountDroppable;
                break;
            case "Credit Side Amount":
                destinationWebElement = creditSideAmountDroppable;
                break;
            default:
                fail("Provided destination element does not exist");
        }

        dragAndDrop(findDraggableByName(draggable), destinationWebElement);
    }

    public String getDisplayedResult () {
        waitForElement(result);
        return result.getText();
    }

    @AllArgsConstructor
    @Getter
    public enum Draggable {
        MINUS_5000("-5000"),
        PLUS_5000("5000"),
        BANK("BANK"),
        SALES("SALES"),
        OWNERS_EQUITY("OWNER'S EQUITY"),
        LOAN("LOAN");

        private String draggableValue;
    }

    @AllArgsConstructor
    @Getter
    public enum Droppable {
        DEBIT_SIDE_ACCOUNT("Debit Side Account"),
        DEBIT_SIDE_AMOUNT("Debit Side Amount"),
        CREDIT_SIDE_ACCOUNT("Credit Side Account"),
        CREDIT_SIDE_AMOUNT("Credit Side Amount");

        private String droppableValue;
    }
}
