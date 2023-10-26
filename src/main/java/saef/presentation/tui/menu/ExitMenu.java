package saef.presentation.tui.menu;

import saef.presentation.tui.utils.ScreenUtil;

public class ExitMenu extends MenuBase{
    public ExitMenu() {
        super("Exit");
    }

    @Override
    public boolean handle() {
        ScreenUtil.clearScreen();
        System.out.println("Have a good day! :)");
        System.exit(0);
        return false;
    }
}
