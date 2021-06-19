/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkprojem.loading;

import ilkprojem.FXMLDocumentController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Yavuz Sinan
 */
public class loading extends AnchorPane {
    
    public loading() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loading.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    @FXML
    private void initialize() {
    }
    @FXML
    void login (ActionEvent event){
        Scene scene = this.getScene();
        try {
            Parent root = FXMLLoader.load(FXMLDocumentController.class.getResource("FXMLDocument.fxml"));
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(loading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
