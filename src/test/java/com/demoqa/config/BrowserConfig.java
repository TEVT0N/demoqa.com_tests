package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${config}.properties")
public interface BrowserConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("102.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    @DefaultValue("https://demoqa.com")
    String baseUrl();

    String selenoidUrl();



}
