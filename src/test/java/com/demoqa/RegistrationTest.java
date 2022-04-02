package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationTest {
    $("[id=firstName"]).setValue("Sergey");
    }


}
