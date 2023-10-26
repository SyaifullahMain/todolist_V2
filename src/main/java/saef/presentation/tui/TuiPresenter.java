package saef.presentation.tui;

import saef.core.interfaces.IPresenter;
import saef.core.models.TodoList;
import saef.presentation.tui.menu.ExitMenu;
import saef.presentation.tui.menu.Menu;
import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.menu.todo.AddTodoMenu;
import saef.presentation.tui.menu.todo.RemoveTodoMenu;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.RenderTodo;
import saef.usecase.interfaces.ITodoListService;

import java.util.List;

public class TuiPresenter implements IPresenter {
    private final InputUtil scanner;

    private final ITodoListService todoListService;
    public TuiPresenter(InputUtil scanner, ITodoListService todoListService) {
        this.scanner = scanner;
        this.todoListService = todoListService;
    }

    @Override
    public boolean showMainMenu() {
        while (true) {
            List<TodoList> lists = todoListService.getAll();
            System.out.println("TODOLIST APP");
            RenderTodo.renderTodo(lists);
            boolean shouldContinue = Menu.showMenu(scanner, "TodoList Main Menu", new MenuBase[]{
                    new AddTodoMenu(scanner, todoListService),
                    new RemoveTodoMenu(scanner, todoListService),
                    new ExitMenu()
            });
            if (shouldContinue) continue;
            return true;
        }

    }
}
