package com.minfin.Minfin.pageobjects.currency.auction;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ExchangeCardPO {
    public SelenideElement reviewsButton = $("#reviewsNav button");
    public SelenideElement reviewsLike = $x("(//button[@class='styles__LikeButton-c3s3ls-1 crkBdi'])[1]");
    public SelenideElement likeEnabledForFirstReview = $x("(//*[@d='M23 9a2 2 0 00-2-2h-6.32l.96-4.57c.02-.1.03-.21.03-.32 0-.41-.17-.79-.44-1.06L14.17 0 7.59 6.58C7.22 6.95 7 7.45 7 8v10a2 2 0 002 2h9c.83 0 1.54-.5 1.84-1.22l3.02-7.05c.09-.23.14-.47.14-.73V9zM1 20h4V8H1v12z'])[1]");
    public SelenideElement likeDisabledForFirstReview = $x("(//*[@d='M5 9v12H1V9h4zm4 12a2 2 0 01-2-2V9c0-.55.22-1.05.59-1.41L14.17 1l1.06 1.06c.27.27.44.64.44 1.05l-.03.32L14.69 8H21a2 2 0 012 2v2c0 .26-.05.5-.14.73l-3.02 7.05C19.54 20.5 18.83 21 18 21H9zm0-2h9.03L21 12v-2h-8.79l1.13-5.32L9 9.03V19z'])[1]");
    public SelenideElement userContextMenu = $x("(//div[@class='UserContextMenu'])[1]");
    public SelenideElement contextMenuComplaintButton = $x("//button[@class='styles__ContextMenuButton-fbasab-0 hluVje']");
    public SelenideElement cancelComplaintButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ']");
    public SelenideElement complaintText = $x("//textarea[@name='answer']");
    public SelenideElement postComplaintButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement reviewOnModeration = $x("//div[@type='moderation']");
    public SelenideElement editReviewButton = $x("(//button[@class='styles__ContextMenuButton-fbasab-0 hluVje'])[2]");
    public SelenideElement deleteReviewButton = $x("//span[@class='UserContextMenu__Wrapper']/button[1]");
    public SelenideElement restoreReview = $x("//button[@class='styles__ActivateButton-sc-1phpxpj-50 cuthLN']");
    public SelenideElement reviewDeleted = $x("(//div[@type='deleted'])[1]");
    public SelenideElement modalReviewDeleted = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");



    public ReviewsPO clickReviewButton() {
        reviewsButton.click();
        return new ReviewsPO();
    }

    public ModalWindowsPO secondClickReviewButton() {
        reviewsButton.click();
        return new ModalWindowsPO();
    }

    public ExchangeCardPO scrollAndSelectToReviewsLike() {
        reviewsLike.scrollTo().click();
        return this;
    }

    public ExchangeCardPO clickReviewsLike() {
        reviewsLike.click();
        return this;
    }

    public ExchangeCardPO scrollAfterCreatedReviews() {
        reviewsButton.scrollIntoView(false);
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkLikeEnabledForFirstReview() {
        likeEnabledForFirstReview.shouldBe(visible);
        return this;
    }

    public ExchangeCardPO checkLikeDisabledForFirstReview() {
        likeDisabledForFirstReview.shouldBe(visible);
        return this;
    }

    public ExchangeCardPO clickUserContextMenu() {
        userContextMenu.shouldBe(visible, Duration.ofSeconds(10)).scrollTo().click();
        return this;
    }

    public ExchangeCardPO clickContextMenuComplaintButton() {
        contextMenuComplaintButton.click();
        return this;
    }

    public ExchangeCardPO clickCancelComplaintButton() {
        cancelComplaintButton.click();
        return this;
    }

    public ExchangeCardPO setComplaintText() {
        complaintText.setValue("Test complaint for review");
        return this;
    }

    public ExchangeCardPO clickPostComplaintButton() {
        postComplaintButton.click();
        return this;
    }

    public ReviewsPO clickEditReviewButton() {
        editReviewButton.click();
        return new ReviewsPO();
    }

    public ExchangeCardPO clickDeleteReviewButton() {
        deleteReviewButton.click();
        return this;
    }

    public ExchangeCardPO clickRestoreReview() {
        restoreReview.click();
        return this;
    }



}
