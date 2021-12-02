package com.minfin.Minfin.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.asserts.CardsAssert;
import com.minfin.Minfin.enums.CardWizardForm;
import com.minfin.Minfin.enums.UrlsForSortingTests;
import com.minfin.Minfin.model.api.products.v1.data.creditCards.CreditCardsDataItem;
import com.minfin.Minfin.model.api.products.v1.data.debitCards.DebitCardsDataItem;
import com.minfin.Minfin.pageobjects.common.WizardPO;
import com.minfin.Minfin.service.api.products.v1.list.*;
import com.minfin.Minfin.ui.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CardsPO extends BasePO {

    private static String baseUrl;
    private final ProductsDataService productsDataService = new ProductsDataService();
    private final CardsAssert cardsAssert = new CardsAssert();
    private final CreditCardsDataService creditCardsDataService = new CreditCardsDataService();
    private final DebitCardsDataService debitCardsDataService = new DebitCardsDataService();

    public SelenideElement CARDS_COUNT_AFTER_APPLYING_FILTER = $x("//*[@id='mc-products-list']/div[1]/div[1]/p");
    public List<SelenideElement> VENDORS_LIST = $$x("//*[starts-with(@data-elementid, 'vendorid-')]");

    public CardsPO() {
    }

    private static void getBaseUrl() {
        String env = "" + TestBase.environment;
        switch (env) {
            case "review1":
                baseUrl = "https://minfin-cards.review1.treeumapp.net/";
                break;
            case "review2":
                baseUrl = "https://minfin-cards.review2.treeumapp.net/";
                break;
            case "prod":
                baseUrl = "https://minfin.com.ua/";
                break;
            default:
                baseUrl = "https://minfin-cards.stage.treeumapp.net/";
        }
    }

    public int getCountCardsWithFastFilter() {
        return Integer.parseInt(CARDS_COUNT_AFTER_APPLYING_FILTER.text().replaceAll("[^0-9]", ""));
    }

    public CardsPO open() {
        getBaseUrl();
        step("When open cards/ url", () ->
                Selenide.open(baseUrl + "cards/"));
        return this;
    }

    public CardsPO openCardsByUrl(UrlsForSortingTests url) {
        getBaseUrl();
        step("When open cards by " + url.toString(), () ->
                Selenide.open(baseUrl + "cards/" + url.getLinkForSortingType()));
        return this;
    }

    public CardsPO checkVisibilityCardOnTheFirstPlaceByVendor(int cardId, int vendorId) {
        getBaseUrl();
        step("check visibility card with id " + cardId + " on the first place by vendorId " + vendorId, () ->
                ($x("( //*[contains(@href, '" + cardId + "-" + vendorId + "-')])[1]"))
                        .shouldBe(Condition.visible).scrollIntoView(false));
        return this;
    }

    public List<Integer> getOrganizationsIdByCreditCards() {
        List<Integer> activeCreditVendorIdsList = new ArrayList<>();

        List<CreditCardsDataItem> activeCreditCards = Objects.requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveCreditCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();
        activeCreditVendorIdsList.addAll(activeCreditCards.stream()
                .map(CreditCardsDataItem::getVendorId)
                .distinct()
                .collect(Collectors.toList()));

        return activeCreditVendorIdsList;
    }

    public List<Integer> getOrganizationsIdByDebitCards() {
        List<Integer> organizationsIdsList = new ArrayList<>();

        List<DebitCardsDataItem> listOfDebitCards = Objects.requireNonNull(debitCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveDebitCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();
        for (DebitCardsDataItem debitCardsDataItem : listOfDebitCards) {
            int getCardsIds = debitCardsDataItem.getVendorId();
            if (!organizationsIdsList.contains(getCardsIds)) {
                organizationsIdsList.add(getCardsIds);
            }
        }
        return organizationsIdsList;
    }

    public List<Integer> getAllOrganizationsIdsList() {
        List<Integer> activeVendorIds = new ArrayList<>();

        List<CreditCardsDataItem> activeCreditCards = Objects.requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveCreditCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();

        List<DebitCardsDataItem> activeDebitCards = Objects.requireNonNull(debitCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveDebitCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();

        activeVendorIds.addAll(activeCreditCards.stream()
                .map(CreditCardsDataItem::getVendorId)
                .collect(Collectors.toList()));
        activeVendorIds.addAll(activeDebitCards.stream()
                .map(DebitCardsDataItem::getVendorId)
                .collect(Collectors.toList()));

        return activeVendorIds;
    }

    public List<Integer> getIdByActiveCreditCards() {
        return Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                                .productType(0)
                                .active(1)
                                .build())
                        .body())
                .getData();
    }

    public List<Integer> getIdByActiveDebitCards() {
        return Objects.requireNonNull(productsDataService.getData(ProductsDataPathParameters.builder()
                .productType(5)
                .active(1)
                .build()).body()).getData();
    }

    public CardsPO scrollAllCards(int totalVendor) {
        step("When scroll all cards", () -> {
            for (int i = 0; i < totalVendor; i++) {
                int currentCardCount = $$(VENDORS_LIST).size();
                int cardWithRenderAction = currentCardCount - 1;
                $$(VENDORS_LIST).get(0).scrollTo();
                $$(VENDORS_LIST).get(cardWithRenderAction).scrollIntoView("{block: 'start'}");
                Selenide.sleep(500);
                if (currentCardCount + 1 == totalVendor) {
                    break;
                }
            }
        });
        return this;
    }


    public List<Integer> cardsIdsByMinfinTypePriorityAndMinfinOrgPriority(boolean minfinTypePriority, boolean minfinOrgPriority) {
        List<Integer> cardsIds = new ArrayList<>();

        List<CreditCardsDataItem> listOfCreditCards = Objects.requireNonNull(creditCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveCreditCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();

        List<DebitCardsDataItem> listOfDebitCards = Objects.requireNonNull(debitCardsDataService.getData(CardsDataPathParameters.builder()
                                .ids(getIdByActiveDebitCards())
                                .locale("ru")
                                .active(1)
                                .build())
                        .body())
                .getData();

        cardsIds.addAll(listOfCreditCards.stream()
                .filter(e -> Objects.nonNull(e.getMinfinTypePriority()) == minfinTypePriority)
                .filter(e -> Objects.nonNull(e.getMinfinOrgPriority()) == minfinOrgPriority)
                .map(CreditCardsDataItem::getId)
                .collect(Collectors.toList()));

        cardsIds.addAll(listOfDebitCards.stream()
                .filter(e -> Objects.nonNull(e.getMinfinTypePriority()) == minfinTypePriority)
                .filter(e -> Objects.nonNull(e.getMinfinOrgPriority()) == minfinOrgPriority)
                .map(DebitCardsDataItem::getId)
                .collect(Collectors.toList()));

        return cardsIds;
    }

    public WizardPO clickOnCardButton(CardWizardForm card) {
        step("When open order for " + card.getName(), () ->
                $(card.getCardButtonSelector()).scrollTo().shouldBe(Condition.visible, Duration.ofSeconds(6)).click());
        return new WizardPO();
    }
}
