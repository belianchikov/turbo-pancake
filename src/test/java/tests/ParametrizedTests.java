package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrizedTests {

    @ParameterizedTest
    @CsvSource({
            "https://github.com/selenide/selenide, selenide.org",
            "https://github.com/junit-team/junit5, junit.org",
            "https://github.com/allure-framework/allure2, allurereport.org"
    })
    void githubRepoShouldContainUrlTest(String url, String expectedText) {
        open(url);
        $(".Layout-sidebar a").shouldHave(text(expectedText));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "https://qa.guru/playwright_js",
            "https://qa.guru/python_advanced",
            "https://qa.guru/java_advanced"
    })
    void coursePageShouldContainStartInfoTest(String url) {
        open(url);
        $(".t-container").shouldHave(text("Старт курса"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    void loginOnTestPageTest(String username, String password, String expectedResult) {
        open("https://the-internet.herokuapp.com/login");

        $("#username").setValue(username);
        $("#password").setValue(password);
        $(".radius").click();

        $("#flash").shouldHave(text(expectedResult));
    }
}