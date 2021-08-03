package com.minfin.Minfin.ui.asserts;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.ui.pageobjects.currency.auction.ExchangeCardPO;

import static com.codeborne.selenide.Condition.visible;

public class ExchangeCardAssert {
    ExchangeCardPO exchangeCardPO = new ExchangeCardPO();

    public ExchangeCardAssert checkReviewOnModeration() {
        exchangeCardPO.reviewOnModeration.shouldBe(visible);
        return this;
    }

    public ExchangeCardAssert checkReviewDeleted() {
        exchangeCardPO.reviewDeleted.shouldBe(visible);
        return this;
    }

    public ExchangeCardAssert checkModalReviewDeleted() {
        exchangeCardPO.modalReviewDeleted.shouldBe(Condition.appear);
        return this;
    }

    public ExchangeCardAssert checkModalAuthOrRegistration() {
        exchangeCardPO.modalAuthOrRegistration.shouldBe(visible);
        return this;
    }

    public ExchangeCardAssert checkErrorMassageAnswer() {
        exchangeCardPO.errorMassageAnswer.shouldBe(visible);
        return this;
    }

    public ExchangeCardAssert checkDisplayUnansweredReviewFilter() {
        exchangeCardPO.allCreatedReviews.forEach(e->e.shouldBe(Condition.not(Condition.cssClass("[class^='styles__ResponseWrapper-']"))));
        return this;
    }

    public ExchangeCardAssert checkDisplayNegativeReviewFilter() {
        exchangeCardPO.allCreatedReviews.forEach(e->e.shouldBe(Condition.not(Condition.cssClass("#reviewsNav [class^='styles__Stars-sc-117h6dj-0 iuIZwA'], [class^='styles__Stars-sc-117h6dj-0 IVlOs']"))));
        return this;
    }

    public ExchangeCardAssert checkDisplayPositiveReviewFilter() {
        exchangeCardPO.allCreatedReviews.forEach(e->e.shouldBe(Condition.cssClass("#reviewsNav [class^='styles__Stars-sc-117h6dj-0 iuIZwA'], [class^='styles__Stars-sc-117h6dj-0 IVlOs']")));
        return this;
    }

}
