package com.minfin.Minfin.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.minfin.Minfin.test.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Objects;

@ExtendWith({TextReportExtension.class})
public abstract class TestBase {

    public static String environment;

    public TestBase() {

    }

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.timeout = 10_000;
        environment =
                Objects.isNull(System.getenv("ENVIRONMENT")) ? getWebDriverConfig().runEnvironment()
                        : System.getenv("ENVIRONMENT");
        Configuration.remote =
                getWebDriverConfig().remoteWebBrowser() ? getWebDriverConfig().remoteUrl() : null;
    }

    public static WebDriverConfig getWebDriverConfig() {
        return ConfigFactory.create(WebDriverConfig.class);
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
