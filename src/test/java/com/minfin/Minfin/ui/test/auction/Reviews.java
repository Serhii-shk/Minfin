package com.minfin.Minfin.ui.test.auction;

import com.minfin.Minfin.api.generation.UserGenerator;
import com.minfin.Minfin.api.model.common.UserProfile;
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
    //UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
    //UserProfile exchangerWithPaidSubscription = new UserGenerator().createRandomExchangerWithPaidSubscription();
    //UserProfile pureCustomerPro = new UserGenerator().createPureRandomCustomerPro();
    //UserProfile customerProWithSubscription = new UserGenerator().createRandomCustomerProWithPaidSubscription();
    //UserProfile pureCustomerFree = new UserGenerator().createPureRandomCustomerFree();
    //UserProfile customerFreeWithAdt = new UserGenerator().createRandomCustomerFreeWithAdt();
    static MinfinAuthUser randomUser;
    @BeforeAll
    static void setupprecondition(){
//        randomUser = new UserService().createRandomUser();
    }

//    @Test
//    //@RepeatedTest(10)
//    @Issue("CA-563")
//    @TmsLink("CA-A-30")
//    @DisplayName("Создание ползователя")
//    @Tag("UI")
//    @Tag("CurrencyAuction")
//    @Tag("Reviews")
//    public void registerUserViaUi() {
//        whenCurrencyPO
//                .open()
//                .clickLoginButton()
//                .clickRegisterButton()
//                .setLoginInput()
//                .setEmailInput()
//                .setPassword1Input()
//                .setPassword2Input()
//                .clickCheckboxRecaptcha()
//                .clickRegisterButton();
//
//    }   // тест не актуален пока не решиться проблема с рекапчей


    @Test
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-4")
    @DisplayName("Создание отзыва от пользователя 'Обменник' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewBranchToBranch() {
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        UserProfile exchangerWithPaidSubscription = new UserGenerator().createRandomExchangerWithPaidSubscription();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), pureExchanger.getPassword())
                .selectNawBarAll()
                .selectCardById(exchangerWithPaidSubscription.getId())
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
    //@RepeatedTest(10) //pass
    @Issue("CA-563")
    @TmsLink("CA-A-31")
    @DisplayName("Создание отзыва от пользователя 'Пользователь Pro' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewProToBranch() {
        UserProfile pureCustomerPro = new UserGenerator().createPureRandomCustomerPro();
        UserProfile exchangerWithPaidSubscription = new UserGenerator().createRandomExchangerWithPaidSubscription();
        whenCurrencyPO
                .openAs(pureCustomerPro.getEmail(), pureCustomerPro.getPassword())
                .selectNawBarAll()
                .selectCardById(exchangerWithPaidSubscription.getId())
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-32")
    @DisplayName("Создание отзыва от пользователя 'Обычный Пользователь' для 'Обменника'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserFreeToBranch() {
        UserProfile exchangerWithPaidSubscription = new UserGenerator().createRandomExchangerWithPaidSubscription();
        UserProfile pureCustomerFree = new UserGenerator().createPureRandomCustomerFree();
        whenCurrencyPO
                .openAs(pureCustomerFree.getEmail(), pureCustomerFree.getPassword())
                .selectNawBarAll()
                .selectCardById(exchangerWithPaidSubscription.getId())
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-33")
    @DisplayName("Создание отзыва от пользователя 'Пользователя Pro' для 'Пользователя Pro'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserProToUserPro() {
        UserProfile pureCustomerPro = new UserGenerator().createPureRandomCustomerPro();
        UserProfile customerProWithSubscription = new UserGenerator().createRandomCustomerProWithPaidSubscription();
        whenCurrencyPO
                .openAs(pureCustomerPro.getEmail(), pureCustomerPro.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerProWithSubscription.getId())
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-34")
    @DisplayName("Создание отзыва от пользователя 'Обменник' для 'Пользователя Pro'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewBranchToUserPro() {
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        UserProfile customerProWithSubscription = new UserGenerator().createRandomCustomerProWithPaidSubscription();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), pureExchanger.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerProWithSubscription.getId())
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
               // .setAvailability5Stars()
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-35")
    @DisplayName("Создание отзыва от 'Обычного пользователя' для 'Пользователя Pro'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserFreeToUserPro() {
        UserProfile customerProWithSubscription = new UserGenerator().createRandomCustomerProWithPaidSubscription();
        UserProfile pureCustomerFree = new UserGenerator().createPureRandomCustomerFree();
        whenCurrencyPO
                .openAs(pureCustomerFree.getEmail(), pureCustomerFree.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerProWithSubscription.getId())
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-36")
    @DisplayName("Создание отзыва от 'Обычного пользователя' для 'Обычного пользователя'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserFreeToUserFree() {
        UserProfile pureCustomerFree = new UserGenerator().createPureRandomCustomerFree();
        UserProfile customerFreeWithAdt = new UserGenerator().createRandomCustomerFreeWithAdt();
        whenCurrencyPO
                .openAs(pureCustomerFree.getEmail(), pureCustomerFree.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerFreeWithAdt.getId())
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
    //@RepeatedTest(10) //pass
    @Issue("CA-563")
    @TmsLink("CA-A-37")
    @DisplayName("Создание отзыва от пользователя 'Обменник' для 'Обычного пользователя'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewBranchToUserFree() {
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        UserProfile customerFreeWithAdt = new UserGenerator().createRandomCustomerFreeWithAdt();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), pureExchanger.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerFreeWithAdt.getId())
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
    //@RepeatedTest(10) // pass
    @Issue("CA-563")
    @TmsLink("CA-A-38")
    @DisplayName("Создание отзыва от пользователя 'Пользователя Pro' для 'Обычного пользователя'")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void createReviewUserProToUserFree() {
        UserProfile pureCustomerPro = new UserGenerator().createPureRandomCustomerPro();
        UserProfile customerFreeWithAdt = new UserGenerator().createRandomCustomerFreeWithAdt();
        whenCurrencyPO
                .openAs(pureCustomerPro.getEmail(), pureCustomerPro.getPassword())
                .selectNawBarAll()
                .clickLoadMoreButton()
                .selectCardById(customerFreeWithAdt.getId())
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
    //@RepeatedTest(10) //
    @Issue("CA-563")
    @TmsLink("CA-A-12")
    @DisplayName("Проверка на повторное добавление отзыва для того же обменника в течении 24ч")
    @Tag("UI")
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void secondCreateReview() {
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        UserProfile exchangerWithPaidSubscription = new UserGenerator().createRandomExchangerWithPaidSubscription();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), pureExchanger.getPassword())
                .selectNawBarAll()
                .selectCardById(exchangerWithPaidSubscription.getId())
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
    @Tag("CurrencyAuction")
    @Tag("Reviews")
    public void editReview() {
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
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
                .login(pureExchanger.getEmail(), "123qweQWE");
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
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
        UserProfile pureExchanger = new UserGenerator().createPureRandomExchanger();
        whenCurrencyPO
                .openAs(pureExchanger.getEmail(), "123qweQWE")
                .selectNawBarAll()
                .selectCardById("losa888-614d7870706bc707b6f2b4d8")
                .selectPositiveReviewsFilter();
        thenExchangeCardAssert.checkDisplayPositiveReviewFilter();

    }


}

