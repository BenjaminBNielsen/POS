/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import pos.control.BasketOverviewController;
import pos.model.Type;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class BasketItem extends HBox {

    public static final String AMOUNT_SUB = " stk";
    public static final String PRICE_SUB = " ,-";
    private BasketOverviewController controller;
    private Type type;

    public Type getType() {
        return type;
    }

    @FXML
    private TextField productDesc, priceField, amountField;
    private SimpleStringProperty amountProperty;
    private SimpleStringProperty priceProperty;

    public BasketItem(Type type, BasketOverviewController controller) {
        this(type);
        this.controller = controller;
    }

    public BasketItem(Type type) {
        this.type = type;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/basket_item.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.amountProperty = new SimpleStringProperty(1 + AMOUNT_SUB);
        this.priceProperty = new SimpleStringProperty(type.getPrice() + PRICE_SUB);

        priceField.promptTextProperty().bindBidirectional(priceProperty);
        priceField.setDisable(true);

        productDesc.setText(type.getId() + " - " + type.getDesc());

        amountProperty.addListener(e -> {
            priceProperty.set(getAmount() * type.getPrice() + PRICE_SUB);
            controller.getRegister().getBasket().setAmount(getAmount(), type);
            System.out.println(controller.getRegister().getBasket().getItems());
        });
        amountField.promptTextProperty().bindBidirectional(amountProperty);
        amountField.setOnAction(e -> {
            amountProperty.set(amountField.getText() + AMOUNT_SUB);
            amountField.setText("");
            amountField.getParent().requestFocus();
            
        });

    }

    public void setAmount(int amount) {
        this.amountProperty.set(amount + AMOUNT_SUB);
    }

    public void incrementAmount() {
        this.amountProperty.set((getAmount() + 1) + AMOUNT_SUB);
    }

    public int getAmount() {
        return parseFromString(amountProperty.getValue(), AMOUNT_SUB);
    }

    private int parseFromString(String value, String sub) {
        return Integer.parseInt(value.substring(0, value.length() - sub.length()));
    }

    @FXML
    private void incrementItem(ActionEvent event) {
        amountProperty.set((getAmount() + 1) + AMOUNT_SUB);
    }

    @FXML
    private void decrementItem(ActionEvent event) {
        amountProperty.set((getAmount() - 1) + AMOUNT_SUB);
    }

    @FXML
    private void removeItem(ActionEvent event) {
        this.controller.getProductList().getItems().remove(this);
    }
}
