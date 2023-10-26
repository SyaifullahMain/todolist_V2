package saef;


import com.zaxxer.hikari.HikariDataSource;
import saef.core.Application;
import saef.core.interfaces.IPresenter;
import saef.presentation.tui.TuiPresenter;
import saef.presentation.tui.utils.DatabaseUtil;
import saef.presentation.tui.utils.InputUtil;
import saef.repository.TodoListRepository;
import saef.usecase.TodoListService;
import saef.usecase.interfaces.ITodoListRepository;
import saef.usecase.interfaces.ITodoListService;

public class Main {
    public static void main(String[] args) {
        HikariDataSource dataSource = DatabaseUtil.getHikariDataSource();
        ITodoListRepository todoListRepository = new TodoListRepository(dataSource);
        ITodoListService todoListService = new TodoListService(todoListRepository);
        InputUtil scanner = new InputUtil(System.in);
        IPresenter presenter = new TuiPresenter(scanner, todoListService);
        Application app = new Application(presenter);
        app.run();
    }

}
