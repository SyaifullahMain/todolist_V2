package view;

import java.io.IOException;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    
    private TodoListService todoListService;
    

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList(){
        while (true) {
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("x. KELUAR");

            var input = InputUtil.input("PILIH ");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("GAK USAH NGIDE");
            }
        }
    }

    public void addTodoList(){
        System.out.println("\nMENAMBAH");
        var todo = InputUtil.input("Todo (x jika batal)");

        if (todo.equals("x")) {
            //batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList(){
        String onlyNumber = "^[0-9]*$";

        System.out.println("\nHAPUS");
        var number = InputUtil.input("NOMOR (x jika batal)");
        boolean cekInt = true;
        if (number.equalss("x")){
            //batal2
        } else if (!number.matches(onlyNumber)){
            System.out.println("Gak usah ngide");
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
