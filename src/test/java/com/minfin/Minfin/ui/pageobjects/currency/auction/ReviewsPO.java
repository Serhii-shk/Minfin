package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.enums.ExchangeProsAndCons;
import com.minfin.Minfin.ui.pageobjects.BasePO;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ReviewsPO {

    private static final SelenideElement NEXT_STEP = $x("//button[@id='nextStepReview']");

    public static SelenideElement getRatingErrorMessage() {
        return RATING_ERROR_MESSAGE;
    }
    private static final SelenideElement RATING_ERROR_MESSAGE = $x("//div[@class='styles__ErrorMessage-sc-1phpxpj-27 gPeHPd']");

    public String ratingStar = "//*[@data-rating='%d']";

    private static final SelenideElement EXCELLENT_SERVICE = $x("//button[@data-id='pos_no_errors']");
    private static final SelenideElement GOOD_SAFETY = $x("//button[@data-id='pos_safe']");
    private static final SelenideElement REVIEW_TEXT = $x("//textarea[@name='text']");
    private static final SelenideElement UPLOAD_IMAGE = $(".Section__Main.BranchPhotos input");

    public static SelenideElement getImageItem() {
        return IMAGE_ITEM;
    }
    private static final SelenideElement IMAGE_ITEM = $x("//img[@class='ImageItem__Img']");

    private static final SelenideElement PUBLISH_REVIEW_BUTTON = $x("//button[@id='sendReview']");
    private static final SelenideElement AVAILABILITY_5 = $x("//*[@data-type='availability' and @data-rating='5']");
    private static final SelenideElement AVAILABILITY_4 = $x("//*[@data-type='availability' and @data-rating='4']");
    private static final SelenideElement CURRENCY_RATE_5 = $x("//*[@data-type='currency_rate' and @data-rating='5']");
    private static final SelenideElement CURRENCY_RATE_4 = $x("//*[@data-type='currency_rate' and @data-rating='4']");
    private static final SelenideElement QUALITY_3 = $x("//*[@data-type='quality' and @data-rating='3']");
    private static final SelenideElement QUALITY_4 = $x("//*[@data-type='quality' and @data-rating='4']");
    private static final SelenideElement SAFETY_5 = $x("//*[@data-type='safety' and @data-rating='5']");
    private static final SelenideElement SAFETY_4 = $x("//*[@data-type='safety' and @data-rating='4']");
    private static final SelenideElement REMOVE_IMAGE_BUTTON = $x("//button[@class='Button ImageItem__RemoveButton outlined icon']");


    public ReviewsPO setRatingStar(int starNumber){
        step("When set rating star " + starNumber, ()->$x(String.format(ratingStar, starNumber)).click());
        return this;
    }

    public ReviewsPO setCons(ExchangeProsAndCons cons){
        step("When set cons " + cons, ()->$(cons.getSelector()).click());
        return this;
    }

    public ReviewsPO setGoodSafety() {
        step("When set good safety ", ()-> GOOD_SAFETY.click());
        return this;
    }

    public ReviewsPO setReviewText(String text){
        step("When set review text " + text, ()-> REVIEW_TEXT.setValue(text));
        return this;
    }

    public ReviewsPO clearReviewText() {
        step("When clear review text ", ()-> REVIEW_TEXT.clear());
        return this;
    }

    public ReviewsPO clickNextStep(){
        step("When click next step ", ()-> NEXT_STEP.click());
        return this;
    }

    public ReviewsPO uploadImage(String fileName){
        step("When upload image " +fileName, ()-> UPLOAD_IMAGE.uploadFile(new BasePO().getFileFromResource(fileName)));
        return this;
    }

    public ModalWindowsPO clickPublishReviewButton(){
        step("When click publish review button ", ()-> PUBLISH_REVIEW_BUTTON.click());
        return new ModalWindowsPO();
    }

    public ReviewsPO setAvailability5Stars() {
        step("When set availability 5 stars ", ()-> AVAILABILITY_5.click());
        return this;
    }

    public ReviewsPO setAvailability4Stars() {
        step("When set availability 4 stars ", ()-> AVAILABILITY_4.click());
        return this;
    }

    public ReviewsPO setCurrencyRate5Stars() {
        step("When set currency rate 5 stars ", ()-> CURRENCY_RATE_5.click());
        return this;
    }

    public ReviewsPO setCurrencyRate4Stars() {
        step("When set currency rate 4 stars ", ()-> CURRENCY_RATE_4.click());
        return this;
    }

    public ReviewsPO setQuality3Stars() {
        step("When set qvality 3 stars ", ()-> QUALITY_3.click());
        return this;
    }

    public ReviewsPO setQuality4Stars() {
        step("When set quality 4 stars ", ()-> QUALITY_4.click());
        return this;
    }

    public ReviewsPO setSafety5Stars() {
        step("When set safety 5 stars ", ()-> SAFETY_5.click());
        return this;
    }

    public ReviewsPO setSafety4Stars() {
        step("When set safety 4 stars ", ()-> SAFETY_4.click());
        return this;
    }

    public ReviewsPO clickRemoveImageButton() {
        step("When click remove image button ",()-> REMOVE_IMAGE_BUTTON.click());
        return this;
    }

}
