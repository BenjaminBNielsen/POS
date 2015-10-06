/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.exceptions;

/**
 *
 * @author ut
 */
public class InsufficientCashHoldingException extends Exception{
    
    public InsufficientCashHoldingException(String message){
        super(message);
    }
}
