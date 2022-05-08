package school.poly.project.pages;
import school.poly.project.users.Cook;

import javax.swing.*;
import java.util.ArrayList;

public class ListPage extends JPanel {

    public static ArrayList<Cook> cookArrayList = new ArrayList<>();
    public static boolean is_update = false;

    public ListPage() {


        showList();
    }


    void listUpdate(){

    }

    private void showList(){

    }



    public static void main(String[] args) {
        new ListPage();
    }
}
