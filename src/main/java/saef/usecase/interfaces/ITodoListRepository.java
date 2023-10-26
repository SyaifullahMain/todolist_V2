package saef.usecase.interfaces;


import saef.core.models.TodoList;

import java.util.List;

public interface ITodoListRepository {
    List<TodoList> getAll();
    void add(TodoList todoList);

    void remove(Integer number);
}
