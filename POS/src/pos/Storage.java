/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.util.ArrayList;

/**
 *
 * @author chrisjust
 */
public class Storage {
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
            if (id == products.get(i).getId()){
                return products.get(i);
            }
           
        }
        return null;
    }
}
