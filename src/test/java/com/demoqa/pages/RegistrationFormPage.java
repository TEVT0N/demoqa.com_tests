package com.demoqa.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {
        @Step("Open registration page")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    @Step("Set first name")
    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    @Step("Set last name")
    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    @Step("Set email")
    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    @Step("Set gender")
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    @Step("Set phone number")
    public RegistrationFormPage setPhoneNumber(String value) {
        $("#userNumber").setValue(value).click();
        return this;
    }

    @Step("Set birth date")
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    @Step("Set subject")
    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    @Step("Set hobbies")
    public RegistrationFormPage setHobbies(String hobby1, String hobby2, String hobby3) {
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        return this;
    }

    @Step("Set picture")
    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    @Step("Set address")
    public RegistrationFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    @Step("Set state")
    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    @Step("Set city")
    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    @Step("Click submit")
    public RegistrationFormPage submit() {
        $("#submit").click();
        return this;
    }

    @Step("Check result")
    public RegistrationFormPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
        attachScreenshot();
        return this;
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
