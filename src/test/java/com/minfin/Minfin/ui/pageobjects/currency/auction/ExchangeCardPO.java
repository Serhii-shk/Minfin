package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ExchangeCardPO {
    private static final SelenideElement REVIEWS_BUTTON = $x("//button[@id='addReviewButton']");
    private static final SelenideElement FIRST_REVIEWS_LIKE = $x("(//button[@class='styles__LikeButton-c3s3ls-1 crkBdi'])[1]");
    private static final SelenideElement LIKE_ENABLED_FOR_FIRST_REVIEW = $x("//*[@id='likeEnabledForFirstReview-60f960a736348aeb9f734d04']");
    private static final SelenideElement LIKE_DISABLED_FOR_FIRST_REVIEW = $x("//*[@id='likeDisabledForFirstReview-60fd849a75ac948914a61602']");
    private static final SelenideElement USER_CONTEXT_MENU = $x("(//div[@class='UserContextMenu'])[1]");
    private static final SelenideElement CONTEXT_MENU_COMPLAINT_BUTTON = $x("//button[@class='styles__ContextMenuButton-fbasab-0 hluVje']");
    private static final SelenideElement CANCEL_COMPLAINT_BUTTON = $x("//button[@id='cancelComplaintButton']");
    private static final SelenideElement COMPLAINT_TEXT = $x("//textarea[@name='answer']");
    private static final SelenideElement POST_COMPLAINT_BUTTON = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");

    public static SelenideElement getReviewOnModeration() {
        return REVIEW_ON_MODERATION;
    }

    private static SelenideElement REVIEW_ON_MODERATION = $x("//div[@class='styles__ReviewsItemStatus-i1icum-1 Synao']");
    private static final SelenideElement EDIT_REVIEW_BUTTON = $x("//button[@id='editButton-616702ced99ee86b61071f1c']");
    private static final SelenideElement DELETE_REVIEW_BUTTON = $x("//button[@id='removeButton-616702ced99ee86b61071f1c']");
    private static final SelenideElement RESTORE_REVIEW = $x("//button[@id='restoreReview']");

    public static SelenideElement getReviewDeleted() {
        return REVIEW_DELETED;
    }
    private static final SelenideElement REVIEW_DELETED = $x("(//div[@type='deleted'])[1]");

    public static SelenideElement getModalReviewDeleted() {
        return MODAL_REVIEW_DELETED;
    }
    private static final SelenideElement MODAL_REVIEW_DELETED = $("[class^='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");

    public static SelenideElement getModalAuthOrRegistration() {
        return MODAL_AUTH_OR_REGISTRATION;
    }
    private static final SelenideElement MODAL_AUTH_OR_REGISTRATION = $x("//div[@class='styles__ModalAuthWrapper-sc-1phpxpj-32 gRUelK']");

    private static final SelenideElement SORT_BUTTON = $x("//div[contains(@id, 'OrderSelector__Content-')]");
    private static final SelenideElement SORT_NEW_FIRST = $x("//div[@id='sortNewFirst']");
    private static final SelenideElement CANCEL_FOR_REVIEW_BUTTON = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    private static final SelenideElement ANSWER_FOR_REVIEW_BUTTON = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    private static final SelenideElement SEND_ANSWER_REVIEW_BUTTON = $x("//button[@class='styles__Button-sc-1phpxpj-34 fcurHU']");

    public static SelenideElement getErrorMassageAnswer() {
        return ERR_OR_MASSAGE_ANSWER;
    }
    private static final SelenideElement ERR_OR_MASSAGE_ANSWER = $x("//div[@class='errorText']");

    private static final SelenideElement ANSWER_TEXT = $x("//textarea[@name='answer']");
    private static final SelenideElement MODAL_ANSWER_POSTED = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    private static final SelenideElement EDIT_ANSWER_BUTTON = $x("(//button[@class='styles__Button-sc-1phpxpj-34 styles__OutlineButton-sc-1phpxpj-35 gFxekH icGSYQ'])[1]");
    private static final SelenideElement MODAL_ANSWER_EDITED = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    private static final SelenideElement SORT_DESCENDING_RATING = $x("//div[@id='sortDescendingRating']");
    private static final SelenideElement SORT_RATING_GROWTH = $x("//div[@id='sortRatingGrowth']");
    private static final SelenideElement SORT_BY_POPULARITY = $x("//div[@id='sortByPopularity']");
    private static final SelenideElement UNANSWERED_REVIEW_FILTER = $x("//button[@id='unansweredReviewFilter']");
    private static final SelenideElement NEGATIVE_REVIEWS_FILTER = $x("//button[@id='negativeReviewsFilter']");
    private static final SelenideElement POSITIVE_REVIEWS_FILTER = $x("//button[@id='positiveReviewsFilter']");
    private static final SelenideElement SORT_BY_DEFAULT = $x("//div[@id='sortByDefault']");

    public static ElementsCollection getAllCreatedReviews() {
        return ALL_CREATED_REVIEWS;
    }
    private static final ElementsCollection ALL_CREATED_REVIEWS = $$("#reviewsNav [class^='styles__ReviewsItems']  [class^='styles__ReviewsItem-']");

    private static final SelenideElement MODAL_COMPLAINT_POSTED = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");
    private static final SelenideElement MODAL_FORBIDDEN_ADD_COMPLAINT = $x("//div[@class='styles__SnackbarWrapper-sc-110il7f-0 izOZYq']");


    public ReviewsPO clickReviewButton() {
        step("When click review button ", ()-> REVIEWS_BUTTON.click());
        return new ReviewsPO();
    }

    public ModalWindowsPO secondClickReviewButton() {
        step("When second click review button ", ()-> REVIEWS_BUTTON.click());
        return new ModalWindowsPO();
    }

    public ExchangeCardPO clickFirstReviewLike() {
        step("When click firs review like ", ()-> FIRST_REVIEWS_LIKE.scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickReviewsLike() {
        step("When click reviews like ", ()-> FIRST_REVIEWS_LIKE.click());
        return this;
    }

    public ExchangeCardPO scrollAfterCreatedReviews() {
        step("When scroll after created reviews ", ()-> REVIEWS_BUTTON.scrollIntoView(false));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO checkLikeEnabledForFirstReview() {
        step("When check like enabled for first review ", ()-> LIKE_ENABLED_FOR_FIRST_REVIEW.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkLikeDisabledForFirstReview() {
        step("When check like disabled for first review ", ()-> LIKE_DISABLED_FOR_FIRST_REVIEW.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO clickUserContextMenu() {
        step("When click user context menu ", ()-> USER_CONTEXT_MENU.shouldBe(visible, Duration.ofSeconds(10)).scrollTo().click());
        return this;
    }

    public ExchangeCardPO clickContextMenuComplaintButton() {
        step("When click context menu complaint button ", ()-> CONTEXT_MENU_COMPLAINT_BUTTON.click());
        return this;
    }

    public ExchangeCardPO clickCancelComplaintButton() {
        step("When click cancel complaint button ", ()-> CANCEL_COMPLAINT_BUTTON.click());
        return this;
    }

    public ExchangeCardPO setComplaintText() {
        step("When set complaint text ", ()-> COMPLAINT_TEXT.setValue("Test complaint for review"));
        return this;
    }

    public ExchangeCardPO clickPostComplaintButton() {
        step("When click post complaint button ", ()-> POST_COMPLAINT_BUTTON.click());
        return this;
    }

    public ReviewsPO clickEditReviewButton() {
        step("When click edit review button ", ()-> EDIT_REVIEW_BUTTON.click());
        return new ReviewsPO();
    }

    public ExchangeCardPO clickDeleteReviewButton() {
        step("When click delete review button ", ()-> DELETE_REVIEW_BUTTON.click());
        return this;
    }

    public ExchangeCardPO clickRestoreReview() {
        step("When click restore review ", ()-> RESTORE_REVIEW.click());
        return this;
    }

    public ExchangeCardPO clickSortButton() {
        step("When click sort button ", ()-> SORT_BUTTON.click());
        return this;
    }

    public ExchangeCardPO selectSortNewFirst() {
        step("When select sort new first ", ()-> SORT_NEW_FIRST.click());
        return this;
    }

    public ExchangeCardPO clickCancelForReviewButton() {
        step("When click cancel for review button ", ()-> CANCEL_FOR_REVIEW_BUTTON.click());
        return this;
    }

    public ExchangeCardPO clickAnswerForReviewButton() {
        step("When click answer for review button ", ()-> ANSWER_FOR_REVIEW_BUTTON.click());
        return this;
    }

    public ExchangeCardPO clickSendAnswerReviewButton() {
        step("When click send answer review button ", ()-> SEND_ANSWER_REVIEW_BUTTON.click());
        return this;
    }

    public ExchangeCardPO setValueTextInputField() {
        step("When set value text input field ", ()-> ANSWER_TEXT.setValue("Ответ Обменника на отзыв"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerPosted() {
        step("When check modal answer posted ", ()-> MODAL_ANSWER_POSTED.shouldBe(visible));
        return new ExchangeCardPO();
    }

    public ExchangeCardPO clickEditAnswerButtonForFirstReview() {
        step("When click edit answer button for first review ", ()-> EDIT_ANSWER_BUTTON.click());
        ;
        return this;
    }

    public ExchangeCardPO clearAnswerText() {
        step("When clear answer text ", ()-> ANSWER_TEXT.clear());
        return this;
    }

    public ExchangeCardPO setValueEditAnswerText() {
        step("When set value edit answer text ", ()-> ANSWER_TEXT.setValue("TestTestTestTestTestTest"));
        return this;
    }

    public ExchangeCardPO checkModalAnswerEdited() {
        step("When check modal answer edited ", ()-> MODAL_ANSWER_EDITED.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkSortDefault() {
        step("When check sort default ", ()-> SORT_BUTTON.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkSortNewFirst() {
        step("When check sort new first ", ()-> SORT_BUTTON.shouldHave(exactText("Сначала новые")));
        return this;
    }

    public ExchangeCardPO selectSortDescendingRating() {
        step("When select sort descending rating ", ()-> SORT_DESCENDING_RATING.click());
        return this;
    }

    public ExchangeCardPO checkSortDescendingRating() {
        step("When check sort descending rating ", ()-> SORT_BUTTON.shouldHave(exactText("По убыванию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortRatingGrowth() {
        step("When select sort rating growth ", ()-> SORT_RATING_GROWTH.click());
        return this;
    }

    public ExchangeCardPO checkSortRatingGrowth() {
        step("When check sort rating growth ", ()-> SORT_BUTTON.shouldHave(exactText("По возрастанию рейтинга")));
        return this;
    }

    public ExchangeCardPO selectSortByPopularity() {
        step("When select sort by popularity ", ()-> SORT_BY_POPULARITY.click());
        return this;
    }

    public ExchangeCardPO checkSortByPopularity() {
        step("When check sort by popularity ", ()-> SORT_BUTTON.shouldHave(exactText("По популярности")));
        return this;
    }

    public ExchangeCardPO selectUnansweredReviewFilter() {
        step("When select unanswered review filter ",()-> UNANSWERED_REVIEW_FILTER.click());
        return this;
    }

    public ExchangeCardPO selectNegativeReviewsFilter() {
        step("When select negative reviews filter ", ()-> NEGATIVE_REVIEWS_FILTER.click());
        return this;
    }

    public ExchangeCardPO selectPositiveReviewsFilter() {
        step("When select  positive reviews filter ", ()-> POSITIVE_REVIEWS_FILTER.click());
        return this;
    }

    public ExchangeCardPO selectSortByDefault() {
        step("When select sort by default ", ()-> SORT_BY_DEFAULT.click());
        return this;
    }

    public ExchangeCardPO checkSortByDefault() {
        step("When check sort by default ", ()-> SORT_BUTTON.shouldHave(exactText("По умолчанию")));
        return this;
    }

    public ExchangeCardPO checkModalComplaintPosted() {
        step("When check modal complaint posted ", ()-> MODAL_ANSWER_POSTED.shouldBe(visible));
        return this;
    }

    public ExchangeCardPO checkModalForbiddenAddComplaint() {
        step("When check modal forbidden add complaint ", ()-> MODAL_FORBIDDEN_ADD_COMPLAINT.should(visible));
        return this;
    }

}
