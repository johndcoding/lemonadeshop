package com.johndcoding.lemonadeshop.view.converter;


import com.johndcoding.lemonadeshop.view.controler.CreationClient;

import java.util.HashMap;
import java.util.Map;

public class ConverterFactory {

    private static ConverterFactory instance;

    private Map<String, FormConverter> mapFormConverters;

    private ConverterFactory() {
        mapFormConverters = new HashMap<String, FormConverter>();

        mapFormConverters.put(ClientFormConverter.class.getName(), new ClientFormConverter());
        mapFormConverters.put(CommandeFormConverter.class.getName(), new CommandeFormConverter());
    }

    public static ConverterFactory getInstance() {
        if (instance == null) {
            instance = new ConverterFactory();
        }

        return instance;
    }

    public FormConverter getFormConverter(String className) {
        return mapFormConverters.get(className);
    }

}
