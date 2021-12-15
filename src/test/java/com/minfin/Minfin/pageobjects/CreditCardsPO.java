package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.enums.UrlsForSortingTests;
import com.minfin.Minfin.ui.TestBase;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CreditCardsPO {

    private static String baseUrl;

    private final SelenideElement MORE_CARDS_BUTTON = $x("(//*[@data-elementid='show-more-cards'])[1]");
    public List<SelenideElement> VENDOR_CARDS_COUNT_LIST = $$x("//*[@id='mc-products-list']/div[@data-elementid='vendorid-1']/div");
    public List<SelenideElement> LOAN_LIMIT_LIST = $$x("//*[@data-elementid='loan-limit']");
    private final SelenideElement SORTED_BUTTON = $x("//*[@data-elementid='selected-sorting']");
    private final SelenideElement GRACE_PERIOD_DAYS_LIMIT = $x("//*[@data-elementid='sort-by-grace-period']");
    public List<SelenideElement> GRACE_PERIOD_LIST = $$x("//*[@data-elementid='grace-period']");
    public SelenideElement CARDS_COUNT_AFTER_APPLYING_FILTER = $x("//*[@id='mc-products-list']/div[1]/div[1]/p");
    private final SelenideElement NOTHING_FOUND_TITLE = $x("//*[starts-with(@class, 'styles__Description-sc-')]");

    private static void getBaseUrl() {
        String env = "" + TestBase.environment;
        switch (env) {
            case "review1":
                baseUrl = "https://minfin-cards.review1.treeumapp.net/";
                break;
            case "review2":
                baseUrl = "https://minfin-cards.review2.treeumapp.net/";
                break;
            case "stage1":
            case "prod":
                baseUrl = "https://minfin.com.ua/";
                break;
            default:
                baseUrl = "https://minfin-cards.stage.treeumapp.net/";
        }
    }

    public CreditCardsPO openCreditCards() {
        getBaseUrl();
        step("When open cards/credit/ url", ()->
                Selenide.open( baseUrl + "cards/credit/"));
        return this;
    }

    public CreditCardsPO openCreditCardsByUrl(UrlsForSortingTests url) {
        getBaseUrl();
        step("When open cards by " + url, ()->
                Selenide.open( baseUrl + "cards/credit/" + url.getLinkForSortingType()));
        return this;
    }

    public CreditCardsPO clickToMoreButton() {
        step("click to more button ", ()->
                MORE_CARDS_BUTTON.shouldBe(Condition.visible).click());
        return this;
    }

    public CreditCardsPO clickToSortByButton() {
        step("click to sorted button ", ()->
                SORTED_BUTTON.shouldBe(Condition.visible).click());
        return this;
    }

    public CreditCardsPO selectSortByGracePeriodDays() {
        step("select sort by grace period days ", ()->
                GRACE_PERIOD_DAYS_LIMIT.shouldBe(Condition.visible).click());
        return this;
    }

    public int getCountCreditCardsWithFastFilter() {
        return Integer.parseInt(CARDS_COUNT_AFTER_APPLYING_FILTER.text().replaceAll("[^0-9]", ""));
    }

    public CreditCardsPO nothingFoundTitle() {
        step("check when nothing found title is visible ", ()->
                NOTHING_FOUND_TITLE.shouldBe(Condition.visible));
        return this;
    }

    public int getVendorCardsCount() {
        return VENDOR_CARDS_COUNT_LIST.size();
    }

    public List<SelenideElement> getListCardByLoanLimit() {
        return LOAN_LIMIT_LIST;
    }

    public List<SelenideElement> getListCardByGracePeriod() {
        return GRACE_PERIOD_LIST;
    }
}
