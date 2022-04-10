package com.demoqa;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistration() {

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
}







