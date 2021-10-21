package com.minfin.Minfin.ui.test.auction;

import com.minfin.Minfin.api.pojo.MinfinAuthUser;
import com.minfin.Minfin.ui.asserts.ExchangeCardAssert;
import com.minfin.Minfin.ui.asserts.LoginAssert;
import com.minfin.Minfin.ui.asserts.ReviewsAssert;
import com.minfin.Minfin.ui.enums.ExchangeProsAndCons;
import com.minfin.Minfin.ui.pageobjects.LoginPO;
import com.minfin.Minfin.ui.pageobjects.RegisterPO;
import com.minfin.Minfin.ui.pageobjects.currency.auction.*;
import com.minfin.Minfin.ui.test.TestBase;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;

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
    RegisterPO whenRegisterPO = new RegisterPO();
    UserProfile firstExchanger = new UserGenerator().createRandomExchanger();
    UserProfile secondExchanger = new UserGenerator().createRandomExchanger();
    UserProfile firsUserPro = new UserGenerator().createRandomCustomerPro();
    UserProfile secondUserPro = new UserGenerator().createRandomCustomerPro();
    UserProfile firsUserFree = new UserGenerator().createRandomCustomerFree();
    UserProfile secondUserFree = new UserGenerator().createRandomCustomerFree();
    static MinfinAuthUser randomUser;
    @BeforeAll
    static void setupprecondition(){
//        randomUser = new UserService().createRandomUser();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-30")
    @DisplayName("Создание ползователя")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void registerUserViaUi() {
        whenCurrencyPO
                .open()
                .clickLoginButton()
                .clickRegisterButton()
                .setLoginInput()
                .setEmailInput()
                .setPassword1Input()
                .setPassword2Input()
                .clickCheckboxRecaptcha()
                .clickRegisterButton();

    }


    @Test
    //@RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-4")
    @DisplayName("Создание отзыва от пользователя 'Обменник' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReview() {

        whenCurrencyPO
                .openAs(randomUser.getLogin(), randomUser.getPassword())
                .selectNawBarAll()
                .selectCardById(secondExchanger.getId())
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
    //@RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-31")
    @DisplayName("Создание отзыва от пользователя 'Пользователь Pro' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewProToBranch() {
        whenCurrencyPO
                .openAs(firsUserPro.getEmail(), firsUserPro.getPassword())
                .selectNawBarAll()
                .selectCardById(firstExchanger.getId())
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
    //@RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-32")
    @DisplayName("Создание отзыва от пользователя 'Обычный Пользователь' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserFreeToBranch() {
        whenCurrencyPO
                .openAs(firsUserFree.getEmail(), firsUserFree.getPassword())
                .selectNawBarAll()
                .selectCardById(firstExchanger.getId())
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
//    @RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-12")
    @DisplayName("Проверка на повторное добавление отзыва для того же обменника в течении 24ч")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void secondCreateReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), firstExchanger.getPassword())
                .selectNawBarAll()
                .selectCardById(secondExchanger.getId())
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
    //@RepeatedTest(10)
    @Issue("CA-563")
    @TmsLink("CA-A-7")
    @DisplayName("Редактирование отзыва")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void editReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void deleteReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void deleteImageInReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void likeForReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void likeReviewNoAuth() {
        whenCurrencyPO
                .open()
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .clickFirstReviewLike();

        new ModalAuthRegPO().clickAuthRegButton();
        new LoginAssert().currentUrlContainsBaseLoginUrl();
    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-6")
    @DisplayName("Жалоба на отзыв")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void complaintForReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void secondComplaintForReview() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewNoAuth() {
        whenCurrencyPO
                .open()
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8");

        ExchangeCardPO exchangeCardPO = new ExchangeCardPO();
        ReviewsAssert thenReviewsAssert = new ReviewsAssert();
        exchangeCardPO
                .clickReviewButton()
                .clickNextStep();

        thenReviewsAssert.checkRequiredRatingStars();

        whenReviewsPO
                .setRatingStar(3)
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
                .login(firstExchanger.getEmail(), "123qweQWE");
        ModalWindowsPO modalWindows = new ModalWindowsPO();
        modalWindows
                .checkModalThanksForAddReview();

    }


    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-14")
    @DisplayName("Редактирование отзыва юзером с правами администратора")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void editReviewAdmin() {
        whenCurrencyPO
                .openAs("testRVKtest", "test55555")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8");

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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void deleteReviewAdmin() {
        whenCurrencyPO
                .openAs("testRVKtest", "test55555")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8");

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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void recoveryReviewAdmin() {
        whenCurrencyPO
                .openAs("testRVKtest", "test55555")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8");

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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void answerForReview() {
        whenCurrencyPO
                .openAs("pikota1555@whyflkj.com", "123qweQWE");
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
    @Tag("CurrencyAuction")
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void sortNewFirst() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .checkSortNewFirst();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-19")
    @DisplayName("Сортировка 'По умолчанию'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void sortDefault() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .clickSortButton()
                .selectSortByDefault()
                .checkSortByDefault();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-21")
    @DisplayName("Сортировка 'По убыванию рейтинга'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void sortDescendingRating() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .clickSortButton()
                .selectSortDescendingRating()
                .checkSortDescendingRating();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-22")
    @DisplayName("Сортировка 'По возрастанию рейтинга'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void sortRatingGrowth() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .clickSortButton()
                .selectSortRatingGrowth()
                .checkSortRatingGrowth();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-23")
    @DisplayName(" Сортировка 'По популярности'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void sortByPopularity() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .clickSortButton()
                .selectSortByPopularity()
                .checkSortByPopularity();
    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-24")
    @DisplayName("Фильтр 'Отзывы без ответа'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void filterByUnansweredReviews() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .selectUnansweredReviewFilter();
        thenExchangeCardAssert.checkDisplayUnansweredReviewFilter();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-25")
    @DisplayName("Фильтр 'Негативные отзывы'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void filterByNegativeReviews() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .selectNegativeReviewsFilter();
        thenExchangeCardAssert.checkDisplayNegativeReviewFilter();

    }

    @Test
    @Issue("CA-563")
    @TmsLink("CA-A-26")
    @DisplayName("Фильтр 'Положительные отзывы'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void filterByPositiveReviews() {
        whenCurrencyPO
                .openAs(firstExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .selectPositiveReviewsFilter();
        thenExchangeCardAssert.checkDisplayPositiveReviewFilter();

    }


}

