package com.minfin.Minfin.ui.pageobjects.currency.auction;

import com.codeborne.selenide.SelenideElement;
import com.minfin.Minfin.ui.pageobjects.IBaseUrl;
import lombok.SneakyThrows;
import org.apache.http.conn.util.PublicSuffixList;

import javax.swing.plaf.PanelUI;

import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class AddCurrencyPO implements IBaseUrl {
    @Override
    @SneakyThrows
    public String getUrl() {
        return "office/add/currency/currency_id";
    }

    String rateEur = "32.50";
    int sumEur = 1000;
    private static final SelenideElement ADD_CURRENCY_BUTTON = $x("//button[@class='Button AddBtSection__Button normal icon']");
    private static final SelenideElement CURRENCY_DROPDOWN = $x("(//div[@class='DropdownContent'])[1]");
    private static final SelenideElement CURRENCY_EUR = $x("(//div[@class='DropdownItemContainer Dropdown__Item'])[1]");
    private static final SelenideElement BUY_SELL_DROPDOWN = $x("(//div[@class='DropdownContent'])[2]");
    private static final SelenideElement CURRENCY_BUY = $x("(//div[@class='DropdownItemContainer Dropdown__Item'])[1]");
    private static final SelenideElement EXACT_AMOUNT_CHECKBOX = $x("//label[@class='CheckboxContainer']");
    private static final SelenideElement BUY_RATE = $x("//div[@class='FloatInput active']//input[@type='text']");
    private static final SelenideElement SUM_BUY = $x("//div[@class='FloatInput FloatInput--left']//input[@type='text']");
    private static final SelenideElement CREATE_EXCHANGER_BUTTON = $x(" //button[@class='Button SubmitBtSection__Button primary normal']");

    public  AddCurrencyPO clickAddCurrencyButton() {
        step("When click  add currency button", () -> ADD_CURRENCY_BUTTON.click());
        return this;
    }

    @SneakyThrows
    public AddCurrencyPO clickCurrencyDropdown() {
        step("When click currency dropdown", () -> CURRENCY_DROPDOWN.click());
        Thread.sleep(2000);
        return this;
    }

    @SneakyThrows
    public AddCurrencyPO setCurrencyEur() {
        step("When set currency eur", () -> CURRENCY_EUR.click());
        Thread.sleep(2000);
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
        step("When set buy rate", () -> BUY_RATE.setValue(rateEur));
        return this;
    }

    public AddCurrencyPO setSumBuy() {
        step("When set sum buy", () -> SUM_BUY.setValue(String.valueOf(sumEur)));
        return this;
    }

    public LicensePO clickCreateExchangerButton() {
        step("When create exchanger button", () -> CREATE_EXCHANGER_BUTTON.click());
        return new LicensePO();
    }

}
