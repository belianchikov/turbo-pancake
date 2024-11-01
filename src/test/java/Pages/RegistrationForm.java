package Pages;

import Pages.Components.CalendarComponent;
import Pages.Components.FilledFormComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {
    private final SelenideElement
            firstNameField = $("#firstName"),
            lastNameField = $("#lastName"),
            userEmailField = $("#userEmail"),
            genderField = $("#genterWrapper"),
            userNumberField = $("#userNumber"),
            calendarField = $("#dateOfBirthInput"),
            subjectsField = $("#subjectsInput"),
            hobbiesField = $("#hobbiesWrapper"),
            uploadPictureField = $("#uploadPicture"),
            currentAddressField = $("#currentAddress"),
            cityStateWrapper = $("#stateCity-wrapper"),
            stateField = $("#state"),
            cityField = $("#city"),
            submitButton = $("#submit"),
            resultsFormHeader = $("#example-modal-sizes-title-lg"),
            closeResultsFormButton = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();
    FilledFormComponent filledFormComponent = new FilledFormComponent();

    public RegistrationForm openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationForm removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationForm setFirstName(String firstName) {
        firstNameField.setValue(firstName);
        return this;
    }

    public RegistrationForm setLastName(String lastName) {
        lastNameField.setValue(lastName);
        return this;
    }

    public RegistrationForm setUserEmail(String userEmail) {
        userEmailField.setValue(userEmail);
        return this;
    }

    public RegistrationForm setUserNumber(String userNumber) {
        userNumberField.setValue(userNumber);
        return this;
    }

    public RegistrationForm setGender(String gender) {
        genderField.$(byText(gender)).click();
        return this;
    }

    public RegistrationForm setDateOfBirth(String day, String month, String year) {
        calendarField.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationForm setSubject(String subject) {
        subjectsField.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationForm setHobby(String hobby) {
        hobbiesField.$(byText(hobby)).click();
        return this;
    }

    public RegistrationForm uploadPicture(String pictureName) {
        uploadPictureField.uploadFromClasspath(pictureName);
        return this;
    }

    public RegistrationForm setCurrentAddress(String address) {
        currentAddressField.setValue(address);
        return this;
    }

    public RegistrationForm selectState(String state) {
        stateField.click();
        cityStateWrapper.$(byText(state)).click();
        return this;
    }

    public RegistrationForm selectCity(String city) {
        cityField.click();
        cityStateWrapper.$(byText(city)).click();
        return this;
    }

    public RegistrationForm clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public void verifyResultsFormAppeared() {
        resultsFormHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResultsFormNotAppeared() {
        resultsFormHeader.shouldNot(visible);
    }

    public void closeResultsForm() {
        closeResultsFormButton.click();
    }

    public RegistrationForm verifyFieldValue(String fieldName, String value) {
        filledFormComponent.verifyFieldValue(fieldName, value);
        return this;
    }
}
