package school.poly.recipe_project.messageBox;

import javax.swing.*;
import java.awt.*;

/**
 * @author TaeWK
 */
public class ErrorBox{

    public ErrorBox(String message,JPanel frame){
        JOptionPane.showMessageDialog(frame,message);
    }


    public ErrorBox(String message, Container topLevelAncestor) {
        JOptionPane.showMessageDialog(topLevelAncestor,message);
    }
}
