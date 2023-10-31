package saef.presentation.tui.utils;

import saef.core.models.Language;
import saef.usecase.LanguageService;
import saef.usecase.interfaces.ILanguageService;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleUtil {
    private final ILanguageService languageService;

    public ResourceBundleUtil(ILanguageService languageService) {
        this.languageService = languageService;
    }

    public static ResourceBundle getResourceBundle(Locale locale) {
        try {
            return ResourceBundle.getBundle("Message", locale);
        } catch (MissingResourceException e) {
            // Jika resource bundle tidak ditemukan, maka kembalikan null
            return null;
        }
    }
    public String loadBandle(String promt) {
        List<Language> languages = languageService.getAll();
        Locale locale;
        for (var string : languages) {
            locale = new Locale(string.getLanguage(),string.getCountry());
            var bundle = ResourceBundleUtil.getResourceBundle(locale);
            return  bundle.getString(promt);
        }
        return promt;
    }
}
