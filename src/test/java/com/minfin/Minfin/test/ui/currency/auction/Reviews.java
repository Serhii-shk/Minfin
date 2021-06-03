package com.minfin.Minfin.test.ui.currency.auction;

import com.minfin.Minfin.asserts.currency.auction.ExchangeCardAssert;
import com.minfin.Minfin.asserts.currency.auction.ReviewsAssert;
import com.minfin.Minfin.enums.ExchangeCons;
import com.minfin.Minfin.pageobjects.LoginPO;
import com.minfin.Minfin.pageobjects.currency.auction.CurrencyPO;
import com.minfin.Minfin.pageobjects.currency.auction.ExchangeCardPO;
import com.minfin.Minfin.pageobjects.currency.auction.ModalWindowsPO;
import com.minfin.Minfin.pageobjects.currency.auction.ReviewsPO;
import com.minfin.Minfin.test.TestBase;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class Reviews extends TestBase {

    ReviewsPO whenReviewsPO = new ReviewsPO();
    ReviewsAssert thenReviewsAssert = new ReviewsAssert();
    ExchangeCardAssert thenExchangeCardAssert = new ExchangeCardAssert();
    CurrencyPO whenCurrencyPO = new CurrencyPO();

    // Создание отзыва
    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    @TmsLink("CA-A-4")
    public void createReview() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectFirstCard()
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert
                .checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeCons.ERRORS)
                .setReviewText("Безопасность на высшем уровне, хороший курс")
                .uploadImage("118521740.jpg");

        thenReviewsAssert.checkUploadedImageItem();

        whenReviewsPO
                .clickNextStep()
                .setAvailability5Stars()
                .setCurrencyRate5Stars()
                .setQuality3Stars()
                .setSafety5Stars()
                .clickPublishReviewButton();

        ModalWindowsPO modalWindowsPO = new ModalWindowsPO();
        modalWindowsPO
                .checkModalThanksForAddReview()
                .clickCloseModalsThanksForReview()
                .scrollAfterCreatedReviews();

        // Проверка на повторное добавление отзыва для того же обменника в течении 24ч

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO
                .secondClickReviewButton()
                .checkForAddReviewDuring24()
                .clickOnCloseModal24();

        thenExchangeCardAssert.checkReviewOnModeration();

        // Редактирование отзыва
        exchangeCardPO
                .clickUserContextMenu()
                .clickEditReviewButton();

        whenReviewsPO.setRatingStar(4)
                .setGoodSafety()
                .clearReviewText()
                .setReviewText("Процесс обмена был прозрачным и ясным")
                .uploadImage("images-Train.jpeg");

        thenReviewsAssert.checkUploadedImageItem();

        whenReviewsPO.clickNextStep()
                .setAvailability4Stars()
                .setCurrencyRate4Stars()
                .setQuality4Stars()
                .setSafety4Stars()
                .clickPublishReviewButton();

        // Удаление отзыва
        exchangeCardPO
                .clickUserContextMenu()
                .clickDeleteReviewButton();
        new ExchangeCardAssert()
                .checkModalReviewDeleted();
    }

    // Лайк
    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    public void likeForReview() {
        whenCurrencyPO
                .openAs("poseki4371@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectFirstCard()
                .scrollAndSelectToReviewsLike()
                .checkLikeEnabledForFirstReview()
                .clickReviewsLike()
                .checkLikeDisabledForFirstReview();
    }


    // Жалоба на отзыв
    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    public void complaintForReview() {
        whenCurrencyPO
                .openAs("niser71341@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectFirstCard()
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .clickCancelComplaintButton()
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .setComplaintText()
                .clickPostComplaintButton();

        //  $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 gCStbe']").shouldBe(visible);

        // Проверка на повторную жалобу на тот же обменник

        $x("(//button[@class='Button UserContextMenu__OptionsButton outlined'])[2]").click();
        $x("//button[@class='styles__ContextMenuButton-sc-1phpxpj-37 eypryF']").click();
//        $x("//textarea[@name='answer']").setValue("Test complaint for review");
//        $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']").click();
//        $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 gCStbe']").shouldBe(visible);

    }

    // Проверка на добавление отзыва для не зарегистрированого пользователя
    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    public void createReviewNoAuth() {
        whenCurrencyPO
                .open()
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        ReviewsAssert thenReviewsAssert = new ReviewsAssert();
        exchangeCardPO
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert.checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeCons.ERRORS)
                .setReviewText("Безопасность на высшем уровне, хороший курс")
                .uploadImage("118521740.jpg");

        thenReviewsAssert.checkUploadedImageItem();

        whenReviewsPO
                .clickNextStep()
                .setRatingStar(1)
                .setRatingStar(2)
                .setRatingStar(3)
                .setSafety5Stars()
                .clickNextStep();

        LoginPO loginPO = new LoginPO();
        loginPO
                .login("poseki4371@yncyjs.com", "123qweQWE");

        ModalWindowsPO modalWindows = new ModalWindowsPO();
        modalWindows
                .checkModalThanksForAddReview();

    }

    // Редактирование отзыва юзером с правами администратора

    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    public void editReviewAdmin() {
        whenCurrencyPO
                .openAs("QAE", "qae2021")
                .selectNawBarAll()
                .selectFirstCard();

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        exchangeCardPO
                .clickUserContextMenu()
                .clickEditReviewButton();

        whenReviewsPO
                .clearReviewText()
                .setReviewText("Тест редактирование отзыва Админом")
                .uploadImage("hotpng1.com.png");

        thenReviewsAssert.checkUploadedImageItem();

        whenReviewsPO
                .clickNextStep()
                .clickPublishReviewButton();

        ModalWindowsPO modalWindowsPO = new ModalWindowsPO();
        modalWindowsPO.checkModalEditReview();

        // Удаление отзыва админом
        exchangeCardPO
                .clickUserContextMenu()
                .clickDeleteReviewButton();

        new ExchangeCardAssert().checkModalReviewDeleted();

        modalWindowsPO.clickCloseModalReviewDeleted();

        thenExchangeCardAssert
                .checkReviewDeleted();

        // Востановленин отзыва админом
        exchangeCardPO.clickRestoreReview();

        modalWindowsPO.checkModalReviewRestored();


    }

    // Ответ на отзыв
    @Test
    @Issue("CA-563")
    @Tag("currency-auction")
    public void answerForReview() {
        whenCurrencyPO.openAs("pikota1555@whyflkj.com", "123qweQWE");

        $x("//button[@data-gtm-ea='my-branches-top']").click();
        $x("//div[@class='exchanger-card__content']").click();
        $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ']").click();
        $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]").click();
        $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']").click();
        $x("//div[@class='errorText']").shouldBe(visible);
        $x("//div[@class='feedback__message TextareaWrapper']").setValue("Ответ Обменника на отзыв");
        $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']").click();


    }
}

