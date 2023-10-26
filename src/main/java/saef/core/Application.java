package saef.core;

import saef.core.interfaces.IPresenter;

public class Application {
    private final IPresenter ui;

    public Application(IPresenter presenter) {
        this.ui = presenter;
    }

    public void run() {
        while (true) {
            boolean shouldContinue = ui.showMainMenu();
            if (shouldContinue) continue;
            break;
        }
    }
}
