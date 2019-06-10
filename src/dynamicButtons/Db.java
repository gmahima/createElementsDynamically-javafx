package dynamicButtons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mpawlan
 */
public class Db extends Application {

    Label text, clicked;
    Button button, clickButton;
    VBox BPane;

    @Override
    public void start (Stage primaryStage) {
        //Create GridPane
        BPane = new VBox();
        BPane.setId("grid-pane");

        //Create Scene and add Grid
        Scene Scene = new Scene(BPane, 300, 200);
        //Create the stage and add the scene
        primaryStage.setTitle("dynamic buttons");
        primaryStage.setScene(Scene);

        text = new Label("generate buttons");
        button = new Button("Click Me");
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object source = event.getSource();
                String s = null;
                //Variable to display text read from file

                    FileInputStream in = null;
                    try {
                        //Code to write to file
                        //Clear text field
                        //Code to read from file
                        String inputFileName = "/home/mahima/Data/buttons.txt";
                        File inputFile = new File(inputFileName);
                        in = new FileInputStream(inputFile);
                        byte bt[] = new byte[(int) inputFile.length()];
                        in.read(bt);
                        s = new String(bt);
                        in.close();
                    } catch (java.io.IOException e) {
                        System.out.println("Cannotss text.txt");
                    } finally {
                        try {
                            in.close();

                        } catch (java.io.IOException e) {
                            System.out.println("Cannote");
                        }
                    }
                    //Display text read from file
                    text.setText("Text retrieved from file: \n\n" + s);
                    String lines[] = s.split("\\r?\\n");
                    for (int i=0; i<lines.length; i++) {
                        System.out.println(i + lines[i]);
                        BPane.getChildren().add(new Button(lines[i])) ;
                        primaryStage.show();

                    }



                    button.setText("Click Again");



            }
        });

        //Set positions for each control in the BorderPane
        BPane.getChildren().addAll(text, button);

        //Show the scene
        primaryStage.show();
    }

    //main method
    public static void main(String[] args){
        launch(args);
    }
}