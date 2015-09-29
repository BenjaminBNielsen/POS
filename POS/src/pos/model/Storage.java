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

    public static Storage getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            if (id == products.get(i).getId()){
                return products.get(i);
            }
           
        }
        return null;
    }

    public void add(Type type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
