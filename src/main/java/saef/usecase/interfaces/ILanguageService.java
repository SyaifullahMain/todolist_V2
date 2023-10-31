package saef.usecase.interfaces;

import saef.core.models.Language;

import java.util.List;

public interface ILanguageService {
    List<Language> getAll();
    void edit(String language, String country);
}
