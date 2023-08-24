import java.util.Scanner;

public class MainApps {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

    }

    //show todo list
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if(todo != null ){
                System.out.println(no + ". " + todo);
            }
        }
    }

    //add todo list
    public static void addTodoList(String todo){

        //Cek penuh
        var penuh = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                penuh = false;
                break;
            }
        }

        //jika penuh
        if (penuh){
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambah ke data
        for (var i = 0; i <model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static boolean removeTodoList(Integer number){
        if ((number - 1) >= model.length){
            return false;
        }
        if (model[number - 1] == null){
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    public static String input(String info){
        System.out.print(info + " : ");
        String data =scanner.nextLine();
        return data;
    }

    public static void viewShowTodoList(){
        while (true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("x. KELUAR");

            var input = input("PILIH ");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("GAK USAH NGIDE");
            }
        }
    }

    public static void viewAddTodoList(){

    }

    public static void viewRemoveTodoList(){

    }
}
