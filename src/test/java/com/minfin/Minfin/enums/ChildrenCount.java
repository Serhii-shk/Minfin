package com.minfin.Minfin.enums;

public enum ChildrenCount {
    NO_CHILDREN("no children", "//div[@role='menuitem'][@value='1']"),
    ONE("one children", "//div[@role='menuitem'][@value='2']"),
    TWO("two children", "//div[@role='menuitem'][@value='3']"),
    THREE("three children", "//div[@role='menuitem'][@value='4']"),
    FOUR("four children", "//div[@role='menuitem'][@value='5']"),
    FIVE("five children", "//div[@role='menuitem'][@value='6']"),
    SIX("six children", "//div[@role='menuitem'][@value='7']"),
    SEVEN("seven children", "//div[@role='menuitem'][@value='8']"),
    EIGHT("eight children", "//div[@role='menuitem'][@value='9']"),
    NINE("nine children", "//div[@role='menuitem'][@value='10']"),
    TEN("ten children", "//div[@role='menuitem'][@value='11']");

    private final String name;
    private final String dropdown;

    ChildrenCount(String name, String dropdown) {
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
