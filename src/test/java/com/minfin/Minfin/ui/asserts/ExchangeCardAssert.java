package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ExchangeCardPO;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class ExchangeCardAssert {

    public ExchangeCardAssert checkReviewOnModeration() {
        step("When check review on moderation", () -> ExchangeCardPO.getReviewOnModeration().shouldBe(visible));
        return this;
    }

    public ExchangeCardAssert checkReviewDeleted() {
        step("When check review deleted", () -> ExchangeCardPO.getReviewDeleted().shouldBe(visible));
        return this;
    }

    public ExchangeCardAssert checkModalReviewDeleted() {
        step("When check modal review deleted", () -> ExchangeCardPO.getModalReviewDeleted().shouldBe(Condition.appear));
        return this;
    }

    public ExchangeCardAssert checkModalAuthOrRegistration() {
        step("When check modal auth or registration", () -> ExchangeCardPO.getModalAuthOrRegistration().shouldBe(visible));
        return this;
    }

    public ExchangeCardAssert checkErrorMassageAnswer() {
        step("When check error massage answer", () -> ExchangeCardPO.getErrorMassageAnswer().shouldBe(visible));
        return this;
    }

    public ExchangeCardAssert checkDisplayUnansweredReviewFilter() {
        step("When check display unanswered review filter", () -> ExchangeCardPO.getAllCreatedReviews()
                .forEach(e->e.shouldBe(Condition.not(Condition.cssClass("[class^='styles__ResponseWrapper-']")))));
        return this;
    }

    public ExchangeCardAssert checkDisplayNegativeReviewFilter() {
        step("When check display negative review filter", () -> ExchangeCardPO.getAllCreatedReviews()
                .forEach(e->e.shouldBe(Condition.not(Condition.cssClass("#reviewsNav [class^='styles__Stars-sc-117h6dj-0 iuIZwA'], [class^='styles__Stars-sc-117h6dj-0 IVlOs']")))));

        return this;
    }

    public ExchangeCardAssert checkDisplayPositiveReviewFilter() {
        step("When check display positive review filter", () -> ExchangeCardPO.getAllCreatedReviews()
                .forEach(e->e.shouldBe(Condition.cssClass("#reviewsNav [class^='styles__Stars-sc-117h6dj-0 iuIZwA'], [class^='styles__Stars-sc-117h6dj-0 IVlOs']"))));
        return this;
    }

}
