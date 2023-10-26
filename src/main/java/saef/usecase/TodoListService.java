package saef.usecase;

import saef.core.models.TodoList;
import saef.usecase.interfaces.ITodoListRepository;
import saef.usecase.interfaces.ITodoListService;

import java.util.List;

public class TodoListService implements ITodoListService {
    private final ITodoListRepository todoListRepository;

    public TodoListService(ITodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoList> getAll() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        todoListRepository.add(new TodoList(todo));
    }

    @Override
    public void removeTodoList(Integer number) {
        todoListRepository.remove(number);
    }
}
