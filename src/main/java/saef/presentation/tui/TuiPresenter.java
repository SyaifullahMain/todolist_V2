package saef.presentation.tui;

import saef.core.interfaces.IPresenter;
import saef.core.models.Language;
import saef.core.models.TodoList;
import saef.presentation.tui.menu.ExitMenu;
import saef.presentation.tui.menu.Menu;
import saef.presentation.tui.menu.MenuBase;
import saef.presentation.tui.menu.language.LanguageMenu;
import saef.presentation.tui.menu.todo.AddTodoMenu;
import saef.presentation.tui.menu.todo.RemoveTodoMenu;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.RenderTodo;
import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.usecase.interfaces.ILanguageService;
import saef.usecase.interfaces.ITodoListService;

import java.util.List;

public class TuiPresenter implements IPresenter {
    private final InputUtil scanner;
    private final ResourceBundleUtil bundle;
    private final ILanguageService languageService;
    private final ITodoListService todoListService;
    public TuiPresenter(InputUtil scanner, ITodoListService todoListService, ResourceBundleUtil bundle, ILanguageService languageService) {
        this.scanner = scanner;
        this.todoListService = todoListService;
        this.bundle = bundle;
        this.languageService = languageService;
    }

    @Override
    public boolean showMainMenu() {
        while (true) {
            List<TodoList> lists = todoListService.getAll();
            System.out.println(bundle.loadBandle("application"));
            RenderTodo.renderTodo(lists);
            boolean shouldContinue = Menu.showMenu(scanner, bundle.loadBandle("mainMenu"), bundle.loadBandle("selectMenu"), new MenuBase[]{
                    new AddTodoMenu(scanner, todoListService, bundle),
                    new RemoveTodoMenu(scanner, todoListService, bundle),
                    new LanguageMenu(scanner, languageService, bundle),
                    new ExitMenu(bundle)
            });
            if (shouldContinue) continue;
            return true;
        }

    }
}
