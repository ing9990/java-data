package school.poly.project.messageBox;

import school.poly.project.RecipeMainApplication;

import javax.swing.*;

/**
 * @author TaeWK
 */
public class ErrorBox{

    public ErrorBox(String message,JPanel frame){
        JOptionPane.showMessageDialog(frame,message);
    }


}
