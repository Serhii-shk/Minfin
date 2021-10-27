package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ModalWindowsPO {
    public SelenideElement modalThanksForReview =$x("//div[contains(@class,'styles__ModalThanks-')]");

    //div[@class='styles__ModalThanks-sc-1phpxpj-44 gOsOeH']


    public SelenideElement modalNextReviewAfter24 = $x(" //span[contains(text(),'Новый отзыв для этого пользователя можно оставить через 24 часа')]");
    public SelenideElement closeModalWindow = $x("//button[@aria-label='close']");
    public SelenideElement modalCloseModalsThanksForReview =$x("//div[@type='button']/*");
    public SelenideElement modalEditReview = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement modalReviewRestored = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");



    public ModalWindowsPO checkModalThanksForAddReview() {
        step("when check modal thanks for add review ", ()->modalThanksForReview.shouldBe(visible));
        return this;
    }

    public ModalWindowsPO checkForAddReviewDuring24() {
        step("when check for add review during 24 ", ()->modalNextReviewAfter24.shouldBe(Condition.appear));
        return this;
    }

    public ExchangeCardPO clickOnCloseModal24(){
        step("when click on close modal 24 ", ()->closeModalWindow.click());
        return new ExchangeCardPO();
    }
    public ExchangeCardPO clickCloseModalsThanksForReview() {
        step("when click close modals thanks for review ", ()-> modalCloseModalsThanksForReview.click());
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkModalEditReview() {
        step("when check modal edit review ", ()->modalEditReview.shouldBe(Condition.appear));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkModalReviewRestored() {
        step("when check modal review restored ", ()->modalReviewRestored.shouldBe(Condition.appear));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickCloseModalReviewDeleted() {
        step("when click close modal review deleted ", ()->closeModalWindow.click());
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickCloseModalAnswerPosted() {
        step("when click close modal answer posted ", ()->closeModalWindow.click());
        return new ExchangeCardPO();
    }


}
