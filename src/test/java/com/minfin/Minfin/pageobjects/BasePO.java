package com.minfin.Minfin.pageobjects;

import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BasePO {
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static int randomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void clearText(String cssSelector) {
        $(cssSelector).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        int reactResponse = 300;
        sleep(reactResponse);
    }

    public static Object decode(Object jv) {
        if (jv instanceof Boolean) {
            return ((Boolean) jv).booleanValue();
        }
        return false;
    }
}
