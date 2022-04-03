package com.demoqa;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistration() {
        String firstName = "Sergey";
        String lastName = "Burmistrov";
        String email = "test@test.com";
        String gender = "Male";
        String phoneNumber = "1234567890";
        String subject = "English";
        String hobby1 = "Sports";
        String hobby2 = "Reading";
        String hobby3 = "Music";
        String imgPath = "photo2.jpg";
        String address = "Address";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1990");
        $(".react-datepicker__day--029").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        $("#uploadPicture").uploadFromClasspath(imgPath);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(gender),
                text(phoneNumber),
                text("29 October,1990"),
                text(subject),
                text(hobby1),
                text(hobby2),
                text(hobby3),
                text(imgPath),
                text(address),
                text("NCR Delhi"));
    }
}







