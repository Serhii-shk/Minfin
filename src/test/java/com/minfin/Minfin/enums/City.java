package com.minfin.Minfin.enums;

public enum City {
    KYIV("Київ", "Киев", "[data-state='button-city-Київ']", "[for='registrationPlace-option-0']",
            "Київ"),
    ZAPORIZHZHYA("Запоріжжя", "Запорожье", "[data-state='button-city-Запоріжжя']",
            "[for='registrationPlace-option-5']", "Запоріжжя"),
    LVIV("Львів", "Львов", "[data-state='button-city-Львів']", "[for='registrationPlace-option-2']",
            "Львів"),
    ODESA("Одеса", "Одесса", "[data-state='button-city-Одеса']",
            "[for='registrationPlace-option-3']", "Одеса"),
    DNIPRO("Дніпро", "Днепр", "[data-state='button-city-Дніпро']",
            "[for='registrationPlace-option-1']", "Дніпро"),
    KHARKIV("Харків", "Харьков", "[data-state='button-city-Харків']",
            "[for='registrationPlace-option-4']", "Харків"),
    NEMISHAEVE("Немішаєве", "Немишаево", "", "", "Немішаєве, Київська область");

    private final String nameUa;
    private final String nameRu;
    private final String selector;
    private final String osagoSelector;
    private final String dropdown;

    City(String nameUa, String nameRu, String selector, String osagoSelector, String dropdown) {
        this.nameUa = nameUa;
        this.nameRu = nameRu;
        this.selector = selector;
        this.dropdown = dropdown;
        this.osagoSelector = osagoSelector;
    }

    public String getDropdown() {
        return dropdown;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getNameRu() {
        return nameRu;
    }

    public String getSelector() {
        return selector;
    }

    public String getWizardFilterTextUa() {
        return nameUa;
    }

    public String getWizardFilterTextRu() {
        return nameRu;
    }
}
