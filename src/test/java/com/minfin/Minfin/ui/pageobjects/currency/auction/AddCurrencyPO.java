package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import org.apache.http.conn.util.PublicSuffixList;

import javax.swing.plaf.PanelUI;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class AddCurrencyPO implements IBaseUrl {
    public String getUrl() {
        return "office/add/currency/";
    }

    float rateEur = (float) 32.50;
    int sumEur = 1000;
    private static final SelenideElement ADD_CURRENCY_BUTTON = $x("//button[@class='Button AddBtSection__Button normal icon']");
    private static final SelenideElement CURRENCY_DROPDOWN = $x("(//div[@class='DropdownContent'])[1]");
    private static final SelenideElement CURRENCY_EUR = $x("(//div[@class='DropdownItemContainer Dropdown__Item'])[1]");
    private static final SelenideElement BUY_SELL_DROPDOWN = $x("(//div[@class='DropdownContent'])[2]");
    private static final SelenideElement CURRENCY_BUY = $x("(//div[@class='DropdownItemContainer Dropdown__Item'])[1]");
    private static final SelenideElement EXACT_AMOUNT_CHECKBOX = $x("//label[@class='CheckboxContainer']");
    private static final SelenideElement BUY_RATE = $x("//div[@class='FloatInput']//input[@type='text']");
    private static final SelenideElement SUM_BUY = $x("//div[@class='FloatInput FloatInput--left']//input[@type='text']");

    public  AddCurrencyPO clickAddCurrencyButton() {
        step("When click  add currency button", () -> ADD_CURRENCY_BUTTON.click());
        return this;
    }

    public AddCurrencyPO clickCurrencyDropdown() {
        step("When click currency dropdown", () -> CURRENCY_DROPDOWN.click());
        return this;
    }

    public AddCurrencyPO setCurrencyEur() {
        step("When set currency eur", () -> CURRENCY_EUR);
        return this;
    }

    public AddCurrencyPO clickBuySellDropdown() {
        step("When click buy sell dropdown", () -> BUY_SELL_DROPDOWN.click());
        return this;
    }

    public AddCurrencyPO setCurrencyBuy() {
        step("When setCurrencyBuy", () -> CURRENCY_BUY.click());
        return this;
    }

    public AddCurrencyPO setExactAmountCheckbox() {
        step("When set exact amount checkbox", () -> EXACT_AMOUNT_CHECKBOX.click());
        return this;
    }

    public AddCurrencyPO setBuyRate() {
        step("When set buy rate", () -> BUY_RATE.setValue(String.valueOf(rateEur)));
        return this;
    }

    public AddCurrencyPO setSumBuy() {
        step("When set sum buy", () -> SUM_BUY.setValue(String.valueOf(sumEur)));
        return this;
    }

}
