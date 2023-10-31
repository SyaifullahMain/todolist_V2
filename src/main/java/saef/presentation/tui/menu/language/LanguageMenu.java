package saef.presentation.tui.menu.language;

import saef.core.models.Language;
import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.usecase.interfaces.ILanguageService;

public class LanguageMenu extends MenuBase {
    private final InputUtil scanner;
    private final ILanguageService languageService;
    private final ResourceBundleUtil bundle;

    public LanguageMenu(InputUtil scanner,  ILanguageService languageService, ResourceBundleUtil bundle) {
        super(bundle.loadBandle("language"), bundle);
        this.scanner = scanner;
        this.languageService = languageService;
        this.bundle = bundle;
    }

    @Override
    public boolean handle() {
        System.out.println(bundle.loadBandle("selectLanguage"));
        System.out.println("1. Indonesian");
        System.out.println("2. English");
        int id = scanner.getNonEmptyPositiveInteger(bundle.loadBandle("selectMenu") +" : ");
        if (id == 1) languageService.edit("in","ID");
        else languageService.edit("en","US");
        return  true;
    }
}
