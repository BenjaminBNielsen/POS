/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.control;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import pos.model.Product;
import pos.model.Register;
import pos.model.Storage;
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
    @FXML
    private TextField idInput;
    private Register register = new Register();

    public BasketOverviewController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/basket_overview.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
    }

    @FXML
    public void addToBasket(ActionEvent event) {
        int id = Integer.parseInt(idInput.getText());
        Product p = register.getBasket().addProduct(id);
        boolean exists = false;
        for (BasketItem b : productList.getItems()) {
            if(b.getType().getId() == p.getType().getId()){
                b.incrementAmount();
                exists = true;
                break;
            }
        }
        if(!exists){
            BasketItem b1 = new BasketItem(p.getType(), this);
            productList.getItems().add(b1);
        
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void removeItem(BasketItem basketItem) {
        productList.getItems().remove(basketItem);
    }

    public ListView<BasketItem> getProductList() {
        return productList;
    }

    public void setProductList(ListView<BasketItem> productList) {
        this.productList = productList;
    }

    public Register getRegister() {
        return register;
    }

}
