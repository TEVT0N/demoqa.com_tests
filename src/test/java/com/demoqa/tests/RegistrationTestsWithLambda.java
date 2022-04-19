package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Burmis")
@Feature("Registration")
@DisplayName("Class for registrations tests with lambda")
public class RegistrationTestsWithLambda {

    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            phoneNumber = faker.numerify("##########"),
            day = "29",
            month = "October",
            year = "1990",
            subject = "English",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            imgPath = "photo2.jpg",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Successful registration")
    @Test
    void successfulRegistration() {
        step("Open registration page", () -> {
            registrationFormPage.openPage();
        });
        step("Set first name", () -> {
            registrationFormPage.setFirstName(firstName);
        });
        step("Set last name", () -> {
            registrationFormPage.setLastName(lastName);
        });
        step("Set email", () -> {
            registrationFormPage.setEmail(email);
        });
        step("Set gender", () -> {
            registrationFormPage.setGender(gender);
        });
        step("Set phone number", () -> {
            registrationFormPage.setPhoneNumber(phoneNumber);
        });
        step("Set birth date", () -> {
            registrationFormPage.setBirthDate(day, month, year);
        });
        step("Set subject", () -> {
            registrationFormPage.setSubject(subject);
        });
        step("Set hobbies", () -> {
            registrationFormPage.setHobbies(hobby1, hobby2, hobby3);
        });
        step("Set picture", () -> {
            registrationFormPage.setPicture(imgPath);
        });
        step("Set address", () -> {
            registrationFormPage.setAddress(address);
        });
        step("Set state", () -> {
            registrationFormPage.setState(state);
        });
        step("Set city", () -> {
            registrationFormPage.setCity(city);
        });
        step("Click submit", () -> {
            registrationFormPage.submit();
        });
        step("Check result", () -> {
            registrationFormPage.checkResult("Student Name", (firstName + " " + lastName))
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", (day + " " + month + "," + year))
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby1)
                    .checkResult("Hobbies", hobby2)
                    .checkResult("Hobbies", hobby3)
                    .checkResult("Picture", imgPath)
                    .checkResult("Address", address)
                    .checkResult("State and City", (state + " " + city));
        });
    }

    @ValueSource(strings = {
            "1900",
            "2000"
    })
    @DisplayName("Successful registration")
    @ParameterizedTest(name = "with {0} year")
    void successfulParametrizedRegistration(String testData) {

        step("Open registration page", () -> {
            registrationFormPage.openPage();
        });
        step("Set first name", () -> {
            registrationFormPage.setFirstName(firstName);
        });
        step("Set last name", () -> {
            registrationFormPage.setLastName(lastName);
        });
        step("Set email", () -> {
            registrationFormPage.setEmail(email);
        });
        step("Set gender", () -> {
            registrationFormPage.setGender(gender);
        });
        step("Set phone number", () -> {
            registrationFormPage.setPhoneNumber(phoneNumber);
        });
        step("Set birth date", () -> {
            registrationFormPage.setBirthDate(day, month, year);
        });
        step("Set subject", () -> {
            registrationFormPage.setSubject(subject);
        });
        step("Set hobbies", () -> {
            registrationFormPage.setHobbies(hobby1, hobby2, hobby3);
        });
        step("Set picture", () -> {
            registrationFormPage.setPicture(imgPath);
        });
        step("Set address", () -> {
            registrationFormPage.setAddress(address);
        });
        step("Set state", () -> {
            registrationFormPage.setState(state);
        });
        step("Set city", () -> {
            registrationFormPage.setCity(city);
        });
        step("Click submit", () -> {
            registrationFormPage.submit();
        });
        step("Check result", () -> {
            registrationFormPage.checkResult("Student Name", (firstName + " " + lastName))
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phoneNumber)
                    .checkResult("Date of Birth", (day + " " + month + "," + year))
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby1)
                    .checkResult("Hobbies", hobby2)
                    .checkResult("Hobbies", hobby3)
                    .checkResult("Picture", imgPath)
                    .checkResult("Address", address)
                    .checkResult("State and City", (state + " " + city));
        });
    }
}







