package tests;

import org.junit.jupiter.api.Tag;
import pages.RegistrationForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.TestDataGenerator;

import java.util.Date;

import static io.qameta.allure.Allure.step;

@DisplayName("Student Registration Form tests")
public class PracticeFormTests extends TestBase {

    @DisplayName("Positive test for filling the registration form (maximum)")
    @Test
    @Tag("simple")
    void positiveMaximumFormFillingTest() {
        Date birthdayDate = TestDataGenerator.getBirthDate();
        String
                firstName = TestDataGenerator.getFirstName(),
                lastName = TestDataGenerator.getLastName(),
                userEmail = TestDataGenerator.getUserEmail(),
                gender = TestDataGenerator.getGender(),
                userNumber = TestDataGenerator.getUserNumber(),
                birthdayYear = TestDataGenerator.getBirthdayYear(birthdayDate),
                birthdayMonth = TestDataGenerator.getBirthdayMonth(birthdayDate),
                birthdayDay = TestDataGenerator.getBirthdayDay(birthdayDate),
                subject = TestDataGenerator.getSubject(),
                hobby = TestDataGenerator.getHobby(),
                pictureName = TestDataGenerator.getPictureName(),
                currentAddress = TestDataGenerator.getCurrentAddress(),
                state = TestDataGenerator.getState(),
                city = TestDataGenerator.getCity(state);

        RegistrationForm registrationForm = new RegistrationForm();
        step("Open form and fill out", () -> {
            registrationForm
                    .openPage()
                    .removeBanners()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setDateOfBirth(birthdayDay, birthdayMonth, birthdayYear)
                    .setSubject(subject)
                    .setHobby(hobby)
                    .uploadPicture(pictureName)
                    .setCurrentAddress(currentAddress)
                    .selectState(state)
                    .selectCity(city)
                    .clickSubmitButton()
                    .verifyResultsFormAppeared();
        });
        step("Verify results", () -> {
            registrationForm
                    .verifyFieldValue("Student name", firstName + " " + lastName)
                    .verifyFieldValue("Student Email", userEmail)
                    .verifyFieldValue("Gender", gender)
                    .verifyFieldValue("Mobile", userNumber)
                    .verifyFieldValue("Date of Birth", birthdayDay + " " + birthdayMonth + "," + birthdayYear)
                    .verifyFieldValue("Subjects", subject)
                    .verifyFieldValue("Hobbies", hobby)
                    .verifyFieldValue("Picture", pictureName)
                    .verifyFieldValue("Address", currentAddress)
                    .verifyFieldValue("State and City", state + " " + city);

            registrationForm.closeResultsForm();
        });
    }

    @DisplayName("Positive test for filling the registration form (minimum)")
    @Test
    void positiveMinimumFormFillingTest() {
        String
                firstName = TestDataGenerator.getFirstName(),
                lastName = TestDataGenerator.getLastName(),
                gender = TestDataGenerator.getGender(),
                userNumber = TestDataGenerator.getUserNumber(),
                hobby = TestDataGenerator.getHobby();

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setHobby(hobby)
                .clickSubmitButton()
                .verifyResultsFormAppeared();

        registrationForm
                .verifyFieldValue("Student name", firstName + " " + lastName)
                .verifyFieldValue("Gender", gender)
                .verifyFieldValue("Mobile", userNumber)
                .verifyFieldValue("Hobbies", hobby);

        registrationForm.closeResultsForm();
    }

    @DisplayName("Negative test for filling the registration form (wrong user number)")
    @Test
    void negativeFormFillingWrongNumberTest() {
        String
                firstName = TestDataGenerator.getFirstName(),
                lastName = TestDataGenerator.getLastName(),
                gender = TestDataGenerator.getGender(),
                userNumber = "123456789",
                hobby = TestDataGenerator.getHobby();

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm
                .openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setHobby(hobby)
                .clickSubmitButton();

        registrationForm.verifyResultsFormNotAppeared();
    }
}