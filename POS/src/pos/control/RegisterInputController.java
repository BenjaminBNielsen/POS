/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import pos.model.Register;

/**
 * FXML Controller class
 *
 * @author ut
 */
public class RegisterInputController extends BorderPane implements Initializable {
    private Register register = new Register();
    
    @FXML
    private TextField productInput;
    
    @FXML
    public void submitProductInput(ActionEvent event){
        try{
            int id = Integer.parseInt(productInput.getText());
            register.getBasket().addProduct(id);
        }catch(NumberFormatException ex){
            ex.printStackTrace();
        }
        productInput.clear();
    }

    public RegisterInputController() {
        try{            
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("../view/register_input.fxml"));
            fXMLLoader.setRoot(this);
            fXMLLoader.setController(this);
            fXMLLoader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
