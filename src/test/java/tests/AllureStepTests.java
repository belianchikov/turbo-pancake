package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.JaRu;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureStepTests extends TestBase {
    @Test
    void allureReportListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://ya.ru");
        $("#text").sendKeys("qa guru");
        $("#text").pressEnter();
        $("#search-result h2").shouldHave(text("QA.GURU"));
    }

    @Test
    void allureReportLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open 'ya.ru' web site", () ->
                open("https://ya.ru"));

        step("Type 'qa guru' to search field and press Enter", () -> {
            $("#text").sendKeys("qa guru");
            $("#text").pressEnter();
        });

        step("Verify that first search result contains text 'QA.GURU'", () ->
                $("#search-result h2").shouldHave(text("QA.GURU")));
    }


    @Test
    void allureReportStepsTest() {
        JaRu jaRu = new JaRu();
        jaRu
                .openPage()
                .searchText("qa guru")
                .verifySearchResults("QA.GURU");
    }
}
