package saef.presentation.tui.menu.todo;

import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.utils.InputUtil;
import saef.usecase.interfaces.ITodoListService;
import saef.presentation.tui.utils.ScreenUtil;

public class AddTodoMenu extends MenuBase {
    private final InputUtil scanner;
    private final ITodoListService todoListService;

    public AddTodoMenu(InputUtil scanner, ITodoListService todoListService) {
        super("Add todo");
        this.scanner = scanner;
        this.todoListService = todoListService;
    }

    @Override
    public boolean handle() {
        System.out.println("-- Add todo --");
        String todo = scanner.getNonEmptyString("Input todo : ");
        try {
            todoListService.addTodoList(todo);
            ScreenUtil.clearScreen();
            System.out.println("New todo has been successfully added!");
        } catch (Exception e) {
            System.out.println("Failed to add!");
        }
        return true;
    }
}
