package pos.model;


import java.util.ArrayList;

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
    private ArrayList<Product> items = new ArrayList<>();
    
    /**
     * Calculates the total cost of the items in the basket
     * @return the total price
     */
    
    public int calcPrice(){
        int total = 0;
        for (Product item : items) {
            total += item.getType().getPrice();
        }
        return total;
    }    
    
    public void addProduct(int id){
        items.add(storage.getProduct(id));
        
    }
}
