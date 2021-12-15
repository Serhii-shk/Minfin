package com.minfin.Minfin.test;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/test/resources/WebDriverConfig.properties")
public interface WebDriverConfig extends Config {

    @Key("remote.web.browser")
    @DefaultValue("true")
    boolean remoteWebBrowser();

    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();

    @Key("remote.url")
    String remoteUrl();

    @Key("run.environment")
    @DefaultValue("review1")
    String runEnvironment();
}

