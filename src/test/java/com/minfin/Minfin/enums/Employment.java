package com.minfin.Minfin.enums;

public enum Employment {
    LEGAL_WORK("Офіційне працевлаштування", "[data-state='button-employment-1']",
            "//div[@role='menuitem'][@value='1']"),
    ILLEGAL_WORK("Неофіційне працевлаштування", "[data-state='button-employment-2']",
            "//div[@role='menuitem'][@value='2']"),
    FOP("ФОП/самозайнята особа", "[data-state='button-employment-3']", "//div[@role='menuitem'][@value='3']"),
    STUDENT("Студент", "[data-state='button-employment-4']", "//div[@role='menuitem'][@value='4']"),
    PENSIONER("Пенсіонер", "[data-state='button-employment-5']",
            "//div[@role='menuitem'][@value='5']"),
    CIVIL_SERVANT("Держ.службовець", "[data-state='button-employment-6']",
            "//div[@role='menuitem'][@value='6']"),
    POLICE("Правоохоронні органи (МВС, а також суди)", "[data-state='button-employment-7']", "//div[@role='menuitem'][@value='7']"),
    MILITARY("Військовий(-а)", "[data-state='button-employment-8']",
            "//div[@role='menuitem'][@value='8']"),
    MATERNITY_LEAVE("Декретна відпустка", "[data-state='button-employment-9']",
            "//div[@role='menuitem'][@value='9']"),
    HOUSEHOLDER("Домогосподар(-ка)", "[data-state='button-employment-10']",
            "//div[@role='menuitem'][@value='10']"),
    NOT_WORKING("Не працевлаштований(-а)", "[data-state='button-employment-11']",
            "//div[@role='menuitem'][@value='11']"),

    OFFICIAL_MORE_6_MONTH("Official more than 6 month", "[data-state='button-employment-2']", ""),
    OFFICIAL_LESS_6_MONTH("Official less than 6 month", "[data-state='button-employment-4']", "");

    private final String name;
    private final String selector;
    private final String dropdown;

    Employment(String name, String selector, String dropdown) {
        this.name = name;
        this.selector = selector;
        this.dropdown = dropdown;
    }

    public String getDropdown() {
        return dropdown;
    }

    public String getName() {
        return name;
    }

    public String getSelector() {
        return selector;
    }

    public String getDropdownValue() {
        return dropdown.replaceAll("\\D", "");
    }
}
