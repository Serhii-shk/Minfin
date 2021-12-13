package com.minfin.Minfin.ui.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
@ExtendWith({BrowserPerTestStrategyExtension.class})
public abstract class TestBase {

    private static String env;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://minfin.com.ua";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.timeout = 10_000;
        getEnv();
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    public static String getEnv() {
        String configEnv = "stage";
        switch (configEnv) {
            case "review1":
                env = "review1";
                break;
            case "review2":
                env = "review2";
                break;
            case "stage":
            default:
                env = "stage";
                break;
        }

        return env;
    }
}
