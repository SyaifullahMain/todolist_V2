package saef.usecase.interfaces;


import saef.core.models.TodoList;

import java.util.List;

public interface ITodoListService {
    List<TodoList> getAll();

    void addTodoList(String todo);

    void removeTodoList(Integer number);
}
