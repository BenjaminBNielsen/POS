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
    
    private Storage(){
        Type t = new Type(100, 1 ,"Banana");
        
        for (int i = 0; i < 100; i++) {
            this.add(t);
        }
        t = new Type(150, 2, "Cucumber");
        for (int i = 0; i < 200; i++) {
            this.add(t);
        }
        t = new Type(300, 3, "Kiwi");
        for (int i = 0; i < 5; i++) {
            this.add(t);
        }
        t = new Type(1000, 4, "Avokado");
        for (int i = 0; i < 25; i++) {
            this.add(t);
        }
        t = new Type(-500, 5, "Rabat");
        this.add(t);
        
    }
    public static Storage getTestInstance(){
        return new Storage();
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

    public void add(Type... type) {
        for (Type type1 : type) {
            products.add(new Product(type1));
        }
    }
    public void removeProduct(Product product){
    products.remove(product);
    }
    

}
