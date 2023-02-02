package com.demoqa;

import com. codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWork {
    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Vlad");
        $("#lastName").setValue("Dolgodvorov");
        $("#userEmail").setValue("test@test.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9980000000");
        $("#dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("qa_logo.jpg");
        $("#currentAddress").setValue("Value");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().lastChild().shouldHave(text("Vlad Dolgodvorov"));
        $(".table-responsive").$(byText("Student Email")).parent().lastChild().shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().lastChild().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().lastChild().shouldHave(text("9980000000"));
        $(".table-responsive").$(byText("Date of Birth")).parent().lastChild().shouldHave(text("23 June,1995"));
        $(".table-responsive").$(byText("Subjects")).parent().lastChild().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().lastChild().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().lastChild().shouldHave(text("qa_logo.jpg"));
        $(".table-responsive").$(byText("Address")).parent().lastChild().shouldHave(text("Value"));
        $(".table-responsive").$(byText("State and City")).parent().lastChild().shouldHave(text("Haryana Karnal"));
    }

}