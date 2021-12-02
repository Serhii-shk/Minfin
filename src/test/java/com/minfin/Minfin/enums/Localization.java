package com.minfin.Minfin.enums;

public enum Localization {
    UA("ua"),
    RU("ru");

    private final String language;

    Localization(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}
