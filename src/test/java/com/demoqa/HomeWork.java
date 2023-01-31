package com.demoqa;

import com. codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
$("[id=firstName]").setValue("Vlad");
$("[id=lastName]").setValue("Dolgodvorov");
$("[id=userEmail]").setValue("test@test.com");
$(byText("Male")).click();
$("[id=userNumber]").setValue("9980000000");
$("[id=dateOfBirthInput]").click();
$(".react-datepicker__month-select").selectOption("June");
    }
}
