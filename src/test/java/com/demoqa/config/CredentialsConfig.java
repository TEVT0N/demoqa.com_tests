package com.demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/Credentials.properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}