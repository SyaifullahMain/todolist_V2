package saef.presentation.tui.menu.todo;

import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.usecase.interfaces.ITodoListService;
import saef.presentation.tui.utils.ScreenUtil;

import java.text.MessageFormat;

public class RemoveTodoMenu extends MenuBase {
    private final InputUtil scanner;
    private final ITodoListService todoListService;
    private final ResourceBundleUtil bundle;

    public RemoveTodoMenu(InputUtil scanner, ITodoListService todoListService, ResourceBundleUtil bundle) {
        super(bundle.loadBandle("removeTodo"), bundle);
        this.scanner = scanner;
        this.todoListService = todoListService;
        this.bundle = bundle;
    }

    @Override
    public boolean handle() {
        System.out.println("-- " + bundle.loadBandle("removeTodo") + " --");
        int id = scanner.getNonEmptyPositiveInteger(bundle.loadBandle("removeById") + " : ");
        try {
            todoListService.removeTodoList(id);
            ScreenUtil.clearScreen();
            var pattern = bundle.loadBandle("succesRemove");
            var messageFormat = new MessageFormat(pattern);
            var format = messageFormat.format(new Object[]{id});
            System.out.println(format);
        } catch (Exception e) {
            System.out.println(bundle.loadBandle("failedRemove"));
        }
        return true;
    }
}
