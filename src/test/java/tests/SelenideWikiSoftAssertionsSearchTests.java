package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiSoftAssertionsSearchTests {
    @Test
    void selenideWikiSoftAssertionsShouldContainJUnit5Example() {
        String expectedText = """
                @ExtendWith({SoftAssertsExtension.class})
                 class Tests {
                   @Test
                   void test() {
                     Configuration.assertionMode = SOFT;
                     open("page.html");
                
                     $("#first").should(visible).click();
                     $("#second").should(visible).click();
                   }
                 }""";

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byTagAndText("a", "Soft assertions")).click();
        $$("div h4").find(text("JUnit5")).parent().sibling(0)
                .shouldHave(text(expectedText));

    }
}