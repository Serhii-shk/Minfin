package com.minfin.Minfin.ui.pageobjects;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

public class BasePO {

    public File getFileFromResource(String fileName)  {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    public static String getRandomPhoneNumber() {
        return "38000" + ThreadLocalRandom.current().nextLong(9100000L, 9109999L);
    }

    public static String getLicensesNumber() {
        return "123" + ThreadLocalRandom.current().nextLong(91000000L, 91099999L);
    }


}
