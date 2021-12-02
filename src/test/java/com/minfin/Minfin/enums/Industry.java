package com.minfin.Minfin.enums;

public enum Industry {
    AGRICULTURE_FISHERIES_FORESTRY("Сільське, рибне та лісове господарство", "//div[@role='menuitem'][@value='1']"),
    MECHANICAL_ENGINEERING_METALLURGY("Машинобудування та металургія", "//div[@role='menuitem'][@value='2']"),
    FOOD_INDUSTRY_AGRICULTURAL_PROCESSING("Харчова промисловість та сільхозпереробка", "//div[@role='menuitem'][@value='3']"),
    PENSIONER("pensioner", "//div[@role='menuitem'][@value='5']"),
    CIVIL_SERVANT("civil servant", "//div[@role='menuitem'][@value='6']"),
    POLICE("police", "//div[@role='menuitem'][@value='7']"),
    MILITARY("military", "//div[@role='menuitem'][@value='8']"),
    MATERNITY_LEAVE("Maternity leave", "//div[@role='menuitem'][@value='9']"),
    HOUSEHOLDER("Maternity leave", "//div[@role='menuitem'][@value='10']"),
    NOT_WORKING("Not working", "//div[@role='menuitem'][@value='11']"),

    OFFICIAL_MORE_6_MONTH("Official more than 6 month", ""),
    OFFICIAL_LESS_6_MONTH("Official less than 6 month", "");

    private final String name;
    private final String dropdown;

    Industry(String name, String dropdown) {
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
