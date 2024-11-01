package tests;

import Pages.RegistrationForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Student Registration Form tests")
public class PracticeFormTests extends TestBase {

    @DisplayName("Positive test for filling the registration form (maximum)")
    @Test
    void positiveMaximumFormFillingTest() {
        String
                firstName = "firstNameValue",
                lastName = "lastNameValue",
                userEmail = "user@email.value",
                gender = "Male",
                userNumber = "1357902468",
                birthdayDay = "10",
                birthdayMonth = "November",
                birthdayYear = "1996",
                subject = "Maths",
                hobby = "Reading",
                pictureName = "picture.png",
                currentAddress = "currentAddressValue",
                state = "NCR",
                city = "Noida";

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm
                .openPage()
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
    }

    @DisplayName("Positive test for filling the registration form (minimum)")
    @Test
    void positiveMinimumFormFillingTest() {
        String
                firstName = "anotherFirstNameValue",
                lastName = "anotherLastNameValue",
                gender = "Female",
                userNumber = "9546128373",
                hobby = "Music";

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm
                .openPage()
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
                firstName = "anotherFirstNameValue",
                lastName = "anotherLastNameValue",
                gender = "Female",
                userNumber = "123456789",
                hobby = "Music";

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setHobby(hobby)
                .clickSubmitButton();

        registrationForm.verifyResultsFormNotAppeared();
    }
}