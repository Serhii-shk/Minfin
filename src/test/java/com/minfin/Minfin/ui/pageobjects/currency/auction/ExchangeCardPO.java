package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ExchangeCardPO {
    public SelenideElement reviewsButton = $("#reviewsNav button");
    public SelenideElement firstReviewsLike = $x("(//button[@class='styles__LikeButton-c3s3ls-1 crkBdi'])[1]");
    public SelenideElement likeEnabledForFirstReview = $x("(//*[@d='M23 9a2 2 0 00-2-2h-6.32l.96-4.57c.02-.1.03-.21.03-.32 0-.41-.17-.79-.44-1.06L14.17 0 7.59 6.58C7.22 6.95 7 7.45 7 8v10a2 2 0 002 2h9c.83 0 1.54-.5 1.84-1.22l3.02-7.05c.09-.23.14-.47.14-.73V9zM1 20h4V8H1v12z'])[1]");
    public SelenideElement likeDisabledForFirstReview = $x("(//*[@d='M5 9v12H1V9h4zm4 12a2 2 0 01-2-2V9c0-.55.22-1.05.59-1.41L14.17 1l1.06 1.06c.27.27.44.64.44 1.05l-.03.32L14.69 8H21a2 2 0 012 2v2c0 .26-.05.5-.14.73l-3.02 7.05C19.54 20.5 18.83 21 18 21H9zm0-2h9.03L21 12v-2h-8.79l1.13-5.32L9 9.03V19z'])[1]");
    public SelenideElement userContextMenu = $x("(//div[@class='UserContextMenu'])[1]");
    public SelenideElement contextMenuComplaintButton = $x("//button[@class='styles__ContextMenuButton-fbasab-0 hluVje']");
    public SelenideElement cancelComplaintButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ']");
    public SelenideElement complaintText = $x("//textarea[@name='answer']");
    public SelenideElement postComplaintButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement reviewOnModeration = $x("//div[@class='styles__ReviewsItemStatus-i1icum-1 Synao']");
    public SelenideElement editReviewButton = $x("(//button[@class='styles__ContextMenuButton-fbasab-0 hluVje'])[2]");
    public SelenideElement deleteReviewButton = $x("//span[@class='UserContextMenu__Wrapper']/button[1]");
    public SelenideElement restoreReview = $x("//button[@class='styles__ActivateButton-sc-1phpxpj-48 cjGLRg']");
    public SelenideElement reviewDeleted = $x("(//div[@type='deleted'])[1]");
    public SelenideElement modalReviewDeleted = $("[class^='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
                                                         //div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']
    public SelenideElement modalAuthOrRegistration = $x("//div[@class='styles__ModalAuthWrapper-sc-1phpxpj-32 gRUelK']");
    public SelenideElement sortButton = $x("//div[@class='DropdownContent OrderSelector__Content']");
    public SelenideElement sortNewFirst = $x("//div[@class='DropdownItemContainer DropdownItemContainer--Selected Dropdown__Item OrderSelector__Item']/span[text()='Сначала новые']");
    public SelenideElement cancelForReviewButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement answerForReviewButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement sendAnswerReviewButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement errorMassageAnswer = $x("//div[@class='errorText']");
    public SelenideElement answerText = $x("//textarea[@name='answer']");
    public SelenideElement modalAnswerPosted = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement editAnswerButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement modalAnswerEdited = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement sortDescendingRating = $x("//div[@class='DropdownItemContainer Dropdown__Item OrderSelector__Item']/span[text()='По убыванию рейтинга']");
    public SelenideElement sortRatingGrowth = $x("//div[@class='DropdownItemContainer Dropdown__Item OrderSelector__Item']/span[text()='По возрастанию рейтинга']");
    public SelenideElement sortByPopularity = $x("//div[@class='DropdownItemContainer Dropdown__Item OrderSelector__Item']/span[text()='По популярности']");
    public SelenideElement unansweredReviewFilter = $("[class^='styles__FilterItems-'] button:nth-child(2)");
    public SelenideElement negativeReviewsFilter = $("[class^='styles__FilterItems-'] button:nth-child(3)");
    public SelenideElement positiveReviewsFilter = $("[class^='styles__FilterItems-'] button:nth-child(4)");
    public SelenideElement sortByDefault = $x("//div[@class='DropdownItemContainer Dropdown__Item OrderSelector__Item']/span[text()='По умолчанию']");
    public ElementsCollection allCreatedReviews = $$("#reviewsNav [class^='styles__ReviewsItems']  [class^='styles__ReviewsItem-']");
    public SelenideElement modalComplaintPosted = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement modalForbiddenAddComplaint = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");


    public ReviewsPO clickReviewButton() {
        step("when click review button ", ()->reviewsButton.click());
        return new ReviewsPO();
    }

    public ModalWindowsPO secondClickReviewButton() {
        step("when second click review button ", ()->reviewsButton.click());
        return new ModalWindowsPO();
    }

    public ExchangeCardPO clickFirstReviewLike() {
        step("when click firs review like ", ()->firstReviewsLike.scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickReviewsLike() {
        step("when click reviews like ", ()->firstReviewsLike.click());
        return this;
    }

    public ExchangeCardPO scrollAfterCreatedReviews() {
        step("when scroll after created reviews ", ()->reviewsButton.scrollIntoView(false));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkLikeEnabledForFirstReview() {
        step("when check like enabled for first review ", ()-> likeEnabledForFirstReview.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkLikeDisabledForFirstReview() {
        step("when check like disabled for first review ", ()->likeDisabledForFirstReview.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO clickUserContextMenu() {
        step("when click user context menu ", ()->userContextMenu.shouldBe(visible, Duration.ofSeconds(10)).scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickContextMenuComplaintButton() {
        step("when click context menu complaint button ", ()->contextMenuComplaintButton.click());
        return this;
    }

    public ExchangeCardPO clickCancelComplaintButton() {
        step("when click cancel complaint button ", ()->cancelComplaintButton.click());
        return this;
    }

    public ExchangeCardPO setComplaintText() {
        step("when set complaint text ", ()->complaintText.setValue("Test complaint for review"));
        return this;
    }

    public ExchangeCardPO clickPostComplaintButton() {
        step("when click post complaint button ", ()->postComplaintButton.click());
        return this;
    }

    public ReviewsPO clickEditReviewButton() {
        step("when click edit review button ", ()->editReviewButton.click());
        return new ReviewsPO();
    }

    public ExchangeCardPO clickDeleteReviewButton() {
        step("when click delete review button ", ()->deleteReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickRestoreReview() {
        step("when click restore review ", ()->restoreReview.click());
        return this;
    }

    public ExchangeCardPO clickSortButton() {
        step("when click sort button ", ()->sortButton.click());
        return this;
    }

    public ExchangeCardPO selectSortNewFirst() {
        step("when select sort new first ", ()->sortNewFirst.click());
        return this;
    }

    public ExchangeCardPO clickCancelForReviewButton() {
        step("when click cancel for review button ", ()->cancelForReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickAnswerForReviewButton() {
        step("when click answer for review button ", ()->answerForReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickSendAnswerReviewButton() {
        step("when click send answer review button ", ()->sendAnswerReviewButton.click());
        return this;
    }

    public ExchangeCardPO setValueTextInputField() {
        step("when set value text input field ", ()->answerText.setValue("Ответ Обменника на отзыв"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerPosted() {
        step("when check modal answer posted ", ()->modalAnswerPosted.shouldBe(visible));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickEditAnswerButtonForFirstReview() {
        step("when click edit answer button for first review ", ()->editAnswerButton.click());
        ;
        return this;
    }

    public ExchangeCardPO clearAnswerText() {
        step("when clear answer text ", ()->answerText.clear());
        return this;
    }

    public ExchangeCardPO setValueEditAnswerText() {
        step("when set value edit answer text ", ()->answerText.setValue("TestTestTestTestTestTest"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerEdited() {
        step("when check modal answer edited ", ()->modalAnswerEdited.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkSortDefault() {
        step("when check sort default ", ()->sortButton.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkSortNewFirst() {
        step("when check sort new first ", ()->sortButton.shouldHave(exactText("Сначала новые")));
        return this;
    }

    public ExchangeCardPO selectSortDescendingRating() {
        step("when select sort descending rating ", ()->sortDescendingRating.click());
        return this;
    }

    public ExchangeCardPO checkSortDescendingRating() {
        step("when check sort descending rating ", ()->sortButton.shouldHave(exactText("По убыванию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortRatingGrowth() {
        step("when select sort rating growth ", ()->sortRatingGrowth.click());
        return this;
    }

    public ExchangeCardPO checkSortRatingGrowth() {
        step("when check sort rating growth ", ()->sortButton.shouldHave(exactText("По возрастанию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortByPopularity() {
        step("when select sort by popularity ", ()->sortByPopularity.click());
        return this;
    }

    public ExchangeCardPO checkSortByPopularity() {
        step("when check sort by popularity ", ()->sortButton.shouldHave(exactText("По популярности")));
        return this;
    }

    public ExchangeCardPO selectUnansweredReviewFilter() {
        step("when select unanswered review filter ",()->unansweredReviewFilter.click());
        return this;
    }

    public ExchangeCardPO selectNegativeReviewsFilter() {
        step("when select negative reviews filter ", ()->negativeReviewsFilter.click());
        return this;
    }

    public ExchangeCardPO selectPositiveReviewsFilter() {
        step("when select  positive reviews filter ", ()->positiveReviewsFilter.click());
        return this;
    }

    public ExchangeCardPO selectSortByDefault() {
        step("when select sort by default ", ()->sortByDefault.click());
        return this;
    }

    public ExchangeCardPO checkSortByDefault() {
        step("when check sort by default ", ()->sortButton.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkModalComplaintPosted() {
        step("when check modal complaint posted ", ()->modalAnswerPosted.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkModalForbiddenAddComplaint() {
        step("when check modal forbidden add complaint ", ()->modalForbiddenAddComplaint.should(visible));
        return this;
    }

}
