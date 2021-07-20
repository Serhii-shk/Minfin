package com.minfin.Minfin.asserts.currency.auction;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.pageobjects.currency.auction.ReviewsPO;

import static com.codeborne.selenide.Condition.visible;

public class ReviewsAssert {
    ReviewsPO reviewsPO = new ReviewsPO();


    public ReviewsPO checkRequiredRatingStars(){
        reviewsPO.ratingErrorMessage.shouldBe(visible);
        return new ReviewsPO();
    }

    public ReviewsAssert checkUploadedImageItem(){
        reviewsPO.imageItem.shouldBe(visible);
        return this;
    }

    public ReviewsAssert checkDeletedImage(){
        reviewsPO.imageItem.shouldBe(Condition.not(Condition.cssClass("[class^='ImageItem']")));
        return this;
    }
}
