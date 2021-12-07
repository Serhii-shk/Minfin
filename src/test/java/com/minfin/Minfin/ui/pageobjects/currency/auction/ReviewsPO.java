package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.enums.ExchangeProsAndCons;
import com.minfin.Minfin.ui.pageobjects.BasePO;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class ReviewsPO {

    public SelenideElement nextStep = $x("//button[@id='nextStepReview']");
    public SelenideElement ratingErrorMessage = $x("//div[@class='styles__ErrorMessage-sc-1phpxpj-27 gPeHPd']");
    public String ratingStar = "//*[@data-rating='%d']";
    public SelenideElement excellentService = $x("//button[@data-id='pos_no_errors']");
    public SelenideElement goodSafety = $x("//button[@data-id='pos_safe']");
    public SelenideElement reviewText = $x("//textarea[@name='text']");
    public SelenideElement uploadImage = $(".Section__Main.BranchPhotos input");
    public SelenideElement imageItem = $x("//img[@class='ImageItem__Img']");
    public SelenideElement publishReviewButton = $x("//button[@id='sendReview']");
    public SelenideElement availability5 = $x("//*[@data-type='availability' and @data-rating='5']");
    public SelenideElement availability4 = $x("//*[@data-type='availability' and @data-rating='4']");
    public SelenideElement currencyRate5 = $x("//*[@data-type='currency_rate' and @data-rating='5']");
    public SelenideElement currencyRate4 = $x("//*[@data-type='currency_rate' and @data-rating='4']");
    public SelenideElement quality3 = $x("//*[@data-type='quality' and @data-rating='3']");
    public SelenideElement quality4 = $x("//*[@data-type='quality' and @data-rating='4']");
    public SelenideElement safety5 = $x("//*[@data-type='safety' and @data-rating='5']");
    public SelenideElement safety4 = $x("//*[@data-type='safety' and @data-rating='4']");
    public SelenideElement removeImageButton = $x("//button[@class='Button ImageItem__RemoveButton outlined icon']");


    public ReviewsPO setRatingStar(int starNumber){
        step("When set rating star " + starNumber, ()->$x(String.format(ratingStar, starNumber)).click());
        return this;
    }

    public ReviewsPO setCons(ExchangeProsAndCons cons){
        step("When set cons " + cons, ()->$(cons.getSelector()).click());
        return this;
    }

    public ReviewsPO setGoodSafety() {
        step("When set good safety ", ()->goodSafety.click());
        return this;
    }

    public ReviewsPO setReviewText(String text){
        step("When set review text " + text, ()->reviewText.setValue(text));
        return this;
    }

    public ReviewsPO clearReviewText() {
        step("When clear review text ", ()->reviewText.clear());
        return this;
    }

    public ReviewsPO clickNextStep(){
        step("When click next step ", ()->nextStep.click());
        return this;
    }

    public ReviewsPO uploadImage(String fileName){
        step("When upload image " +fileName, ()->uploadImage.uploadFile(new BasePO().getFileFromResource(fileName)));
        return this;
    }

    public ModalWindowsPO clickPublishReviewButton(){
        step("When click publish review button ", ()->publishReviewButton.click());
        return new ModalWindowsPO();
    }

    public ReviewsPO setAvailability5Stars() {
        step("When set availability 5 stars ", ()->availability5.click());
        return this;
    }

    public ReviewsPO setAvailability4Stars() {
        step("When set availability 4 stars ", ()->availability4.click());
        return this;
    }

    public ReviewsPO setCurrencyRate5Stars() {
        step("When set currency rate 5 stars ", ()->currencyRate5.click());
        return this;
    }

    public ReviewsPO setCurrencyRate4Stars() {
        step("When set currency rate 4 stars ", ()->currencyRate4.click());
        return this;
    }

    public ReviewsPO setQuality3Stars() {
        step("When set qvality 3 stars ", ()->quality3.click());
        return this;
    }

    public ReviewsPO setQuality4Stars() {
        step("When set quality 4 stars ", ()->quality4.click());
        return this;
    }

    public ReviewsPO setSafety5Stars() {
        step("When set safety 5 stars ", ()->safety5.click());
        return this;
    }

    public ReviewsPO setSafety4Stars() {
        step("When set safety 4 stars ", ()->safety4.click());
        return this;
    }

    public ReviewsPO clickRemoveImageButton() {
        step("When click remove image button ",()->removeImageButton.click());
        return this;
    }

}
