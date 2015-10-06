package pos.model;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Morten
 */
public class Basket {

    private Storage storage = Storage.getInstance();
    private ObservableList<Product> items = FXCollections.observableArrayList();

    /**
     * Calculates the total cost of the items in the basket
     *
     * @return the total price
     */
    public int calcPrice() {
        int total = 0;
        for (Product item : items) {
            total += item.getType().getPrice();
        }
        return total;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Product addProduct(int id) {
        Product p = storage.getProduct(id);
        items.add(p);
        return p;
    }

    public ObservableList<Product> getItems() {
        return this.items;
    }

    public int countType(Type type) {
        int count = 0;
        for (Product item : items) {
            if (type.getId() == item.getType().getId()) {
                count++;
            }
        }
        return count;
    }
    
    public Product get(int id){
        for (Product item : items) {
            if(id == item.getType().getId()){
                return item;
            }
        }
        return null;
    }

    public void setAmount(int amount, Type type) {
        int count = countType(type);
        if (amount != count) {
            if (amount > count) {
                for (int i = 0; i < amount - count; i++) {
                    addProduct(type.getId());
                }
            } else if (count > amount) {
                for (int i = 0; i < count-amount; i++) {
                    items.remove(get(type.getId()));
                }
            }
        }
    }

}
