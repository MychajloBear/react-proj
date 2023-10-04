package de.ukrainewin.store.service;

public class LocalizationService {
    public String getLocalizedString(String key) {
        if (key.equals("header")) {
            return "TestHeaderFromBackendLocalizationService";
        }
        return null;

    }
}