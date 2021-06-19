/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkprojem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ilkprojem.loading.loading;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Yavuz Sinan
 */
public class Ilkprojem extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        loading root = new loading();
        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResourceAsStream("logo.png"));
        stage.getIcons().add(icon);
        stage.setTitle("Chess Timer");
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
