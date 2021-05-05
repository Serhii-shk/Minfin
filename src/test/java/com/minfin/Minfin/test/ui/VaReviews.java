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

        new LoginPagePO()
                .login("poseki4371@yncyjs.com", "123qweQWE");
        new CurrencyPO()
                .nawBarAll.click();
        new CurrencyPO()
                .card.click();
        new ExchangeCardPO()
                .reviewsButton.click();
        ReviewsPO reviewsPO = new ReviewsPO();

        reviewsPO
                .nextStep.click();
        reviewsPO
                .ratingErrorMassage.shouldBe(visible);

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

        new ModalWindows()
                .thanksForReview.shouldBe(visible);

        Selenide.actions()
                .moveToElement($("#top-banner-wrapper"), 1, 1)
                .click().build()
                .perform();
        $x("//img[@loading='lazy']")
                .scrollIntoView(true);

        new ExchangeCardPO()
                .reviewsButton.scrollIntoView(false);

        // Проверка на повторное добавление отзыва для того же обменника в течении 24ч

        new ExchangeCardPO().reviewsButton.click();
        new ModalWindows().nextReviewAfter24.shouldBe(Condition.appear);

        sleep(3000);

        new ModalWindows().closeModalWindow.click();

    }

    // Лайк отзыва
    @Test
    public void likeButton() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        new LoginPagePO()
                .login("poseki4371@yncyjs.com", "123qweQWE");
        new CurrencyPO()
                .nawBarAll.click();
        new CurrencyPO()
                .card.click();
        new ExchangeCardPO()
                .reviewsLike.scrollTo().click();
        new ExchangeCardPO()
                .reviewsLike.click();
        new ExchangeCardPO()
                .reviewsLike.click();

    }

    // Жалоба на отзыв
    @Test
    public void complaint() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        new LoginPagePO()
                .login("niser71341@yncyjs.com", "123qweQWE");
        new CurrencyPO()
                .nawBarAll.click();
        new CurrencyPO()
                .card.click();

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
        new CurrencyPO()
                .nawBarAll.click();
        new CurrencyPO()
                .card.click();
        new ExchangeCardPO()
                .reviewsButton.click();
        // Проверка заполнения обязательных полей (поле общая оценка)
        ReviewsPO reviewsPO = new ReviewsPO();
        reviewsPO
                .clickNextStep();
        reviewsPO
                .ratingErrorMassage.shouldBe(visible); // todo delete

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
        new ModalWindows()
                .thanksForReview.shouldBe(visible);

    }


    // Редактирование отзыва юзером с правами администратора

    @Test
    public void editReviewAdmin() {
        open("https://minfin.com.ua/currency/auction-review/", AuthenticationType.BASIC, "tester", "qO5pI8fD1wN4qZ3w");
        mainPage.authButton.click();
        new LoginPagePO()
                .login("kider73274@netjook.com","123qweQWE");
        new CurrencyPO()
                .nawBarAll.click();
        new CurrencyPO()
                .card.click();
        new ExchangeCardPO()
                .reviewsButton.click();  //???
        new ReviewsPO()
                .nextStep.click();


    }

}

