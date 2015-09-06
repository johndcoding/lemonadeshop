package com.johndcoding.lemonadeshop.view.lang;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LangUtil {

    private final static String DEFAULT_RESSOURCE = "app";


    public static String getMessage(Locale locale, String key, Object... params) {

        final ResourceBundle bundle = ResourceBundle.getBundle(DEFAULT_RESSOURCE, locale);

        return MessageFormat.format(bundle.getString(key), params);
    }


}
