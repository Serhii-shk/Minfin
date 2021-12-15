package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ModalWindowsPO {

    private static final SelenideElement MODAL_THANKS_FOR_REVIEW =$x("//div[contains(@class,'styles__ModalThanks-')]");
    private static final SelenideElement MODAL_NEXT_REVIEW_AFTER_24 = $x(" //span[contains(text(),'Новый отзыв для этого пользователя можно оставить через 24 часа')]");
    private static final SelenideElement CLOSE_MODAL_WINDOW = $x("//button[@aria-label='close']");
    private static final SelenideElement MODAL_CLOSE_MODALS_THANKS_FOR_REVIEW =$x("//div[@type='button']/*");
    private static final SelenideElement MODAL_EDIT_REVIEW = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    private static final SelenideElement MODAL_REVIEW_RESTORED = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");



    public ModalWindowsPO checkModalThanksForAddReview() {
        step("when check modal thanks for add review ", ()-> MODAL_THANKS_FOR_REVIEW.shouldBe(visible));
        return this;
    }

    public ModalWindowsPO checkForAddReviewDuring24() {
        step("when check for add review during 24 ", ()-> MODAL_NEXT_REVIEW_AFTER_24.shouldBe(Condition.appear));
        return this;
    }

    public ExchangeCardPO clickOnCloseModal24(){
        step("when click on close modal 24 ", ()-> CLOSE_MODAL_WINDOW.click());
        return new ExchangeCardPO();
    }
    public ExchangeCardPO clickCloseModalsThanksForReview() {
        step("when click close modals thanks for review ", ()-> MODAL_CLOSE_MODALS_THANKS_FOR_REVIEW.click());
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkModalEditReview() {
        step("when check modal edit review ", ()-> MODAL_EDIT_REVIEW.shouldBe(Condition.appear));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkModalReviewRestored() {
        step("when check modal review restored ", ()-> MODAL_REVIEW_RESTORED.shouldBe(Condition.appear));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickCloseModalReviewDeleted() {
        step("when click close modal review deleted ", ()-> CLOSE_MODAL_WINDOW.click());
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickCloseModalAnswerPosted() {
        step("when click close modal answer posted ", ()-> CLOSE_MODAL_WINDOW.click());
        return new ExchangeCardPO();
    }


}
