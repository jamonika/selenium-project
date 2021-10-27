package tests;

import org.testng.annotations.Test;
import configuration.BasicTestSetup;
import pages.DragAndDropPage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void checkAllDragAndDropPossibilitiesResults() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(webDriver);
        dragAndDropPage.openPage();

        List<String> draggableNames = Stream.of(DragAndDropPage.Draggable.values())
                .map(DragAndDropPage.Draggable::getDraggableValue)
                .collect(Collectors.toList());

        List<String> droppableNames = Stream.of(DragAndDropPage.Droppable.values())
                .map(DragAndDropPage.Droppable::getDroppableValue)
                .collect(Collectors.toList());

        String[] results = new String[draggableNames.size()*droppableNames.size()];
        int i = 0;
        for (String draggable : draggableNames) {
            for (String droppable : droppableNames) {
                dragAndDropPage.dragAndDrop(draggable, droppable);
                results[i] = null;
                i ++;
            }
        }
    }
}
