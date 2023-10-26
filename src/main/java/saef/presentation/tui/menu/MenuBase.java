package saef.presentation.tui.menu;

public class MenuBase {
    public String menu;

    public MenuBase(String menu) {
        this.menu = menu;
    }
    public boolean handle() {
        System.out.println("No handler for menu: " + menu);
        return false;
    }
}
