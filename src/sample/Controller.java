package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.collections.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller {
    public VBox vbox;
    @FXML
    void acttable() {

        String sqlQuery = "SELECT * FROM restauranttables;";
        List<Button> buttonlist = new ArrayList<>(); //our Collection to hold newly created Buttons

            for (int i=0; i<10; i++) {
                buttonlist.add(new Button("restaurant"));

            }

            vbox.getChildren().addAll(buttonlist); //then add all your Buttons that you just created

    }
}
