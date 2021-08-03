package com.minfin.Minfin.ui.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

@ExtendWith({TextReportExtension.class})
@ExtendWith({BrowserPerTestStrategyExtension.class})
public class TestBase {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://minfin.com.ua";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.timeout = 10_000;
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
