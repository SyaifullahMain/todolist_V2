package saef.presentation.tui.menu;

import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.presentation.tui.utils.ScreenUtil;

public class ExitMenu extends MenuBase{
    private final ResourceBundleUtil bundle;
    public ExitMenu(ResourceBundleUtil bundle) {
        super(bundle.loadBandle("exit" ), bundle);
        this.bundle = bundle;
    }

    @Override
    public boolean handle() {
        ScreenUtil.clearScreen();
        System.out.println(bundle.loadBandle("messageExit" ));
        System.exit(0);
        return false;
    }
}
