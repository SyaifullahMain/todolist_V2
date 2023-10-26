package saef.presentation.tui.menu.todo;

import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.utils.InputUtil;
import saef.usecase.interfaces.ITodoListService;
import saef.presentation.tui.utils.ScreenUtil;

public class RemoveTodoMenu extends MenuBase {
    private final InputUtil scanner;
    private final ITodoListService todoListService;

    public RemoveTodoMenu(InputUtil scanner, ITodoListService todoListService) {
        super("Remove Todo");
        this.scanner = scanner;
        this.todoListService = todoListService;
    }

    @Override
    public boolean handle() {
        System.out.println("-- Remove todo --");
        int id = scanner.getNonEmptyPositiveInteger("Remove by id : ");
        try {
            todoListService.removeTodoList(id);
            ScreenUtil.clearScreen();
            System.out.println("Todo with a id of \" + id + \" has been removed!");
        } catch (Exception e) {
            System.out.println("Failed to remove!");
        }
        return true;
    }
}
