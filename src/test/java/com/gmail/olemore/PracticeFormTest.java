package com.gmail.olemore;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class PracticeFormTest {

    @Test
    void setAllInputsTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Filippova");
        $("#userEmail").setValue("qqq@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1995");
        $("[aria-label$='May 26th, 1995']").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("file.png");

        $("#currentAddress").setValue("Current Address");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
/*
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
*/

        $("#submit").scrollTo().click();

        $(".modal-content").shouldHave(
            text("Olga Filippova"),
            text("qqq@gmail.com"),
            text("Female"),
            text("1234567890"),
            text("26 May,1995"),
            text("Computer Science"),
            text("Reading"),
            text("file.png"),
            text("Current Address"),
            text("NCR Delhi"));
    }
}
