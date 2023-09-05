package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("\nTODOLIST");
        System.out.println("--------------------");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;
            if(todo != null ){
                System.out.println(no + ". " + todo);
            }
        }
        System.out.println("--------------------");
    }

    @Override
    public void addTodoList(String todo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTodoList'");
    }

    @Override
    public void removeTodoList(Integer number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTodoList'");
    }
    
}
