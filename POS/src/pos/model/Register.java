package pos.model;


import pos.model.Basket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Morten
 */
public class Register {
    
    private Basket basket = new Basket();
    
    /**
     * this method is used to calculate the amount to be return to
     * the customer when she wants to pay for everything thats in the basket
     * @param the amount the user used to pay with
     * @return what is left over when everything in the basket is 
     * payed for.
     */
    public int calcReturn(int input){
        return input - basket.calcPrice();
    } 

    public Basket getBasket() {
        return basket;
    }
   
}
