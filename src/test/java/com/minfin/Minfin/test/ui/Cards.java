package com.minfin.Minfin.test.ui;

import com.minfin.Minfin.asserts.CardsAssert;
import com.minfin.Minfin.asserts.CreditCardsAssert;
import com.minfin.Minfin.asserts.DebitCardsAssert;
import com.minfin.Minfin.enums.UrlsForSortingTests;
import com.minfin.Minfin.pageobjects.CardsPO;
import com.minfin.Minfin.pageobjects.CreditCardsPO;
import com.minfin.Minfin.pageobjects.DebitCardsPO;
import com.minfin.Minfin.service.api.products.v1.list.CardsDataPathParameters;
import com.minfin.Minfin.service.api.products.v1.list.CreditCardsDataService;
import com.minfin.Minfin.service.api.products.v1.list.ProductsDataPathParameters;
import com.minfin.Minfin.service.api.products.v1.list.ProductsDataService;
import com.minfin.Minfin.ui.TestBase;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cards extends TestBase {
    CreditCardsPO creditCardsPO = new CreditCardsPO();
    DebitCardsPO debitCardsPO = new DebitCardsPO();
    CardsPO cardsPO = new CardsPO();
    CardsAssert cardsAssert = new CardsAssert();
    ProductsDataService productsDataService = new ProductsDataService();
    CreditCardsDataService creditCardsDataService = new CreditCardsDataService();
    CreditCardsAssert creditCardsAssert = new CreditCardsAssert();
    DebitCardsAssert debitCardsAssert = new DebitCardsAssert();

    @TmsLink("MCS-A-14")
    @Test
    public void checkSortedCreditCardsByCreditLimits() {
        creditCardsPO.openCreditCards()
                .clickToMoreButton();

        creditCardsAssert.checkIfListIsSortedByLoanLimit();
    }

    @TmsLink("MCS-A-15")
    @Test
    public void checkSortedCreditCardsByGracePeriodDaysLimit() {
        creditCardsPO.openCreditCards()
                .clickToSortByButton()
                .selectSortByGracePeriodDays()
                .clickToMoreButton();

        creditCardsAssert.checkIfListIsSortedByGracePeriod();
    }

    @TmsLink("MCS-A-16")
    @Test
    public void checkSortedDebitCardsByMaintenanceFirstYearPrice() {
        debitCardsPO.openDebitCards()
                .clickToMoreButton();

        debitCardsAssert.checkIfListIsSortedByMaintenanceFirstYearPrice();
    }

    @TmsLink("MCS-A-17")
    @Test
    public void checkSortedDebitCardsByPercentOnBalanceAmount() {
        debitCardsPO.openDebitCards()
                .clickToSortByButton()
                .selectSortByPercentOnBalanceAmount()
                .clickToMoreButton();

        debitCardsAssert.checkIfListIsSortedByPercentOnBalance();
    }

    @TmsLink("MCS-A-29")
    @Test
    public void checkCreditCardsListWithFastFilterByNoWithdrawalFee() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .ownFundsOwnAtmCommissionPercent("0")
                                .ownAtmCommissionPercent("0")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.NO_WITHDRAWAL_FEE);

        cardsAssert.checkCountCardsWithFastFilter(creditCardsPO.getCountCreditCardsWithFastFilter(), apiCardCount);

    }

    @TmsLink("MCS-A-28")
    @Test
    public void checkCreditCardsListWithFastFilterByNoInquiries() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .employmentType("none,not_official")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.NO_INQUIRIES)
                .nothingFoundTitle();

        cardsAssert.checkCountCardsWithFastFilter(0, apiCardCount);
    }

    @TmsLink("MCS-A-30")
    @Test
    public void checkCreditCardsListWithFastFilterByBadCreditHistory() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .employmentType("none,not_official")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.BAD_CREDIT_HISTORY)
                .nothingFoundTitle();

        cardsAssert.checkCountCardsWithFastFilter(0, apiCardCount);
    }

    @Disabled("MCS-112")
    @Issue("MCS-112")
    @TmsLink("MCS-A-31")
    @Test
    public void checkCreditCardsListWithFastFilterByGracePeriod() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .gracePeriodDaysLimit("0")
                                .active(1)
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.GRACE_PERIOD);

        cardsAssert.checkCountCardsWithFastFilter(creditCardsPO.getCountCreditCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-32")
    @Test
    public void checkCreditCardsListWithFastFilterByDelivery() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .delivery("true")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.DELIVERY)
                .nothingFoundTitle();

        cardsAssert.checkCountCardsWithFastFilter(0, apiCardCount);

    }

    @TmsLink("MCS-A-33")
    @Test
    public void checkCreditCardsListWithFastFilterBy18Years() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .ageRange("18")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.EIGHTEEN_YEARS);

        cardsAssert.checkCountCardsWithFastFilter(creditCardsPO.getCountCreditCardsWithFastFilter(), apiCardCount);
    }

    @Disabled("MCS-112")
    @Issue("MCS-112")
    @TmsLink("MCS-A-34")
    @Test
    public void checkCreditCardsListWithFastFilterByMomentary() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .preparationTime("0")
                                .build())
                        .body())
                .getData()
                .size();
        creditCardsPO.openCreditCardsByUrl(UrlsForSortingTests.MOMENTARY);

        cardsAssert.checkCountCardsWithFastFilter(creditCardsPO.getCountCreditCardsWithFastFilter(), apiCardCount);

    }

    @TmsLink("MCS-A-35")
    @Test
    public void checkDebitCardsListWithFastFilterForChildren() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .obtainConditionsType("children")
                                .build())
                        .body())
                .getData()
                .size();
        debitCardsPO.openDebitCardsByUrl(UrlsForSortingTests.CHILDREN_DEBIT);

        cardsAssert.checkCountCardsWithFastFilter(debitCardsPO.getCountDebitCardsWithFastFilter(), apiCardCount);

    }

    @TmsLink("MCS-A-42")
    @Test
    public void checkDebitCardsListWithFastFilterWithCashback() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .cashback("true")
                                .build())
                        .body())
                .getData()
                .size();
        debitCardsPO.openDebitCardsByUrl(UrlsForSortingTests.CASHBACK_DEBIT);

        cardsAssert.checkCountCardsWithFastFilter(debitCardsPO.getCountDebitCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-37")
    @Test
    public void checkDebitCardsListWithFastFilterByVirtual() {
        int apiCardCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .cardType("virtual")
                                .build())
                        .body())
                .getData()
                .size();
        debitCardsPO.openDebitCardsByUrl(UrlsForSortingTests.VIRTUAL_DEBIT);

        cardsAssert.checkCountCardsWithFastFilter(debitCardsPO.getCountDebitCardsWithFastFilter(), apiCardCount);

    }

    @Disabled("MCS-112")
    @Issue("MCS-112")
    @TmsLink("MCS-A-25")
    @Test
    public void checkCardsListCountWithFastFilterByCurrencyCard() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .currencyList("USD,EUR,PLN,GBP")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .currencyList("USD,EUR,PLN,GBP")
                                .build())
                        .body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.CURRENCY_CARD);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-22")
    @Test
    public void checkCardsListCountWithFastFilterByVirtualCard() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .cardType("virtual")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .cardType("virtual")
                                .build())
                        .body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.VIRTUAL);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @Disabled("MCS-112")
    @Issue("MCS-112")
    @TmsLink("MCS-A-27")
    @Test
    public void checkCardsListCountWithFastFilterByPreparationTime() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .preparationTime("0")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .preparationTime("0")
                                .build())
                        .body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.MOMENTARY);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @Disabled("MCS-112")
    @Issue("MCS-112")
    @TmsLink("MCS-A-26")
    @Test
    public void checkCardsListCountWithFastFilterByPayWire() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .technology("pay_wire")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .technology("pay_wire")
                                .build())
                        .body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.PAY_WIRE);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-23")
    @Test
    public void checkCardsListCountWithFastFilterByChildren() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .obtainConditionsType("children")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .obtainConditionsType("children")
                                .build())
                        .body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.CHILDREN);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-24")
    @Test
    public void checkCardsListCountWithFastFilterByCashback() {
        int apiGetDebitCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(5)
                                .active(1)
                                .cashback("true")
                                .build())
                        .body())
                .getData()
                .size();
        int apiGetCreditCount = Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                        .productType(0)
                        .active(1)
                        .cashback("true")
                        .build()).body())
                .getData()
                .size();
        int apiCardCount = apiGetDebitCount + apiGetCreditCount;
        cardsPO.openCardsByUrl(UrlsForSortingTests.CASHBACK);

        cardsAssert.checkCountCardsWithFastFilter(cardsPO.getCountCardsWithFastFilter(), apiCardCount);
    }

    @TmsLink("MCS-A-21")
    @Test
    public void checkCardByMinfinTypePriorityTrueAndMinfinOrgPriorityTrueInCardsCatalog() {
        List<Integer> listOfCards = cardsPO.cardsIdsByMinfinTypePriorityAndMinfinOrgPriority(true, true);

        if (!listOfCards.isEmpty()) {
            int getVendorIdByFirstCardFromList = Objects
                    .requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                    .ids(Collections.singletonList(listOfCards.get(0)))
                                    .locale("ru")
                                    .active(1)
                                    .build())
                            .body())
                    .getData()
                    .get(0)
                    .getVendorId();
            cardsPO.open()
                    .scrollAllCards(cardsPO.getAllOrganizationsIdsList().size())
                    .checkVisibilityCardOnTheFirstPlaceByVendor(listOfCards.get(0), getVendorIdByFirstCardFromList);
        }
    }

    @TmsLink("MCS-A-20")
    @Test
    public void checkCardByMinfinTypePriorityFalseAndMinfinOrgPriorityTrueInCardsCatalog() {
        List<Integer> listOfCards = cardsPO.cardsIdsByMinfinTypePriorityAndMinfinOrgPriority(false, true);

        if (!listOfCards.isEmpty()) {
            int getVendorIdByFirstCardFromList = Objects
                    .requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                    .ids(Collections.singletonList(listOfCards.get(0)))
                                    .locale("ru")
                                    .active(1)
                                    .build())
                            .body())
                    .getData()
                    .get(0)
                    .getVendorId();
            cardsPO.open()
                    .scrollAllCards(cardsPO.getAllOrganizationsIdsList().size())
                    .checkVisibilityCardOnTheFirstPlaceByVendor(listOfCards.get(0), getVendorIdByFirstCardFromList);
        }
    }

    @TmsLink("MCS-A-19")
    @Test
    public void checkCardByMinfinTypePriorityTrueAndMinfinOrgPriorityFalseInCardsCatalog() {
        List<Integer> listOfCards = cardsPO.cardsIdsByMinfinTypePriorityAndMinfinOrgPriority(true, false);

        if (!listOfCards.isEmpty()) {
            int getVendorIdByFirstCardFromList = Objects
                    .requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                    .ids(Collections.singletonList(listOfCards.get(0)))
                                    .locale("ru")
                                    .active(1)
                                    .build())
                            .body())
                    .getData()
                    .get(0)
                    .getVendorId();
            cardsPO.openCardsByUrl(UrlsForSortingTests.CARDS_CREDIT)
                    .scrollAllCards(cardsPO.getOrganizationsIdByCreditCards().size())
                    .checkVisibilityCardOnTheFirstPlaceByVendor(listOfCards.get(0), getVendorIdByFirstCardFromList);
        }
    }

    @TmsLink("MCS-A-19")
    @Test
    public void checkCardByMinfinTypePriorityFalseAndMinfinOrgPriorityFalseInCardsCatalog() {
        List<Integer> listOfCards = cardsPO.cardsIdsByMinfinTypePriorityAndMinfinOrgPriority(false, false);

        final int zeroCardIndex = 0;
        int getVendorIdByRandomIndex = Objects
                .requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(Collections.singletonList(listOfCards.get(zeroCardIndex)))
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData()
                .get(zeroCardIndex)
                .getVendorId();
        cardsPO.open()
                .scrollAllCards(cardsPO.getAllOrganizationsIdsList().size())
                .checkVisibilityCardOnTheFirstPlaceByVendor(listOfCards.get(zeroCardIndex), getVendorIdByRandomIndex);
    }
}
