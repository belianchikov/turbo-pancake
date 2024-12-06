package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("Stepik")
@DisplayName("Stepik Main page tests")
@Feature("Stepik Main page tests")
public class StepikTests extends TestBase {
    @Test
    @DisplayName("As a User, I open Main page and verify that Search field exists")
    public void verifySearchFieldOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that Search field exists and visible", () -> {
            $(".search-form__input ")
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("As a User, I open Main page and verify that Login button exists")
    public void verifyLoginButtonOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that 'Login' button exists and visible", () -> {
            $("#main-navbar a[href$=login]")
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("As a User, I open Main page and verify that Registration button exists")
    public void verifyRegisterButtonOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that 'Registration' button exists and visible", () -> {
            $("#main-navbar a[href$=registration]")
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("As a User, I open Main page and verify that Recommended courses exist")
    public void verifyRecommendedCoursesOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that Recommended courses exist and visible", () -> {
            $(".catalog-block-recommended-courses")
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("As a User, I open Main page and verify that Link to telegram exists")
    public void verifyLinkToTelegramOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that Link to telegram exists and visible", () -> {
            $(".page-footer a[href*='t.me']")
                    .shouldBe(visible);
        });
    }

    @Test
    @DisplayName("As a User, I open Main page and verify that Language selector exists")
    public void verifyLanguageSelectorOnMainPage() {
        step("Open 'stepik.org' Main page", () -> {
            open("https://stepik.org/");
        });
        step("Verify that language selector exists and visible", () -> {
            $(".language-selector button")
                    .shouldBe(visible);
        });
    }
}
