package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.enums.UrlsForSortingTests;
import com.minfin.Minfin.ui.TestBase;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;


public class DebitCardsPO {

    private static String baseUrl;
    private final SelenideElement MORE_CARDS_BUTTON = $x("(//*[@data-elementid='show-more-cards'])[1]");
    private final SelenideElement SORTED_BUTTON = $x("//*[@data-elementid='selected-sorting']");
    private final SelenideElement PERCENT_ON_BALANCE_AMOUNT = $x("//*[@data-elementid='sort-by-percent-on-balance-amount']");
    public SelenideElement CARDS_COUNT_AFTER_APPLYING_FILTER = $x("//*[@id='mc-products-list']/div[1]/div[1]/p");
    public List<SelenideElement> MAINTENANCE_FIRST_YEAR_PRICE_LIST = $$x("//*[@data-elementid='maintenance-first-year-price']");
    public List<SelenideElement> VENDOR_CARDS_COUNT_LIST = $$x("//*[@id='mc-products-list']/div[@data-elementid='vendorid-1']/div");
    public List<SelenideElement> PERCENT_ON_BALANCE_LIST = $$x("//*[@data-elementid='percent-on-balance']");


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
            default:
                baseUrl = "https://minfin-cards.stage.treeumapp.net/";
        }
    }

    public DebitCardsPO openDebitCards() {
        getBaseUrl();
        step("When open cards/debit/ url", () ->
                Selenide.open(baseUrl + "cards/debit/"));
        return this;
    }

    public DebitCardsPO openDebitCardsByUrl(UrlsForSortingTests url) {
        getBaseUrl();
        step("When open debit cards by " + url, () ->
                Selenide.open(baseUrl + "cards/debit/" + url.getLinkForSortingType()));
        return this;
    }

    public DebitCardsPO clickToMoreButton() {
        step("click to more button ", () -> MORE_CARDS_BUTTON.shouldBe(Condition.visible, Duration.ofSeconds(20)).click());
        return this;
    }

    public int getCountDebitCardsWithFastFilter() {
        return Integer.parseInt(CARDS_COUNT_AFTER_APPLYING_FILTER.text().replaceAll("[^0-9]", ""));
    }

    public DebitCardsPO clickToSortByButton() {
        step("click to sorted button ", () ->
                SORTED_BUTTON.shouldBe(Condition.visible).click());
        return this;
    }

    public DebitCardsPO selectSortByPercentOnBalanceAmount() {
        step("select sort by grace period days ", () ->
                PERCENT_ON_BALANCE_AMOUNT.shouldBe(Condition.visible).click());
        return this;
    }

    public int getVendorCardsCount() {
        return VENDOR_CARDS_COUNT_LIST.size();
    }

    public List<SelenideElement> getListCardByMaintenanceFirstYearPrice() {
        return MAINTENANCE_FIRST_YEAR_PRICE_LIST;
    }

    public List<SelenideElement> getListCardByPercentOnBalance() {
        return PERCENT_ON_BALANCE_LIST;
    }
}
