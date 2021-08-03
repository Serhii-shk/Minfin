package com.minfin.Minfin.ui.test.auction;

import com.minfin.Minfin.api.pojo.MinfinAuthUser;
import com.minfin.Minfin.api.services.UserService;
import com.minfin.Minfin.ui.asserts.ExchangeCardAssert;
import com.minfin.Minfin.ui.asserts.LoginAssert;
import com.minfin.Minfin.ui.asserts.ReviewsAssert;
import com.minfin.Minfin.ui.enums.ExchangeProsAndCons;
import com.minfin.Minfin.ui.pageobjects.LoginPO;
import com.minfin.Minfin.ui.pageobjects.currency.auction.*;
import com.minfin.Minfin.ui.test.TestBase;
import com.minfin.Minfin.utils.StringUtils;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;
import static io.restassured.RestAssured.given;

@DisplayName("Тесты UI")
    public class Reviews extends TestBase {
        ReviewsPO whenReviewsPO = new ReviewsPO();
        ReviewsAssert thenReviewsAssert = new ReviewsAssert();
        ExchangeCardAssert thenExchangeCardAssert = new ExchangeCardAssert();
        CurrencyPO whenCurrencyPO = new CurrencyPO();
        MyExchangersPO myExchangersPO = new MyExchangersPO();
        ExchangeCardPO whenExchangeCardPO = new ExchangeCardPO();
        ModalWindowsPO modalWindowsPO = new ModalWindowsPO();


    @Test
    //@RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-4")
    @DisplayName("Создание отзыва")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void createReview() {

        MinfinAuthUser randomUser = new UserService().createRandomUser();
        new UserService().authUser(randomUser.getLogin());


        whenCurrencyPO
                .openAs(randomUser.getLogin(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("velep69883-60f8082ce590f23e86b51096")
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert
                .checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeProsAndCons.POS_NO_ERRORS)
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

        modalWindowsPO
                .checkModalThanksForAddReview()
                .clickCloseModalsThanksForReview()
                .scrollAfterCreatedReviews();

        thenExchangeCardAssert.checkReviewOnModeration();
    }



    @Test
    @RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-12")
    @DisplayName("Проверка на повторное добавление отзыва для того же обменника в течении 24ч")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void secondCreateReview() {

        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        given().log().all().accept(ContentType.JSON)
                .auth().basic("minfin", "Vs7ek37PQk")
                .contentType("multipart/form-data")
                .multiPart("Email", email)
                .multiPart("Login", "test_xesil26867")
                .multiPart("Password", "123qweQWE")
                .multiPart("Privacy", true)
                .multiPart("Rules", true)
                .multiPart("check", 2)
                .multiPart("first_name", "test_xesil26867")
                .multiPart("phone", "380970004432")
                .when().post("https://minfin.com.ua/api/user/register/")
                .then().log().body().statusCode(200);

        given()
                .with()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("Login", email)
                .formParam("Password", "123qweQWE")
                .post("https://minfin.com.ua/api/ib/partner/auth").then().statusCode(200);


        given()
                .header("Cookie", "minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781")
                .when().get("https://minfin.com.ua/api/auth/auction-review/")
                .then().log().body().statusCode(200);

        whenCurrencyPO
                .openAs(email, "123qweQWE")
                .selectNawBarAll()
                .selectCardById("velep69883-60f8082ce590f23e86b51096")
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert
                .checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeProsAndCons.POS_NO_ERRORS)
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

        modalWindowsPO
                .checkModalThanksForAddReview()
                .clickCloseModalsThanksForReview()
                .scrollAfterCreatedReviews();

        thenExchangeCardAssert.checkReviewOnModeration();

        whenExchangeCardPO
                .secondClickReviewButton()
                .checkForAddReviewDuring24()
                .clickOnCloseModal24();

    }


    @Test
    @RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-7")
    @DisplayName("Редактирование отзыва")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void editReview() {

        String email = "test_" + StringUtils.randomAlphabeticString(5) + "@test.test";
        given().log().all().accept(ContentType.JSON)
                .auth().basic("minfin", "Vs7ek37PQk")
                .contentType("multipart/form-data")
                .multiPart("Email", email)
                .multiPart("Login", "test_xesil26867")
                .multiPart("Password", "123qweQWE")
                .multiPart("Privacy", true)
                .multiPart("Rules", true)
                .multiPart("check", 2)
                .multiPart("first_name", "test_xesil26867")
                .multiPart("phone", "380970004432")
                .when().post("https://minfin.com.ua/api/user/register/")
                .then().log().body().statusCode(200);

        given()
                .with()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("Login", email)
                .formParam("Password", "123qweQWE")
                .post("https://minfin.com.ua/api/ib/partner/auth").then().statusCode(200);


        given()
                .header("Cookie", "minfin_sessions=a7497b06881fa70bc5bc7ed6ca0c6387a1c6b781")
                .when().get("https://minfin.com.ua/api/auth/auction-review/")
                .then().log().body().statusCode(200);

            whenCurrencyPO
                    .openAs(email, "123qweQWE")
                    .selectNawBarAll()
                    .selectCardById("velep69883-60f8082ce590f23e86b51096")
                    .clickReviewButton()
                    .clickNextStep();

            thenReviewsAssert
                    .checkRequiredRatingStars();

            whenReviewsPO
                    .setRatingStar(5)
                    .setCons(ExchangeProsAndCons.POS_NO_ERRORS)
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

            modalWindowsPO
                    .checkModalThanksForAddReview()
                    .clickCloseModalsThanksForReview()
                    .scrollAfterCreatedReviews();

            thenExchangeCardAssert.checkReviewOnModeration();

            whenExchangeCardPO
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
    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-8")
    @DisplayName("Удаление отзыва")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void deleteReview() {
        whenCurrencyPO
                .openAs("nitem11330@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert
                .checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeProsAndCons.POS_NO_ERRORS)
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

        modalWindowsPO
                .checkModalThanksForAddReview()
                .clickCloseModalsThanksForReview()
                .scrollAfterCreatedReviews();

        whenExchangeCardPO
                .clickUserContextMenu()
                .clickDeleteReviewButton();

        thenExchangeCardAssert
                .checkModalReviewDeleted();
    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-9")
    @DisplayName("Удаление картинки в отзыве")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void deleteImageInReview() {
        whenCurrencyPO
                .openAs("jocalog352@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert
                .checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeProsAndCons.POS_NO_ERRORS)
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

        modalWindowsPO
                .checkModalThanksForAddReview()
                .clickCloseModalsThanksForReview()
                .scrollAfterCreatedReviews();

        thenExchangeCardAssert.checkReviewOnModeration();

        whenExchangeCardPO
                .clickUserContextMenu()
                .clickEditReviewButton();

        whenReviewsPO
                .clickRemoveImageButton();

        thenReviewsAssert
                .checkDeletedImage();

        whenReviewsPO
                .clickNextStep()
                .clickPublishReviewButton();
    }



    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-5")
    @DisplayName("Лайк для отзыва")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void likeForReview() {
        whenCurrencyPO
                .openAs("poseki4371@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickFirstReviewLike()
                .checkLikeEnabledForFirstReview()
                .clickReviewsLike()
                .checkLikeDisabledForFirstReview();
    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-10")
    @DisplayName("Лайк для не авторизованого юзера")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void likeReviewNoAuth(){
        whenCurrencyPO
                .open()
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickFirstReviewLike();

        new ModalAuthRegPO().clickAuthRegButton();
        new LoginAssert().currentUrlContainsBaseLoginUrl();
    }



    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-6")
    @DisplayName("Жалоба на отзыв")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void complaintForReview() {
        whenCurrencyPO
                .openAs("niser71341@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .clickCancelComplaintButton()
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .setComplaintText()
                .clickPostComplaintButton()
                .checkModalComplaintPosted();
    }



    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-11")
    @DisplayName("Проверка на повторную жалобу на тот же обменник")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void secondComplaintForReview() {
        whenCurrencyPO
                .openAs("niser71341@yncyjs.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .setComplaintText()
                .clickPostComplaintButton()
                .checkModalComplaintPosted()
                .clickUserContextMenu()
                .clickContextMenuComplaintButton()
                .setComplaintText()
                .clickPostComplaintButton()
                .checkModalForbiddenAddComplaint();

    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-13")
    @DisplayName("Проверка на добавление отзыва для не зарегистрированого пользователя")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void createReviewNoAuth() {
        whenCurrencyPO
                .open()
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406");

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        ReviewsAssert thenReviewsAssert = new ReviewsAssert();
        exchangeCardPO
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert.checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(5)
                .setCons(ExchangeProsAndCons.ERRORS)
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



    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-14")
    @DisplayName("Редактирование отзыва юзером с правами администратора")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void editReviewAdmin() {
        whenCurrencyPO
                .openAs("QAE", "qae2021")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406");

        whenExchangeCardPO
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
    }




    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-15")
    @DisplayName("Удаление отзыва админом")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void deleteReviewAdmin() {
        whenCurrencyPO
                .openAs("QAE", "qae2021")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406");

        whenExchangeCardPO
                .clickUserContextMenu()
                .clickDeleteReviewButton();

        thenExchangeCardAssert
                .checkModalReviewDeleted();

        modalWindowsPO
                .clickCloseModalReviewDeleted();

        thenExchangeCardAssert
                .checkReviewDeleted();
    }



    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-16")
    @DisplayName("Востановление отзыва админом")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void recoveryReviewAdmin() {
        whenCurrencyPO
                .openAs("QAE", "qae2021")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406");

        whenExchangeCardPO
                .clickUserContextMenu()
                .clickDeleteReviewButton();

        thenExchangeCardAssert
                .checkModalReviewDeleted();

        modalWindowsPO
                .clickCloseModalReviewDeleted();

        thenExchangeCardAssert
                .checkReviewDeleted();

        whenExchangeCardPO
                .clickRestoreReview();

        modalWindowsPO
                .checkModalReviewRestored();


    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-17")
    @DisplayName("Ответ на отзыв")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void answerForReview() {
        whenCurrencyPO.openAs("pikota1555@whyflkj.com", "123qweQWE");
        myExchangersPO
                .clickOnMyExchangersButton()
                .clickMyFirstExchanger()
                .clickSortButton()
                .selectSortNewFirst()
                .clickAnswerForReviewButton()
                .clickSendAnswerReviewButton();
        thenExchangeCardAssert.checkErrorMassageAnswer();
        whenExchangeCardPO
                .setValueTextInputField()
                .clickSendAnswerReviewButton()
                .checkModalAnswerPosted();
        modalWindowsPO.clickCloseModalAnswerPosted();
    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-18")
    @DisplayName("Редактирование ответа на отзыв")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void editAnswerForReview() {
        whenCurrencyPO.openAs("pikota1555@whyflkj.com", "123qweQWE");
        myExchangersPO
                .clickOnMyExchangersButton()
                .clickMyFirstExchanger()
                .clickSortButton()
                .selectSortNewFirst()
                .clickEditAnswerButtonForFirstReview()
                .clearAnswerText()
                .setValueEditAnswerText()
                .clickSendAnswerReviewButton()
                .checkModalAnswerEdited();
        modalWindowsPO.clickCloseModalAnswerPosted();

    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-20")
    @DisplayName("Сортировка 'Сначала новые'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void sortNewFirst() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .checkSortNewFirst();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-19")
    @DisplayName("Сортировка 'По умолчанию'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void sortDefault() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickSortButton()
                .selectSortByDefault()
                .checkSortByDefault();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-21")
    @DisplayName("Сортировка 'По убыванию рейтинга'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void sortDescendingRating() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickSortButton()
                .selectSortDescendingRating()
                .checkSortDescendingRating();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-22")
    @DisplayName("Сортировка 'По возрастанию рейтинга'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void sortRatingGrowth() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickSortButton()
                .selectSortRatingGrowth()
                .checkSortRatingGrowth();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-23")
    @DisplayName(" Сортировка 'По популярности'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void sortByPopularity() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .clickSortButton()
                .selectSortByPopularity()
                .checkSortByPopularity();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-24")
    @DisplayName("Фильтр 'Отзывы без ответа'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void filterByUnansweredReviews() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .selectUnansweredReviewFilter();
        thenExchangeCardAssert.checkDisplayUnansweredReviewFilter();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-25")
    @DisplayName("Фильтр 'Негативные отзывы'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void filterByNegativeReviews() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .selectNegativeReviewsFilter();
        thenExchangeCardAssert.checkDisplayNegativeReviewFilter();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-26")
    @DisplayName("Фильтр 'Положительные отзывы'")
    @Tag("UI")
    @Tag("Currency auction")
    @Tag("Reviews")
    public void filterByPositiveReviews() {
        whenCurrencyPO
                .openAs("mejin95276@tlhao86.com", "123qweQWE")
                .selectNawBarAll()
                .selectCardById("pikota1555-609a62e0d7df019585ada406")
                .selectPositiveReviewsFilter();
        thenExchangeCardAssert.checkDisplayPositiveReviewFilter();

    }


}

