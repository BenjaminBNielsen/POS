/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.model;

import java.util.ArrayList;

/**
 *
 * @author chrisjust
 */
public class Storage {
    private static Storage instance;
    
    public static Storage getInstance() {
        if (instance == null){
            instance = new Storage();
        }
        return instance;
    }
    private ArrayList<Product> products = new ArrayList<>();
    
    public Storage(){
        
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public Product getProduct(int id){
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getType().getId()){
                return products.get(i);
            }
           
        }
        return null;
    }

    public void add(Type type) {
        products.add(new Product(type));
    }
}
