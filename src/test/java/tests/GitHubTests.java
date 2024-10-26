package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    @Test
    void hoverEnterpriseTest() {
        open("https://github.com/");
        $$("button").findBy(text("Solutions")).hover();
        $$("a").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n developer platform."));
    }
}