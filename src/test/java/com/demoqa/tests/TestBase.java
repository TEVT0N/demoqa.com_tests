package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.Attach;
import com.demoqa.config.BrowserConfig;
import com.demoqa.config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        CredentialsConfig Credentialsconfig = ConfigFactory.create(CredentialsConfig.class);
        String login = Credentialsconfig.login();
        String password = Credentialsconfig.password();

        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class, System.getProperties());
        Configuration.browser = browserConfig.browser();
        Configuration.browserVersion =  browserConfig.browserVersion();
        Configuration.browserSize =  browserConfig.browserSize();
        Configuration.baseUrl =  browserConfig.baseUrl();
        Configuration.remote = browserConfig.selenoidUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
