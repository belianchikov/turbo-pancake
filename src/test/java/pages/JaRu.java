package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JaRu {
    private final SelenideElement searchField = $("#text");
    private final ElementsCollection searchResults = $$("#search-result h2");

    @Step("Open page 'ya.ru'")
    public JaRu openPage() {
        open("https://ya.ru");
        return this;
    }

    @Step("Type '{textToSearch}' to search field and press Enter")
    public JaRu searchText(String textToSearch) {
        searchField.sendKeys(textToSearch);
        searchField.pressEnter();
        return this;
    }

    @Step("Verify that search results contains '{expectedSearchResult}'")
    public void verifySearchResults(String expectedSearchResult) {
        searchResults.get(0).shouldHave(text(expectedSearchResult));
    }
}
