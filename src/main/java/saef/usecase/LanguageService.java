package saef.usecase;

import saef.core.models.Language;
import saef.usecase.interfaces.ILanguageRepository;
import saef.usecase.interfaces.ILanguageService;

import java.util.List;

public class LanguageService implements ILanguageService {
    private final ILanguageRepository languageRepository;

    public LanguageService(ILanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void edit(String language, String country) {
        languageRepository.edit(language,country);
    }
}
