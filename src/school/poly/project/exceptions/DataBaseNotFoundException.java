package school.poly.project.exceptions;


import school.poly.project.messageBox.ErrorBox;

import javax.swing.*;
import java.sql.SQLException;

public class DataBaseNotFoundException extends SQLException{

    public static final String ERROR_MESSAGE = "데이터베이스를 찾을 수 없습니다.";

    public DataBaseNotFoundException(JPanel recipeMainApplication) {
        System.out.println(recipeMainApplication);
        eb(recipeMainApplication);
    }

    private ErrorBox eb(JPanel frame){
        System.out.println(ERROR_MESSAGE);
        return new ErrorBox(ERROR_MESSAGE,frame);
    }
}
