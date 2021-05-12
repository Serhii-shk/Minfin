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

        LoginPagePO loginPagePO = new LoginPagePO();
        loginPagePO
                .login("poseki4371@yncyjs.com", "123qweQWE");

        CurrencyPO currencyPO = new CurrencyPO();
        currencyPO
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO
                .clickReviewButton();

        ReviewsPO reviewsPO = new ReviewsPO();
        reviewsPO.clickNextStep()
                 .checkRequiredRatingStars()
                 .setRatingStar(5)
                 .setExcellentService()
                 .setReviewText("Безопасность на высшем уровне, хороший курс")
                 .uploadImage("118521740.jpg")
                 .checkUploadedImageItem()
                 .clickNextStep()
                 .setRatingStar(1)
                 .setRatingStar(2)
                 .setRatingStar(3)
                 .clickNextStep();

        ModalWindows modalWindows = new ModalWindows();
        modalWindows
                .checkModalThanksForAddReview();

        Selenide.actions()
                .moveToElement($("#top-banner-wrapper"), 1, 1)
                .click().build()
                .perform();
        $x("//img[@loading='lazy']")
                .scrollIntoView(true);

        exchangeCardPO
                .reviewsButton.scrollIntoView(false);

        // Проверка на повторное добавление отзыва для того же обменника в течении 24ч

        exchangeCardPO
                .clickReviewButton();
        modalWindows
                .checkForAddReviewDuring24()
                .clickOnCloseModal();


    }

    // Лайк
    @Test
    public void likeForReview() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        LoginPagePO loginPagePO = new LoginPagePO();
        loginPagePO
                .login("poseki4371@yncyjs.com", "123qweQWE");
        CurrencyPO currencyPO = new CurrencyPO();
        currencyPO
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO
                .scrollAndSelectToReviewsLike()
                .clickReviewsLike()
                // добавить проверку enabled like
                .clickReviewsLike();
                // добавить проверку disabled like


    }

    // Жалоба на отзыв
    @Test
    public void complaintForReview() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        LoginPagePO loginPagePO = new LoginPagePO();
        loginPagePO
                .login("niser71341@yncyjs.com", "123qweQWE");
        CurrencyPO currencyPO = new CurrencyPO();
        currencyPO
                .selectNawBarAll()
                .selectFirstCard();


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

    // Проверка на добавление отзыва для не зарегистрированого пользователя
    @Test
    public void createReviewNoAuth() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        CurrencyPO currencyPO = new CurrencyPO();
        currencyPO
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO.clickReviewButton();

        // Проверка заполнения обязательных полей (поле общая оценка)
        ReviewsPO reviewsPO = new ReviewsPO();
        reviewsPO
                .clickNextStep()
                .checkRequiredRatingStars() // todo delete
                .setRatingStar(5)
                .setExcellentService()
                .setReviewText("Безопасность на высшем уровне, хороший курс")
                .uploadImage("118521740.jpg")
                .checkUploadedImageItem()
                .clickNextStep()
                .setRatingStar(1)
                .setRatingStar(2)
                .setRatingStar(3)
                .clickNextStep();

        LoginPagePO loginPagePO = new LoginPagePO();
        loginPagePO
                .login("poseki4371@yncyjs.com", "123qweQWE");

        ModalWindows modalWindows = new ModalWindows();
        modalWindows
                .checkModalThanksForAddReview();

    }

    // Редактирование отзыва юзером с правами администратора

    @Test
    public void editReviewAdmin() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        LoginPagePO loginPagePO = new LoginPagePO();
        loginPagePO
                .login("kider73274@netjook.com","123qweQWE");

        CurrencyPO currencyPO = new CurrencyPO();
        currencyPO
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO
                .clickReviewButton();

        ReviewsPO reviewsPO = new ReviewsPO();
        reviewsPO
                .clickNextStep();



    }

}

