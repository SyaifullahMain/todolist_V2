package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    
    public static void main(String[] args) {
        // testShowTodoList();
        // testAddTodoList();
        testRemoveTodoList();
    }

    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        // TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        // todoListRepository.data[0] = new TodoList("Belajar");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("satu");
        todoListService.addTodoList("satu");
        todoListService.addTodoList("satu");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("satu");
        todoListService.addTodoList("satu");
        todoListService.addTodoList("satu");

        todoListService.showTodoList();

        todoListService.removeTodoList(6);
    }
}
