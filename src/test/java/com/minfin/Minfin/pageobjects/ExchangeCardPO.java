package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ExchangeCardPO {
    public SelenideElement reviewsButton = $("#reviewsNav button");
    public SelenideElement reviewsLike = $x("(//button[@class='styles__LikeButton-c3s3ls-1 gPXnsC'])[1]");

    public ExchangeCardPO clickReviewButton() {
        reviewsButton.click();
        return this;
    }
    public ExchangeCardPO scrollAndSelectToReviewsLike(){
        reviewsLike.scrollTo().click();
        return this;
    }
    public ExchangeCardPO clickReviewsLike(){
        reviewsLike.click();
        return this;
    }

}
