package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("Burmis")
@Feature("Registration")
@DisplayName("Class for registrations tests")
public class RegistrationTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();
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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @DisplayName("Successful registration")
    @Test
    void successfulRegistration() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby1, hobby2, hobby3)
                .setPicture(imgPath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .checkResult("Student Name", (firstName + " " + lastName))
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
    }

    @ValueSource(strings = {
            "1900",
            "2000"
    })
    @DisplayName("Successful registration")
    @ParameterizedTest(name = "with {0} year")
    void successfulParametrizedRegistration(String testData) {

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, testData)
                .setSubject(subject)
                .setHobbies(hobby1, hobby2, hobby3)
                .setPicture(imgPath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
                .checkResult("Student Name", (firstName + " " + lastName))
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", (day + " " + month + "," + testData))
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby1)
                .checkResult("Hobbies", hobby2)
                .checkResult("Hobbies", hobby3)
                .checkResult("Picture", imgPath)
                .checkResult("Address", address)
                .checkResult("State and City", (state + " " + city));
    }
}








