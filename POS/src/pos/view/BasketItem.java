/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.view;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pos.model.Type;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class BasketItem extends HBox {
    @FXML
    private TextField productDesc;
    
    
    public BasketItem(Type type) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/basket_item.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        productDesc.setText(type.getId()+" - "+type.getDesc());
        
    }   
    
}
