package com.minfin.Minfin.test.ui;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.pageobjects.LoginFormPO;
import com.minfin.Minfin.pageobjects.MainPagePO;
import com.minfin.Minfin.test.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VaReviews extends TestBase {
    MainPagePO mainPage = new MainPagePO();
    LoginFormPO loginFormPO = new LoginFormPO();


    @Test
    public void abc () throws InterruptedException {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        $(".mfm-auth--input").sendKeys("niser71341@yncyjs.com");
        $("[name='Password']").sendKeys("123qweQWE");
        $(".mfm-auth--submit-btn.login-form-submit-button").click();
        $x("//button[@id='navigation-undefined']").click();
        $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 styles__AddReviewButton-sc-1phpxpj-35 egksgo TIUKk']").click();
        $x("//span[@class='styles__List-sc-1xc8jbl-1 deDinl']/*[5]").click();
        $x("//button[@data-id='pos_no_errors']").click();
        $x("//textarea[@name='text']").setValue("Безопасность на высшем уровне, хороший курс");
        $x("//input[@type='file']").uploadFile(new File("/Users/serhii_shkurenko/Desktop/projects/images/118521740.jpg"));
        //Thread.sleep(5000);
        //$x("//img[@class='ImageItem__Img']").shouldBe(Condition.appear);
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
        $x("(//span[@class='styles__List-sc-1xc8jbl-1 deDinl']/*[5])[1]");
        $x("(//span[@class='styles__List-sc-1xc8jbl-1 deDinl']/*[5])[2]");
        $x("(//span[@class='styles__List-sc-1xc8jbl-1 deDinl']/*[4])[3]");
        $x("//button[@class='styles__Button-sc-1phpxpj-33 egksgo']").click();
        $x("//div[@class='styles__ModalThanks-sc-1phpxpj-43 kRKYo']").shouldBe(Condition.appear);

        sleep(5000);
    }

    }
