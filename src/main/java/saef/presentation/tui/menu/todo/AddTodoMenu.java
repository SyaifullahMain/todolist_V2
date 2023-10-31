package saef.presentation.tui.menu.todo;

import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.usecase.interfaces.ITodoListService;
import saef.presentation.tui.utils.ScreenUtil;

public class AddTodoMenu extends MenuBase {
    private final InputUtil scanner;
    private final ITodoListService todoListService;
    private final ResourceBundleUtil bundle;

    public AddTodoMenu(InputUtil scanner, ITodoListService todoListService, ResourceBundleUtil bundle) {
        super(bundle.loadBandle("addTodo" ), bundle);
        this.scanner = scanner;
        this.todoListService = todoListService;
        this.bundle = bundle;
    }

    @Override
    public boolean handle() {
        System.out.println("-- " + bundle.loadBandle("addTodo" ) + " --");
        String todo = scanner.getNonEmptyString( bundle.loadBandle("inputTodo" ) + " : ");
        try {
            todoListService.addTodoList(todo);
            ScreenUtil.clearScreen();
            System.out.println(bundle.loadBandle("succesTodo" ));
        } catch (Exception e) {
            System.out.println(bundle.loadBandle("failedTodo" ));
        }
        return true;
    }
}
