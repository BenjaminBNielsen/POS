/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pos.control.RegisterInputController;

/**
 *
 * @author chrisjust
 */
public class Main extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RegisterInputController ric = new RegisterInputController();
        Scene scene = new Scene(ric);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
