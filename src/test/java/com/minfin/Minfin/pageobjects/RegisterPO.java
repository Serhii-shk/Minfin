package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPO {

    public SelenideElement loginInput =$("#login input");
    public SelenideElement emailInput =$("#email input");
    public SelenideElement password1Input =$("#password1 input");
    public SelenideElement password2Input =$("#password2 input");

}
