/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

/**
 *
 * @author chrisjust
 */
public class Type {
    private int price, id;
    private String desc;

    public Type(int price, int id, String desc) {
        this.price = price;
        this.id = id;
        this.desc = desc;
    }
    
    public Type(int price, String desc){
        this.price = price;
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
}
