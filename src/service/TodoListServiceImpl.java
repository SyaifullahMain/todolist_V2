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
                System.out.println(no + ". " + todo.getTodo());
            }
        }
        System.out.println("--------------------");
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        // System.out.println("Sukse cuy "+ todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean succes = todoListRepository.remove(number);
        if (succes) {
            System.out.println("sukses cuy "+ number);
        } else{
            System.out.println("gagal cuy " + number);
        }
    }
    
}
