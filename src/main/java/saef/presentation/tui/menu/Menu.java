package saef.presentation.tui.menu;

import saef.presentation.tui.utils.InputUtil;

public class Menu {
    public static boolean showMenu(InputUtil scanner, String title, MenuBase[] menus) {
        System.out.println(title);
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%d. %s\n", i + 1, menus[i].menu);
        }
        int selectedMenu = scanner.getNonEmptyPositiveInteger("Select menu: ");
        return menus[selectedMenu - 1].handle();
    }
}
