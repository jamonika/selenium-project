package tests;

import org.testng.annotations.Test;
import configuration.BasicTestSetup;
import pages.DragAndDropPage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;
import static org.testng.Assert.assertEquals;

public class DragAndDropTest extends BasicTestSetup {

    @Test
    public void hello() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(webDriver);
        dragAndDropPage.openPage();
        //WebElement draggable5000 = dragAndDropPage.findDraggableByName("5000");
        dragAndDropPage.dragAndDrop("BANK", "Debit Side Account");
        dragAndDropPage.dragAndDrop("5000", "Debit Side Amount");
        dragAndDropPage.dragAndDrop("SALES", "Credit Side Account");
        dragAndDropPage.dragAndDrop("5000", "Credit Side Amount");
        String result = dragAndDropPage.getDisplayedResult();
        assertEquals(result, "Perfect!");
    }

    @Test
    public void checkAllDragAndDropPossibilitiesResults() throws IOException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(webDriver);
        dragAndDropPage.openPage();

        List<String> draggableNames = Stream.of(DragAndDropPage.Draggable.values())
                .map(DragAndDropPage.Draggable::getDraggableValue)
                .collect(Collectors.toList());

        List<String> droppableNames = Stream.of(DragAndDropPage.Droppable.values())
                .map(DragAndDropPage.Droppable::getDroppableValue)
                .collect(Collectors.toList());

        Path resultsFilePath = Path.of("src", "main", "resources", "results").resolve("drag_drop_results.csv");
        List<String> correctResultsOfDragAndDrop = readAllLines(resultsFilePath);

        for (String draggable : draggableNames) {
            for (String droppable : droppableNames) {
                dragAndDropPage.dragAndDrop(draggable, droppable);
                boolean droppedSuccessfully = dragAndDropPage.checkIfDraggableDroppedSuccessfully(draggable,droppable);
                dragAndDropPage.assertThatResultIsCorrect(droppedSuccessfully, draggable, droppable, correctResultsOfDragAndDrop);
                dragAndDropPage.refreshPage();
            }
        }
    }
}
