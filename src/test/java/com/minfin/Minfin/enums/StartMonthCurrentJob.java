package com.minfin.Minfin.enums;

public enum StartMonthCurrentJob {
    ONE("01", "//div[@role='menuitem'][@value='1']"),
    TWO("02", "//div[@role='menuitem'][@value='2']"),
    THREE("03", "//div[@role='menuitem'][@value='3']"),
    FOUR("04", "//div[@role='menuitem'][@value='4']"),
    FIVE("05", "//div[@role='menuitem'][@value='5']"),
    SIX("06", "//div[@role='menuitem'][@value='6']"),
    SEVEN("07", "//div[@role='menuitem'][@value='7']"),
    EIGHT("08", "//div[@role='menuitem'][@value='8']"),
    NINE("09", "//div[@role='menuitem'][@value='9']"),
    TEN("10", "//div[@role='menuitem'][@value='10']"),
    ELEVEN("11", "//div[@role='menuitem'][@value='11']"),
    TWELVE("12", "//div[@role='menuitem'][@value='12']");

    private final String name;
    private final String dropdown;

    StartMonthCurrentJob(String name, String dropdown) {
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
