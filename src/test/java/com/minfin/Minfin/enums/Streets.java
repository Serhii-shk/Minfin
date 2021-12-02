package com.minfin.Minfin.enums;

public enum Streets {
    ZAVODSKA_NIEMISHAEVE("вулиця Заводська", "вулиця Заводська"),
    KHRESCHATYK_KYIV("вулиця Хрещатик", "вулиця Хрещатик");

    private final String name;
    private final String dropdown;

    Streets(String name, String dropdown) {
        this.name = name;
        this.dropdown = dropdown;
    }

    public String getDropdown() {
        return dropdown;
    }

    public String getName() {
        return name;
    }
}
