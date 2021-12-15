package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ReviewsPO;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class ReviewsAssert {

    public ReviewsPO checkRequiredRatingStars(){
        step("When check required rating stars", () -> ReviewsPO.getRatingErrorMessage().shouldBe(visible));
        return new ReviewsPO();
    }

    public ReviewsAssert checkUploadedImageItem(){
        step("When check uploaded image item", () -> ReviewsPO.getImageItem().shouldBe(visible));
        return this;
    }

    public ReviewsAssert checkDeletedImage(){
        step("When check deleted image", () -> ReviewsPO.getImageItem().shouldBe(Condition.not(Condition.cssClass("[class^='ImageItem']"))));
        return this;
    }
}
