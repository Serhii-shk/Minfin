package com.minfin.Minfin.enums;

public enum ContactType {
    FRIEND("Друг",  "//div[@role='menuitem'][@value='1']"),
    BROTHER("Брат", "//div[@role='menuitem'][@value='2']"),
    SISTER("Сестра", "//div[@role='menuitem'][@value='3']"),
    FATHER("Батько", "//div[@role='menuitem'][@value='4']"),
    MOTHER("Мати", "//div[@role='menuitem'][@value='5']"),
    GIRLFRIEND("Дівчина", "//div[@role='menuitem'][@value='6']"),
    BOYFRIEND("Хлопець", "//div[@role='menuitem'][@value='7']"),
    WIFE("Дружина", "//div[@role='menuitem'][@value='8']"),
    HUSBAND("Чоловік", "//div[@role='menuitem'][@value='9']"),
    SON("Син", "//div[@role='menuitem'][@value='10']"),
    DAUGHTER("Дочка", "//div[@role='menuitem'][@value='11']"),
    ANOTHER_RELATIVE("Інший родич", "//div[@role='menuitem'][@value='12']"),
    COLLEAGUE("Колега", "//div[@role='menuitem'][@value='13']"),
    CHIEF("Начальник", "//div[@role='menuitem'][@value='14']"),
    ANOTHER("Інший", "//div[@role='menuitem'][@value='15']");

    private final String name;
    private final String dropdown;

    ContactType(String name, String dropdown) {
        this.name = name;
        this.dropdown = dropdown;
    }

    public String getDropdown() {
        return dropdown;
    }

    public String getName() {
        return name;
    }

    public String getDropdownValue() {
        return dropdown.replaceAll("\\D", "");
    }
}
