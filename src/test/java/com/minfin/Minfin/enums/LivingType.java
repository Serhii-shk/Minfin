package com.minfin.Minfin.enums;

public enum LivingType {
    OWN_ACCOMMODATION("Власна квартира", "//div[@role='menuitem'][@value='1']"),
    OWN_HOUSE("Власний дім", "//div[@role='menuitem'][@value='2']"),
    LIVE_WITH_RELATIVES("Проживаю у рідних", "//div[@role='menuitem'][@value='3']"),
    LIVE_IN_A_DORMITORY("Проживаю у гуртожитку", "//div[@role='menuitem'][@value='4']"),
    RENT_HOUSING("Орендую житло", "//div[@role='menuitem'][@value='5']");

    private final String name;
    private final String dropdown;

    LivingType(String name, String dropdown) {
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
