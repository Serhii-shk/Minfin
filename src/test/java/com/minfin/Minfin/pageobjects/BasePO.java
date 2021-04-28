package com.minfin.Minfin.pageobjects;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

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
}
