package com.minfin.Minfin.enums;

public enum Position {
    WORKER("Робітник", "//div[@role='menuitem'][@value='1']"),
    SPECIALIST("Спеціаліст", "//div[@role='menuitem'][@value='2']"),
    EMPLOYEE("Службовець", "//div[@role='menuitem'][@value='3']"),
    MANAGER("Керівник", "//div[@role='menuitem'][@value='4']"),
    SENIOR_MANAGER("Керівник вищої ланки", "//div[@role='menuitem'][@value='5']");

    private final String name;
    private final String dropdown;

    Position(String name, String dropdown) {
        this.name = name;
        this.dropdown = dropdown;
    }

    public String getName() {
        return name;
    }

    public String getDropdown() {
        return dropdown;
    }

    public String getDropdownValue() {
        return dropdown.replaceAll("\\D", "");
    }
}
