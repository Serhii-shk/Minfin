package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ModalWindowsPO {
    public SelenideElement modalThanksForReview =$x("//div[@class='styles__ModalThanks-sc-1phpxpj-44 gOsOeH']");
    public SelenideElement modalNextReviewAfter24 = $x(" //span[contains(text(),'Новый отзыв для этого пользователя можно оставить через 24 часа')]");
    public SelenideElement closeModalWindow24 = $x("//button[@aria-label='close']");
    public SelenideElement modalCloseModalsThanksForReview =$x("//div[@type='button']/*");
    public SelenideElement modalEditReview = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement modalReviewRestored = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement closeModalReviewDeleted = $x("//button[@aria-label='close']");


    public ModalWindowsPO checkModalThanksForAddReview() {
        modalThanksForReview.shouldBe(visible);
        return this;
    }

    public ModalWindowsPO checkForAddReviewDuring24() {
        modalNextReviewAfter24.shouldBe(Condition.appear);
        return this;
    }

    public ExchangeCardPO clickOnCloseModal24(){
        closeModalWindow24.click();
        return new ExchangeCardPO();
    }
    public ExchangeCardPO clickCloseModalsThanksForReview() {
        modalCloseModalsThanksForReview.click();
        return new ExchangeCardPO();
    }



    public ExchangeCardPO checkModalEditReview() {
        modalEditReview.shouldBe(Condition.appear);
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkModalReviewRestored() {
        modalReviewRestored.shouldBe(Condition.appear);
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickCloseModalReviewDeleted() {
        closeModalReviewDeleted.click();
        return new ExchangeCardPO();
    }

}
