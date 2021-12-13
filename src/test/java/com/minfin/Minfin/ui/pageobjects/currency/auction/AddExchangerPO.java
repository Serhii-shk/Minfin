package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.BasePO;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;

import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class AddExchangerPO implements IBaseUrl {
    @Override
    public String getUrl() {
        return "add";
    }

    public static String getRandomPhoneNumber() {
        return "000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);
    }
    String street = "Крещатик 21";
    int smsCode = 2233;
    private static final SelenideElement CITY_DROPDOWN = $(".Controls .DropdownContent");
    private static final SelenideElement KIEV = $x("//span[text()='Киев']");
    private static final SelenideElement ADDRESS = $x("//div[@class='SearchLocationInput']");
    private static final SelenideElement ADDRESS_LIST = $x("(//div[@class='DropdownMenu__Item'])[1]");
    private static final SelenideElement ADDRESS_INPUT = $x("//input[@inputmode='text']");
    private static final SelenideElement PHONE_INPUT = $x("//input[@inputmode='decimal']");
    private static final SelenideElement SATURDAY_DAY_OFF_CHECKBOX = $x("(//header[@class='ScheduleItem__Header'] //span[@class='checkboxHover'])[1]");
    private static final SelenideElement SUNDAY_DAY_OFF_CHECKBOX = $x("(//header[@class='ScheduleItem__Header'] //span[@class='checkboxHover'])[2]");
    private static final SelenideElement DAMAGED_BANKNOTES_CHECKBOX = $x("(//section[@class='Controls']//label[@class='CheckboxContainer'])[1]");
    private static final SelenideElement VIDEO_SURVEILLANCE_CHECKBOX = $x("(//section[@class='Controls']//label[@class='CheckboxContainer'])[2]");
    private static final SelenideElement RECOUNT_ROOM_CHECKBOX = $x("(//section[@class='Controls']//label[@class='CheckboxContainer'])[3]");
    private static final SelenideElement EXCHANGER_DESCRIPTION_INPUT = $x("//textarea[@class='textArea']");
    private static final SelenideElement NEXT_STEP_BUTTON = $x("//button[@class='Button SubmitButton primary normal']");
    private static final SelenideElement SMS_CODE_INPUT = $x("//input[@type='tel']");
    private static final SelenideElement CONFIRM_BUTTON = $x("//button[@class='Button primary sizeM normal']");


    public AddExchangerPO clickCityDropdown(){
        step("When click City Dropdown", () -> CITY_DROPDOWN.click());
        return this;
    }

    public AddExchangerPO selectKiev() {
        step("When select kiev", () -> KIEV.click());
        return this;
    }

    public AddExchangerPO clickAddress() {
        step("When click address", () -> ADDRESS.click());
        return this;
    }

    public AddExchangerPO setAddress() {
        step("When set address", () -> ADDRESS_INPUT.setValue(street));
        return this;
    }

    public AddExchangerPO clickAddressList() {
        step("When click address list", () -> ADDRESS_LIST.click());
        return this;
    }

    public AddExchangerPO setPhone() {
        step("When set prone", () -> PHONE_INPUT.setValue(getRandomPhoneNumber()));
        return this;
    }

    public AddExchangerPO setSaturdayDayOff() {
        step("When set saturday day off", () -> SATURDAY_DAY_OFF_CHECKBOX.click());
        return this;
    }

    public AddExchangerPO setSundayDayOff() {
        step("When set sunday day off", () -> SUNDAY_DAY_OFF_CHECKBOX.click());
        return this;
    }

    public AddExchangerPO setDamagedBanknotes() {
        step("When set damaged banknotes", () -> DAMAGED_BANKNOTES_CHECKBOX.click());
        return this;
    }

    public AddExchangerPO setVideoSurveillance() {
        step("When set video surveillance", () -> VIDEO_SURVEILLANCE_CHECKBOX.click());
        return this;
    }

    public AddExchangerPO setRecountRoom() {
        step("When set recount room", () -> RECOUNT_ROOM_CHECKBOX.click());
        return this;
    }
    public AddExchangerPO setExchangerDescriptionInput() {
        step("When set exchanger description input", () -> EXCHANGER_DESCRIPTION_INPUT.setValue("Обменник предоставляет бозопастный сервис на выгодных условиях"));
        return this;
    }
    public AddExchangerPO clickNextStepButton() {
        step("When click next step button", () -> NEXT_STEP_BUTTON.click());
        return this;
    }

    public AddExchangerPO setSmsCodeInput() {
        step("When set sms code input", () -> SMS_CODE_INPUT.setValue(String.valueOf(smsCode)));
        return this;
    }

    public AddCurrencyPO clickConfirmButton() {
        step("When click confirm button", () -> CONFIRM_BUTTON.click());
        return new AddCurrencyPO();
    }


}


