package com.minfin.Minfin.ui.pageobjects;

import com.codeborne.selenide.SelenideElement;

import com.minfin.Minfin.utils.StringUtils;

import static com.codeborne.selenide.Selenide.*;

import static io.qameta.allure.Allure.step;

public class RegisterPO {

    private SelenideElement loginInput = $x("(//input[@name='Login'])[4]");
    private SelenideElement emailInput = $x("(//input[@name='Email'])[4]");
    private SelenideElement password1Input = $("dd#password1 input");
    private SelenideElement password2Input = $("dd#password2 input");
    private SelenideElement checkboxRecaptcha = $x("//div[@role='presentation'][2]");
    private SelenideElement registerButton = $x("//input[@id='registrationFormSubmit']");

    String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
    String login = "tester" + StringUtils.randomAlphabeticString(5);

    public RegisterPO setLoginInput() {
        step("when input random login", () -> loginInput.setValue(login));
        return this;
    }

    public RegisterPO setEmailInput() {
        emailInput.setValue(email);
        return this;
    }

    public RegisterPO setPassword1Input() {
        password1Input.setValue("123qweQWE");
        return this;
    }

    public RegisterPO setPassword2Input() {
        password2Input.setValue("123qweQWE");
        return this;
    }

    public RegisterPO clickCheckboxRecaptcha() {
       executeJavaScript(
               "document.getElementById('recaptcha-anchor').click()");
        switchTo().innerFrame("a-1qkvl361b20x");
        checkboxRecaptcha.click();
        return this;
    }

    public RegisterPO clickRegisterButton() {
        registerButton.click();
        return this;
    }

}
