package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.enums.ExchangeCons;
import com.minfin.Minfin.pageobjects.BasePO;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ReviewsPO {

    public SelenideElement nextStep = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement ratingErrorMessage = $x("//div[@class='styles__ErrorMessage-sc-1phpxpj-27 gPeHPd']");
    public String ratingStar = "//*[@data-rating='%d']";
    public SelenideElement excellentService = $x("//button[@data-id='pos_no_errors']");
    public SelenideElement goodSafety = $x("//button[@data-id='pos_safe']");
    public SelenideElement reviewText = $x("//textarea[@name='text']");
    public SelenideElement uploadImage = $(".Section__Main.BranchPhotos input");
    public SelenideElement imageItem = $x("//img[@class='ImageItem__Img']");
    public SelenideElement publishReviewButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 gFxekH']");
    public SelenideElement availability5 = $x("//*[@data-type='availability' and @data-rating='5']");
    public SelenideElement availability4 = $x("//*[@data-type='availability' and @data-rating='4']");
    public SelenideElement currencyRate5 = $x("//*[@data-type='currency_rate' and @data-rating='5']");
    public SelenideElement currencyRate4 = $x("//*[@data-type='currency_rate' and @data-rating='4']");
    public SelenideElement quality3 = $x("//*[@data-type='quality' and @data-rating='3']");
    public SelenideElement quality4 = $x("//*[@data-type='quality' and @data-rating='4']");
    public SelenideElement safety5 = $x("//*[@data-type='safety' and @data-rating='5']");
    public SelenideElement safety4 = $x("//*[@data-type='safety' and @data-rating='4']");

    public ReviewsPO setRatingStar(int starNumber){
        $x(String.format(ratingStar, starNumber)).click();
        return this;
    }

    public ReviewsPO setCons(ExchangeCons cons){
        $(cons.getSelector()).click();
        return this;
    }

    public ReviewsPO setGoodSafety() {
        goodSafety.click();
        return this;
    }

    public ReviewsPO setReviewText(String text){
        reviewText.setValue(text);
        return this;
    }

    public ReviewsPO clearReviewText() {
        reviewText.clear();
        return this;
    }

    public ReviewsPO clickNextStep(){
        nextStep.click();
        return this;
    }

    public ReviewsPO uploadImage(String fileName){
        uploadImage.uploadFile(new BasePO().getFileFromResource(fileName));
        return this;
    }
    public ModalWindowsPO clickPublishReviewButton(){
        publishReviewButton.click();
        return new ModalWindowsPO();
    }

    public ReviewsPO setAvailability5Stars() {
        availability5.click();
        return this;
    }

    public ReviewsPO setAvailability4Stars() {
        availability4.click();
        return this;
    }

    public ReviewsPO setCurrencyRate5Stars() {
        currencyRate5.click();
        return this;
    }

    public ReviewsPO setCurrencyRate4Stars() {
        currencyRate4.click();
        return this;
    }

    public ReviewsPO setQuality3Stars() {
        quality3.click();
        return this;
    }

    public ReviewsPO setQuality4Stars() {
        quality4.click();
        return this;
    }

    public ReviewsPO setSafety5Stars() {
        safety5.click();
        return this;
    }

    public ReviewsPO setSafety4Stars() {
        safety4.click();
        return this;
    }

}
