package Pages.Components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class FilledFormComponent {
    public void verifyFieldValue(String fieldName, String value) {
        $$("tr td").findBy(text(fieldName))
                .sibling(0).shouldHave(text(value));
    }
}