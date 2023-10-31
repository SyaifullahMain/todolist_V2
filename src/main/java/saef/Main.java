package saef;


import com.zaxxer.hikari.HikariDataSource;
import saef.core.Application;
import saef.core.interfaces.IPresenter;
import saef.presentation.tui.TuiPresenter;
import saef.presentation.tui.utils.DatabaseUtil;
import saef.presentation.tui.utils.InputUtil;
import saef.presentation.tui.utils.ResourceBundleUtil;
import saef.repository.LanguageRepository;
import saef.repository.TodoListRepository;
import saef.usecase.LanguageService;
import saef.usecase.TodoListService;
import saef.usecase.interfaces.ILanguageRepository;
import saef.usecase.interfaces.ILanguageService;
import saef.usecase.interfaces.ITodoListRepository;
import saef.usecase.interfaces.ITodoListService;

public class Main {
    public static void main(String[] args) {

            HikariDataSource dataSource = DatabaseUtil.getHikariDataSource();
            ITodoListRepository todoListRepository = new TodoListRepository(dataSource);
            ITodoListService todoListService = new TodoListService(todoListRepository);

            IPresenter presenter = getPresenter(dataSource, todoListService);
            Application app = new Application(presenter);
            app.run();

    }

        private static IPresenter getPresenter(HikariDataSource dataSource, ITodoListService todoListService) {
                ILanguageRepository languageRepository = new LanguageRepository(dataSource);
                ILanguageService languageService = new LanguageService(languageRepository);
                ResourceBundleUtil bundleUtil = new ResourceBundleUtil(languageService);
                InputUtil scanner = new InputUtil(System.in, bundleUtil);
                ResourceBundleUtil bundle = new ResourceBundleUtil(languageService);
            return new TuiPresenter(scanner, todoListService, bundle, languageService);
        }

}
