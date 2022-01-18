package com.gmail.olemore.tests;

import com.gmail.olemore.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import static com.gmail.olemore.testData.RegistrationFormData.*;

public class StudentRegistrationForm {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void setAllInputsTestWithFakeData() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(emailAddress)
                .setGender(gender)
                .typeUserNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .typeSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(filePath)
                .typeAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        //Проверка формы регистрации
        registrationPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", emailAddress)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", mobileNumber)
                .checkResultsValue("Date of Birth", day + " " + month + "," + year)
                .checkResultsValue("Subjects", subject)
                .checkResultsValue("Hobbies", hobby)
                .checkResultsValue("Picture", filePath)
                .checkResultsValue("Address", address)
                .checkResultsValue("State and City", state + " " + city);
    }

    //тест без генерации тестовых данных
    @Test
    void setAllInputsTestWithDsl() {
        registrationPage.openPage()
                .typeFirstName("Olga")
                .typeLastName("Filippova")
                .typeEmail("qqq@gmail.com")
                .setGender("Female")
                .typeUserNumber("1234567890")
                .setBirthDate("26", "May", "1995")
                .typeSubject("Computer Science")
                .setHobbies("Reading")
                .uploadPicture("file.png")
                .typeAddress("Current Address")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        //Проверка формы регистрации
        registrationPage.checkResultsValue("Student Name", "Olga Filippova")
                .checkResultsValue("Student Email", "qqq@gmail.com")
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", "1234567890")
                .checkResultsValue("Date of Birth", "26 May,1995")
                .checkResultsValue("Subjects", "Computer Science")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "file.png")
                .checkResultsValue("Address", "Current Address")
                .checkResultsValue("State and City", "NCR Delhi");
    }
}
