package com.minfin.Minfin.enums;

public enum MaritalStatus {
    UNMARRIED("Unmarried", "//div[@role='menuitem'][@value='1']"),
    COHABITATION("Сohabitation", "//div[@role='menuitem'][@value='2']"),
    ENGAGED("Engaged", "//div[@role='menuitem'][@value='3']"),
    MARRIED("Married", "//div[@role='menuitem'][@value='4']"),
    SEPARATE_ACCOMMODATION("Married", "//div[@role='menuitem'][@value='5']"),
    DIVORCED("divorced", "//div[@role='menuitem'][@value='6']"),
    WIDOWER("widower", "//div[@role='menuitem'][@value='7']");

    private final String name;
    private final String dropdown;

    MaritalStatus(String name, String dropdown) {
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
