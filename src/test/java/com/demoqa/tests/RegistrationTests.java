package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.HashMap;
import java.util.Map;

@Owner("Burmis")
@Feature("Registration")
@DisplayName("Registration tests")
public class RegistrationTests extends TestBase {

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

    @Test
    @DisplayName("Successful registration")
    void successfulRegistration() {
        Map<String, String> map = new HashMap<>();
        map.put("Student Name", (firstName + " " + lastName));
        map.put("Student Email", email);
        map.put("Gender", gender);
        map.put("Mobile", phoneNumber);
        map.put("Date of Birth", (day + " " + month + "," + year));
        map.put("Subjects", subject);
        map.put("Hobbies", hobby1);
        map.put("Hobbies", hobby2);
        map.put("Hobbies", hobby3);
        map.put("Picture", imgPath);
        map.put("Address", address);
        map.put("State and City", (state + " " + city));
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
                .checkResult(new HashMap<>());
    }

    @ValueSource(strings = {
            "1900",
            "2000"
    })

    @ParameterizedTest(name = "with {0} year")
    @DisplayName("Successful registration")
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
                .checkResult(new HashMap<>());
    }
}








