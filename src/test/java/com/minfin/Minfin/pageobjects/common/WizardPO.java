package com.minfin.Minfin.pageobjects.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.enums.City;
import com.minfin.Minfin.enums.Employment;
import com.minfin.Minfin.enums.PurposeOfUse;
import com.minfin.Minfin.pageobjects.BasePO;
import com.minfin.Minfin.ui.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WizardPO {

    public SelenideElement FORWARD_BUTTON = $x("//button[@data-state='button-forward']");
    private static final String EMAIL_INPUT = "[data-state='input-email']";
    private static final String SUR_NAME_INPUT = "[data-state='input-lastName']";
    private static final String FIRST_NAME_INPUT = "[data-state='input-firstName']";
    private static final String MIDDLE_NAME_INPUT = "[data-state='input-middleName']";
    private static final String FIRST_SURNAME_INPUT = "[data-state='input-firstLastName']";
    private static final String FULL_NAME_INPUT = "[data-state='input-lastFirstMiddleName']";
    private static final String CONTACT_NAME_INPUT = "[data-state='input-contactName']";
    private static final String CONTACT_PHONE_INPUT = "[data-state='input-contactPhone']";
    private static final String PHONE_INPUT = "[data-state='input-phoneNumber']";
    private static final String MODAL_SUBMIT_BUTTON = "[data-state='button-modal-ok']";
    private static final String BIRTHDAY_DAY = "#bday-day";
    private static final String BIRTHDAY_MONTH = "#bday-month";
    private static final String BIRTHDAY_YEAR = "#bday-year";
    private static final String ID_NUMBER = "[data-state='input-inn']";
    public static final String SEND_OFFER_BUTTON =
            ".TR_WL_FinalOffer__button--accent, " +//card order form
                    "[data-state='button-skip-submitOffer']," +
                    "[data-state='button-submitOffer']";//w14

    public static final String BLANK_PAGE = "[data-active-screen='blank']";
    public static final String RESULT_PAGE = "[data-active-screen='result']";
    public static final String EMPTY_RESULT_PAGE = "[data-active-screen='emptyOffer']";

    private static final String CANCEL = "[data-state='button-saveProfile.cancel']";


    private static String baseUrl;
    private final BasePO basePO;
    private User user;

    public WizardPO() {
        basePO = new BasePO();
        getBaseUrl();
    }

    public WizardPO(User user) {
        this.user = user;
        basePO = new BasePO();
        getBaseUrl();
    }

    private static void getBaseUrl() {
        String env = "" + TestBase.environment;
        switch (env) {
            case "review1":
                baseUrl = "https://wizard-client.review1.treeumapp.net";
                break;
            case "review2":
                baseUrl = "https://wizard-client.review2.treeumapp.net";
                break;
            case "stage1":
            default:
                baseUrl = "https://wizard-client-stage.treeum.net";
        }
    }

    public WizardPO setFirstName() {
        this.setFirstName(user.getFirstName());
        return this;
    }

    public WizardPO setFirstName(String firstName) {
        step("When set first name: " + firstName, () -> $(FIRST_NAME_INPUT).setValue(firstName));
        return this;
    }

    public WizardPO setSurname() {
        this.setSurname(user.getSurname());
        return this;
    }

    public WizardPO setSurname(String surName) {
        step("When set surname: " + surName, () -> $(SUR_NAME_INPUT).setValue(surName));
        return this;
    }

    public WizardPO setFirstNameSurname() {
        this.setFirstNameSurname(user.getSurname());
        return this;
    }

    public WizardPO setFirstNameSurname(String firstNameSurname) {
        step("When set first name and surname name: " + firstNameSurname,
                () -> $(FIRST_SURNAME_INPUT).setValue(firstNameSurname));
        return this;
    }

    public WizardPO setFullName() {
        this.setFullName(
                user.getMiddleName() + " " + user.getFirstName() + " " + user.getSurname());
        return this;
    }

    public WizardPO setFullName(String fullName) {
        step("When set full name: " + fullName, () -> {
            basePO.clearText(FULL_NAME_INPUT);
            $(FULL_NAME_INPUT).setValue(fullName);
        });
        return this;
    }

    public WizardPO setContactName() {
        setContactName(user.getContactName());
        return this;
    }

    public WizardPO setContactName(String contactName) {
        step("When set contact name: " + contactName, () -> {
            basePO.clearText(CONTACT_NAME_INPUT);
            $(CONTACT_NAME_INPUT).setValue(contactName);
        });
        return this;
    }

    public WizardPO setMiddleName() {
        this.setMiddleName(user.getMiddleName());
        return this;
    }

    public WizardPO setMiddleName(String middleName) {
        step("When set middle name: " + middleName,
                () -> $(MIDDLE_NAME_INPUT).setValue(middleName));
        return this;
    }

    public WizardPO setPhone() {
        this.setPhone(user.getPhone());
        return this;
    }

    public WizardPO setPhone(String phone) {
        step("When set phone: " + phone, () -> {
            basePO.clearText(PHONE_INPUT);
            $(PHONE_INPUT).setValue(phone);
        });
        return this;
    }

    public WizardPO setContactPhone() {
        setContactPhone(user.getContactPhone());
        return this;
    }

    public WizardPO setContactPhone(String contactPhone) {
        step("When set contact phone: " + contactPhone, () -> {
            basePO.clearText(CONTACT_PHONE_INPUT);
            $(CONTACT_PHONE_INPUT).setValue(contactPhone);
        });
        return this;
    }

    public WizardPO setEmail() {
        this.setEmail(user.getEmail());
        return this;
    }

    public WizardPO setEmail(String mail) {
        step("When set mail: " + mail, () -> {
            $(EMAIL_INPUT).shouldBe(Condition.visible, Duration.ofSeconds(17));
            basePO.clearText(EMAIL_INPUT);
            $(EMAIL_INPUT).setValue(mail);
        });
        return this;
    }

    public WizardPO clickForward() {
        sleep(1_000);
        step("When click forward", () -> $(FORWARD_BUTTON).click());
        return this;
    }

    public WizardPO clickModalSubmit() {
        step("When on modal form click OK", () -> $(MODAL_SUBMIT_BUTTON).click());
        return this;
    }

    public WizardPO setCreditCardUsage() {
        this.setCreditCardUsage(this.user.getPurposeOfUse());
        return this;
    }

    public WizardPO setCreditCardUsage(PurposeOfUse purposeOfUse) {
        step("When select credit card usage: " + purposeOfUse.getName(),
                () -> $(purposeOfUse.getSelector()).click());
        return this;
    }

    public WizardPO setEmploymentByButton() {
        this.setEmploymentByButton(this.user.getEmployment());
        return this;
    }

    public WizardPO setEmploymentByButton(Employment employment) {
        step("When select employment button: " + employment.getName(),
                () -> $(employment.getSelector()).click());
        return this;
    }

    public WizardPO setCityByButton() {
        this.setCityByButton(this.user.getCity());
        return this;
    }

    public WizardPO setCityByButton(City city) {
        step("When select city: " + city.getNameUa(), () -> $(city.getSelector()).click());
        return this;
    }

    public WizardPO setDayOfBirthday() {
        this.setDayOfBirthday(this.user.getDayOfBirthday());
        return this;
    }

    public WizardPO setDayOfBirthday(String day) {
        step("When set day of birthday: " + day, () -> $(BIRTHDAY_DAY).setValue(day));
        return this;
    }

    public WizardPO setMonthOfBirthday() {
        this.setMonthOfBirthday(this.user.getMonthOfBirthday());
        return this;
    }

    public WizardPO setMonthOfBirthday(String month) {
        step("When set month of birthday: " + month, () -> $(BIRTHDAY_MONTH).setValue(month));
        return this;
    }

    public WizardPO setYearOfBirthday() {
        this.setYearOfBirthday(this.user.getYearOfBirthday());
        return this;
    }

    public WizardPO setYearOfBirthday(String year) {
        step("When set year of birthday: " + year, () -> $(BIRTHDAY_YEAR).setValue(year));
        return this;
    }

    public WizardPO setINNNumber() {
        this.setINNNumber(this.user.getInn());
        return this;
    }

    public WizardPO setINNNumber(String id) {
        step("When set id number: " + id, () -> {
            basePO.clearText(ID_NUMBER);
            $(ID_NUMBER).setValue(id);
        });
        return this;
    }

    public WizardPO clickSendOffer() {
        step("When click send offer", () ->
                $(SEND_OFFER_BUTTON).shouldBe(Condition.exist, Duration.ofSeconds(120)).click());
        return this;
    }

    public WizardPO waitForResultScreen() {
        step("When wait for result screen",
                () -> $(String.format("%s,%s,%s", RESULT_PAGE, BLANK_PAGE, EMPTY_RESULT_PAGE))
                        .shouldBe(Condition.visible,
                                Duration
                                        .ofSeconds(120)));//затримка на стороні фінлайну спробувати зменшити 03.2021
        return this;
    }

    public WizardPO dismissLoginToMyAccount() {
        step("When dismiss my account login", () ->
                $(CANCEL).should(Condition.visible, Duration.ofSeconds(20)).click());
        return this;
    }
}
