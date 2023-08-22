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

    public static void removeTodoList(){

    }

    public static void viewShowTodoList(){

    }

    public static void viewAddTodoList(){

    }

    public static void viewRemoveTodoList(){

    }
}
