package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ModalWindows {
    public SelenideElement thanksForReview =$x("//div[@class='styles__ModalThanks-sc-1phpxpj-43 kRKYo']");
    public SelenideElement nextReviewAfter24 = $x(" //span[contains(text(),'Новый отзыв для этого пользователя можно оставить через 24 часа')]");
    public SelenideElement closeModalWindow = $x("//button[@aria-label='close']");
}
