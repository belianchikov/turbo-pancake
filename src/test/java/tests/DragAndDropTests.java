package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @Test
    void dragAndDropSelenideTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a header").shouldHave(text("B"));
    }

    @Test
    void dragAndDropActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        actions().dragAndDrop($("#column-b"), $("#column-a")).build().perform();
        $("#column-a header").shouldHave(text("B"));
    }
}
