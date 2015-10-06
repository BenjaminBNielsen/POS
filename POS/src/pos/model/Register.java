package pos.model;

import pos.exceptions.InsufficientCashHoldingException;

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

    private int cashHolding = 0;

    private Basket basket = new Basket();

    /**
     * this method is used to calculate the amount to be return to the customer
     * when she wants to pay for everything thats in the basket
     *
     * @param the amount the user used to pay with
     * @return what is left over when everything in the basket is payed for.
     */
    public int calcReturn(int input) throws InsufficientCashHoldingException{
        int returnValue = input - basket.calcPrice();
        if(returnValue > this.cashHolding){
            throw new InsufficientCashHoldingException("Not enough cash in register");
        }
        return returnValue;
    }

    public Basket getBasket() {
        return basket;
    }

    public void addToCashHolding(int amount) {
        this.cashHolding += amount;
    }

    public void subtractFromCashHolding(int amount) {
        this.cashHolding -= amount;
    }

    public int pay(int input) throws InsufficientCashHoldingException {
        int returnValue = calcReturn(input);
        addToCashHolding(this.basket.calcPrice());
        return returnValue;
    }

    public int showCashHolding() {
        return this.cashHolding;
    }
}
