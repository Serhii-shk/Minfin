package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ExchangeCardPO {
    public SelenideElement reviewsButton = $x("//button[@id='addReviewButton']");
    public SelenideElement firstReviewsLike = $x("(//button[@class='styles__LikeButton-c3s3ls-1 crkBdi'])[1]");
    public SelenideElement likeEnabledForFirstReview = $x("//*[@id='likeEnabledForFirstReview-60f960a736348aeb9f734d04']");
    public SelenideElement likeDisabledForFirstReview = $x("//*[@id='likeDisabledForFirstReview-60fd849a75ac948914a61602']");
    public SelenideElement userContextMenu = $x("(//div[@class='UserContextMenu'])[1]");
    public SelenideElement contextMenuComplaintButton = $x("//button[@class='styles__ContextMenuButton-fbasab-0 hluVje']");
    public SelenideElement cancelComplaintButton = $x("//button[@id='cancelComplaintButton']");
    public SelenideElement complaintText = $x("//textarea[@name='answer']");
    public SelenideElement postComplaintButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement reviewOnModeration = $x("//div[@class='styles__ReviewsItemStatus-i1icum-1 Synao']");
    public SelenideElement editReviewButton = $x("//button[@id='editButton-616702ced99ee86b61071f1c']");
    public SelenideElement deleteReviewButton = $x("//button[@id='removeButton-616702ced99ee86b61071f1c']");
    public SelenideElement restoreReview = $x("//button[@id='restoreReview']");
    public SelenideElement reviewDeleted = $x("(//div[@type='deleted'])[1]");
    public SelenideElement modalReviewDeleted = $("[class^='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement modalAuthOrRegistration = $x("//div[@class='styles__ModalAuthWrapper-sc-1phpxpj-32 gRUelK']");
    public SelenideElement sortButton = $x("//div[contains(@id, 'OrderSelector__Content-')]");
    public SelenideElement sortNewFirst = $x("//div[@id='sortNewFirst']");
    public SelenideElement cancelForReviewButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement answerForReviewButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement sendAnswerReviewButton = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");
    public SelenideElement errorMassageAnswer = $x("//div[@class='errorText']");
    public SelenideElement answerText = $x("//textarea[@name='answer']");
    public SelenideElement modalAnswerPosted = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement editAnswerButton = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    public SelenideElement modalAnswerEdited = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement sortDescendingRating = $x("//div[@id='sortDescendingRating']");
    public SelenideElement sortRatingGrowth = $x("//div[@id='sortRatingGrowth']");
    public SelenideElement sortByPopularity = $x("//div[@id='sortByPopularity']");
    public SelenideElement unansweredReviewFilter = $x("//button[@id='unansweredReviewFilter']");
    public SelenideElement negativeReviewsFilter = $x("//button[@id='negativeReviewsFilter']");
    public SelenideElement positiveReviewsFilter = $x("//button[@id='positiveReviewsFilter']");
    public SelenideElement sortByDefault = $x("//div[@id='sortByDefault']");
    public ElementsCollection allCreatedReviews = $$("#reviewsNav [class^='styles__ReviewsItems']  [class^='styles__ReviewsItem-']");
    public SelenideElement modalComplaintPosted = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    public SelenideElement modalForbiddenAddComplaint = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");


    public ReviewsPO clickReviewButton() {
        step("When click review button ", ()->reviewsButton.click());
        return new ReviewsPO();
    }

    public ModalWindowsPO secondClickReviewButton() {
        step("When second click review button ", ()->reviewsButton.click());
        return new ModalWindowsPO();
    }

    public ExchangeCardPO clickFirstReviewLike() {
        step("When click firs review like ", ()->firstReviewsLike.scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickReviewsLike() {
        step("When click reviews like ", ()->firstReviewsLike.click());
        return this;
    }

    public ExchangeCardPO scrollAfterCreatedReviews() {
        step("When scroll after created reviews ", ()->reviewsButton.scrollIntoView(false));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkLikeEnabledForFirstReview() {
        step("When check like enabled for first review ", ()-> likeEnabledForFirstReview.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkLikeDisabledForFirstReview() {
        step("When check like disabled for first review ", ()->likeDisabledForFirstReview.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO clickUserContextMenu() {
        step("When click user context menu ", ()->userContextMenu.shouldBe(visible, Duration.ofSeconds(10)).scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickContextMenuComplaintButton() {
        step("When click context menu complaint button ", ()->contextMenuComplaintButton.click());
        return this;
    }

    public ExchangeCardPO clickCancelComplaintButton() {
        step("When click cancel complaint button ", ()->cancelComplaintButton.click());
        return this;
    }

    public ExchangeCardPO setComplaintText() {
        step("When set complaint text ", ()->complaintText.setValue("Test complaint for review"));
        return this;
    }

    public ExchangeCardPO clickPostComplaintButton() {
        step("When click post complaint button ", ()->postComplaintButton.click());
        return this;
    }

    public ReviewsPO clickEditReviewButton() {
        step("When click edit review button ", ()->editReviewButton.click());
        return new ReviewsPO();
    }

    public ExchangeCardPO clickDeleteReviewButton() {
        step("When click delete review button ", ()->deleteReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickRestoreReview() {
        step("When click restore review ", ()->restoreReview.click());
        return this;
    }

    public ExchangeCardPO clickSortButton() {
        step("When click sort button ", ()->sortButton.click());
        return this;
    }

    public ExchangeCardPO selectSortNewFirst() {
        step("When select sort new first ", ()->sortNewFirst.click());
        return this;
    }

    public ExchangeCardPO clickCancelForReviewButton() {
        step("When click cancel for review button ", ()->cancelForReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickAnswerForReviewButton() {
        step("When click answer for review button ", ()->answerForReviewButton.click());
        return this;
    }

    public ExchangeCardPO clickSendAnswerReviewButton() {
        step("When click send answer review button ", ()->sendAnswerReviewButton.click());
        return this;
    }

    public ExchangeCardPO setValueTextInputField() {
        step("When set value text input field ", ()->answerText.setValue("Ответ Обменника на отзыв"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerPosted() {
        step("When check modal answer posted ", ()->modalAnswerPosted.shouldBe(visible));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickEditAnswerButtonForFirstReview() {
        step("When click edit answer button for first review ", ()->editAnswerButton.click());
        ;
        return this;
    }

    public ExchangeCardPO clearAnswerText() {
        step("When clear answer text ", ()->answerText.clear());
        return this;
    }

    public ExchangeCardPO setValueEditAnswerText() {
        step("When set value edit answer text ", ()->answerText.setValue("TestTestTestTestTestTest"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerEdited() {
        step("When check modal answer edited ", ()->modalAnswerEdited.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkSortDefault() {
        step("When check sort default ", ()->sortButton.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkSortNewFirst() {
        step("When check sort new first ", ()->sortButton.shouldHave(exactText("Сначала новые")));
        return this;
    }

    public ExchangeCardPO selectSortDescendingRating() {
        step("When select sort descending rating ", ()->sortDescendingRating.click());
        return this;
    }

    public ExchangeCardPO checkSortDescendingRating() {
        step("When check sort descending rating ", ()->sortButton.shouldHave(exactText("По убыванию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortRatingGrowth() {
        step("When select sort rating growth ", ()->sortRatingGrowth.click());
        return this;
    }

    public ExchangeCardPO checkSortRatingGrowth() {
        step("When check sort rating growth ", ()->sortButton.shouldHave(exactText("По возрастанию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortByPopularity() {
        step("When select sort by popularity ", ()->sortByPopularity.click());
        return this;
    }

    public ExchangeCardPO checkSortByPopularity() {
        step("When check sort by popularity ", ()->sortButton.shouldHave(exactText("По популярности")));
        return this;
    }

    public ExchangeCardPO selectUnansweredReviewFilter() {
        step("When select unanswered review filter ",()->unansweredReviewFilter.click());
        return this;
    }

    public ExchangeCardPO selectNegativeReviewsFilter() {
        step("When select negative reviews filter ", ()->negativeReviewsFilter.click());
        return this;
    }

    public ExchangeCardPO selectPositiveReviewsFilter() {
        step("When select  positive reviews filter ", ()->positiveReviewsFilter.click());
        return this;
    }

    public ExchangeCardPO selectSortByDefault() {
        step("When select sort by default ", ()->sortByDefault.click());
        return this;
    }

    public ExchangeCardPO checkSortByDefault() {
        step("When check sort by default ", ()->sortButton.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkModalComplaintPosted() {
        step("When check modal complaint posted ", ()->modalAnswerPosted.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkModalForbiddenAddComplaint() {
        step("When check modal forbidden add complaint ", ()->modalForbiddenAddComplaint.should(visible));
        return this;
    }

}
