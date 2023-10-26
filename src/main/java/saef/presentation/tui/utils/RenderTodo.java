package saef.presentation.tui.utils;

import saef.core.models.TodoList;

import java.util.List;

public class RenderTodo {
    public static void renderTodo(List<TodoList> todoLists) {
        for (var todoList : todoLists) {
            System.out.println(todoList.getId() + ". " + todoList.getTodo());
        }
    }
}
