package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiSoftAssertionsSearchTests {
    @Test
    void selenideWikiSoftAssertionsShouldContainJUnit5Example() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byTagAndText("a", "Soft assertions")).click();
        $$("div h4").find(text("JUnit5")).shouldBe(visible);
    }
}