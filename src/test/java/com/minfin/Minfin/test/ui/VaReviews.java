package com.minfin.Minfin.test.ui;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.pageobjects.*;
import com.minfin.Minfin.test.TestBase;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VaReviews extends TestBase {
    MainPagePO mainPage = new MainPagePO();
    LoginFormPO loginFormPO = new LoginFormPO();

    // Создание отзыва
    @Test
    public void createReview() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        $(".mfm-auth--input").sendKeys("poseki4371@yncyjs.com");
        $("[name='Password']").sendKeys("123qweQWE");
        $(".mfm-auth--submit-btn.login-form-submit-button").click();
        $x("//button[@id='navigation-undefined']").click();
        $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 styles__AddReviewButton-sc-1phpxpj-35 egksgo TIUKk']").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
        $x("//div[@class='styles__ErrorMessage-sc-1phpxpj-28 jbYlYW']").shouldBe(visible);
        $x("//*[@data-rating='5']").click();
        $x("//button[@data-id='pos_no_errors']").click();
        $x("//textarea[@name='text']").setValue("Безопасность на высшем уровне, хороший курс");
        File imagePath = new File("118521740.jpg");
        $x("//input[@multiple]").uploadFile(imagePath);
        $x("//img[@class='ImageItem__Img']").shouldBe(visible);
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
        $x("(//*[@data-rating='5'])[1]").click();
        $x("(//*[@data-rating='5'])[2]").click();
        $x("(//*[@data-rating='5'])[3]").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 egksgo']").click();
        $x("//div[@class='styles__ModalThanks-sc-1phpxpj-43 kRKYo']").shouldBe(visible);
        Selenide.actions()
                .moveToElement($("#top-banner-wrapper"), 1, 1)
                .click().build()
                .perform();
        $x("//img[@loading='lazy']")
                .scrollIntoView(true);
        $x("//button[@class='styles__Button-sc-1phpxpj-33 styles__AddReviewButton-sc-1phpxpj-35 egksgo TIUKk']")
                .scrollIntoView(false);

        // Проверка на повторное добавление отзыва для того же обменника в течении 24ч

        $x("//button[@class='styles__Button-sc-1phpxpj-33 styles__AddReviewButton-sc-1phpxpj-35 egksgo TIUKk']").click();
        $x(" //span[contains(text(),'Новый отзыв для этого пользователя можно оставить через 24 часа')]").shouldBe(Condition.appear);
        sleep(3000);
        $x("//button[@aria-label='close']").click();
    }

    // Лайк отзыва
    @Test
    public void likeButton() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        $(".mfm-auth--input").sendKeys("poseki4371@yncyjs.com");
        $("[name='Password']").sendKeys("123qweQWE");
        $(".mfm-auth--submit-btn.login-form-submit-button").click();
        $x("//button[@id='navigation-undefined']").click();
        $x("(//button[@data-gtm-el='offers'])[1]").click();

        $x("(//button[@class='styles__LikeButton-c3s3ls-1 gPXnsC'])[1]").scrollTo().click();
        $x("(//button[@class='styles__LikeButton-c3s3ls-1 gPXnsC'])[1]").click();
        $x("(//button[@class='styles__LikeButton-c3s3ls-1 gPXnsC'])[1]").click();
    }

    // Жалоба на отзыв
    @Test
    public void complaint() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        $(".mfm-auth--input").sendKeys("yewosi9268@tlhao86.com");
        $("[name='Password']").sendKeys("123qweQWE");
        $(".mfm-auth--submit-btn.login-form-submit-button").click();
        $x("//button[@id='navigation-undefined']").click();
        $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']").click();
        $x("(//div[@class='UserContextMenu'])[2]").scrollTo().click();
        $x("//button[@class='styles__ContextMenuButton-sc-1phpxpj-37 eypryF']").click();
        $x("(//button[@class='styles__Button-sc-1phpxpj-33 styles__OutlineButton-sc-1phpxpj-34 egksgo clkiGZ'])[1]").click();
        $x("(//div[@class='UserContextMenu'])[2]").scrollTo().click();
        $x("//button[@class='styles__ContextMenuButton-sc-1phpxpj-37 eypryF']").click();
        $x("(//textarea[@name='answer'])[1]").setValue("Test complaint for review");
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
        $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 gCStbe']").shouldBe(visible);

        // Проверка на повторную жалобу на тот же обменник

        $x("(//button[@class='Button UserContextMenu__OptionsButton outlined'])[2]").click();
        $x("//button[@class='styles__ContextMenuButton-sc-1phpxpj-37 eypryF']").click();
        $x("//textarea[@name='answer']").setValue("Test complaint for review");
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
        $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 gCStbe']").shouldBe(visible);

    }

    // Проверка на добавление жалобы для не зарегистрированого пользователя
    @Test
    public void createReviewNoAuth() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        new CurrencyPO().nawBarAll.click();
        SelenideElement card = $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']");
        card.click();

        new ExchangeCardPO().reviewsButton.click();
        // Проверка заполнения обязательных полей (поле общая оценка)
        ReviewsPO reviewsPO = new ReviewsPO();
        reviewsPO.clickNextStep();
        reviewsPO.ratingErrorMassage.shouldBe(visible); // todo delete

        reviewsPO
                .setRatingStar(5)
                .setExcellentService()
                .setReviewText("Безопасность на высшем уровне, хороший курс")
                .uploadImage("118521740.jpg");

        $x("//img[@class='ImageItem__Img']").shouldBe(visible);

        reviewsPO
                .clickNextStep()
                .setRatingStar(1)
                .setRatingStar(2)
                .setRatingStar(3)
                .clickNextStep();

        new LoginPagePO()
                .login("poseki4371@yncyjs.com", "123qweQWE");
        $x("//div[@class='styles__ModalThanks-sc-1phpxpj-43 kRKYo']").shouldBe(visible);

    }


    // Редактирование отзыва юзером с правами администратора

    @Test
    public void editReviewAdmin() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        $(".mfm-auth--input").sendKeys("kider73274@netjook.com");
        $("[name='Password']").sendKeys("123qweQWE");
        $(".mfm-auth--submit-btn.login-form-submit-button").click();
        $x("//button[@id='navigation-undefined']").click();
        $x("//button[@data-gtm-ea='undefined-5f0e43bd66bf9b665803abac']").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 styles__AddReviewButton-sc-1phpxpj-35 egksgo TIUKk']").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();

    }

}

