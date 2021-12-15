package com.minfin.Minfin.enums;

public enum EducationDegree {
    INCOMPLETE_SECONDARY("incomplete secondary", "//div[@role='menuitem'][@value='1']"),
    SECONDARY("secondary", "//div[@role='menuitem'][@value='2']"),
    SECONDARY_SPECIAL("secondary special", "//div[@role='menuitem'][@value='3']"),
    INCOMPLETE_HIGHER("incomplete higher", "//div[@role='menuitem'][@value='4']"),
    HIGHER("higher", "//div[@role='menuitem'][@value='5']"),
    TWO_HIGHER("two or more higher", "//div[@role='menuitem'][@value='6']"),
    ACADEMIC_DEGREE("academic defree", "//div[@role='menuitem'][@value='7']");

    private final String name;
    private final String dropdown;

    EducationDegree(String name, String dropdown) {
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
