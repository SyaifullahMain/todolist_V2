package saef.presentation.tui.menu;

import saef.presentation.tui.utils.ResourceBundleUtil;

public class MenuBase {
    public String menu;

    private final ResourceBundleUtil bundle;
    public MenuBase(String menu, ResourceBundleUtil bundle) {
        this.menu = menu;
        this.bundle = bundle;
    }
    public boolean handle() {
        System.out.println(bundle.loadBandle("noHandle") + " : " + menu);
        return false;
    }
}
