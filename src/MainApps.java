public class MainApps {

    public static String[] model = new String[10];

    public static void main(String[] args) {
    }

    //show todo list
    public static void showTodoList(){
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if(todo != null ){
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void addTodoList(){

    }

    public static void removeTodoList(){

    }

    public static void viewShowTodoList(){

    }

    public static void viewAddTodoList(){

    }

    public static void viewRemoveTodoList(){

    }
}
