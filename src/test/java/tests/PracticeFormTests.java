package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
    }

    @Test
    void fillFormTest() {

        // Test data

        String firstName = "firstNameValue";
        String lastName = "lastNameValue";
        String userEmail = "user@email.value";
        String gender = "1"; // 1 - Male, 2 - Female, 3 - Other
        String genderText = "Male"; // for assertion, change accordingly 'gender'
        String userNumber = "1357902468";
        String birthdayYear = "1996";
        int birthdayMonth = 10; // January = 0 ... December - 11
        String birthdayMonthText = "November"; // for assertion, change accordingly 'birthdayMonth'
        String birthdayDay = "10";
        String subject = "Maths";
        String hobby = "2"; // 1 - Sports, 2 - Reading, 3 - Music
        String hobbyText = "Reading"; // for assertion, change accordingly 'hobby'
        String fileName = "build.gradle";
        String currentAddress = "currentAddressValue";
        String state = "NCR";
        String city = "Noida";

        // Filling the form

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-" + gender + " + label").click();
        $("#userNumber").setValue(userNumber);
        $(".react-datepicker__input-container").click();
        $(".react-datepicker__month-select").selectOption(birthdayMonth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select [value=\"" + birthdayYear + "\"]").scrollIntoView(true).click();
        $(".react-datepicker__day--0" + birthdayDay + ":not(.react-datepicker__day--outside-month)").scrollIntoView(true).click();
        $("#subjectsInput").setValue(subject).sendKeys(Keys.ENTER);
        $("#hobbies-checkbox-" + hobby + " + label").click();
        $("#uploadPicture").uploadFile(new File(fileName));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#react-select-3-input").setValue(state).sendKeys(Keys.ENTER);
        $("#city").click();
        $("#react-select-4-input").setValue(city).sendKeys(Keys.ENTER);
        $("#submit").click();

        // Assertions

        $(".modal-body tr td:nth-child(2)", 0).shouldHave(text(firstName + " " + lastName)); // Student Name
        $(".modal-body tr td:nth-child(2)", 1).shouldHave(text(userEmail)); // Student Email
        $(".modal-body tr td:nth-child(2)", 2).shouldHave(text(genderText)); // Gender
        $(".modal-body tr td:nth-child(2)", 3).shouldHave(text(userNumber)); // Mobile
        $(".modal-body tr td:nth-child(2)", 4).shouldHave(text(birthdayDay + " " + birthdayMonthText + "," + birthdayYear)); // Date of birth
        $(".modal-body tr td:nth-child(2)", 5).shouldHave(text(subject)); // Subjects
        $(".modal-body tr td:nth-child(2)", 6).shouldHave(text(hobbyText)); // Hobbies
        $(".modal-body tr td:nth-child(2)", 7).shouldHave(text(fileName)); // Picture
        $(".modal-body tr td:nth-child(2)", 8).shouldHave(text(currentAddress)); // Address
        $(".modal-body tr td:nth-child(2)", 9).shouldHave(text(state + " " + city)); // State and City

        $("#closeLargeModal").click();
    }
}
