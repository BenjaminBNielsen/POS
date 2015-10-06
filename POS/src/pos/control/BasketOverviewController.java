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
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import pos.model.Type;
import pos.view.BasketItem;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class BasketOverviewController extends BorderPane implements Initializable {

    @FXML
    private ListView<BasketItem> productList;
    
    public BasketOverviewController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/basket_overview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
            fxmlLoader.load();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @FXML
    public void addToBasket(ActionEvent event){
        Type type = new Type(100,1,"Banana");
        BasketItem item = new BasketItem(type, this.productList);
        productList.getItems().add(item);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void removeItem(BasketItem basketItem){
        productList.getItems().remove(basketItem);
    }
    
    
}
