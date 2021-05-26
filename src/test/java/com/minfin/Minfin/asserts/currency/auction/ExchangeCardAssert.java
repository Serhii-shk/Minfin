package com.minfin.Minfin.asserts.currency.auction;

import com.codeborne.selenide.Condition;
import com.minfin.Minfin.pageobjects.currency.auction.ExchangeCardPO;

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
}
