package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ReviewsPO {

    public SelenideElement nextStep = $x("//button[@class='styles__Button-sc-1phpxpj-33 efUZin']");
    public SelenideElement ratingErrorMassage = $x("//div[@class='styles__ErrorMessage-sc-1phpxpj-28 jbYlYW']");
    public String ratingStar = "//*[@data-rating='%d']";
    public SelenideElement excellentService = $x("//button[@data-id='pos_no_errors']");
public         SelenideElement reviewText = $x("//textarea[@name='text']");
public         SelenideElement uploadImage = $(".Section__Main.BranchPhotos input");


    public ReviewsPO setRatingStar(int starNumber){
        $x(String.format(ratingStar, starNumber)).click();
        return this;
    }

    public ReviewsPO setExcellentService(){
        excellentService.click();
        return this;
    }

    public ReviewsPO setReviewText(String text){
        reviewText.setValue(text);
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


}
