/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ut
 */
public class RegisterTest {
    private Type testType = new Type(500, 1, "testType");
    private Register testRegister = new Register();
    private Storage storage = Storage.getInstance();
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        storage.add(testType);
        testRegister.getBasket().addProduct(1);
    }
    
    @After
    public void tearDown() {
    }

//    /**
//     * Test of calcReturn method, of class Register.
//     */
//    @Test
//    public void testCalcReturn() {
//        int input = 600;
//        int expResult = input - testType.getPrice();
//        int actResult = testRegister.calcReturn(input);
//        assertEquals("Did not correctly calc return", expResult, actResult);
//    }
//    
//    @Test
//    public void testCalcReturnBelowPrice() {
//        int input = 300;
//        int expResult = input - testType.getPrice() ;
//        int result = testRegister.calcReturn(input);
//        assertEquals("Could not calc a proper return for smaller input than basketprice",expResult, result);
//    }
//    @Test
//    public void testAddToCashHolding() {
//        Register register = new Register();
//        register.addToCashHolding(100);
//        int expResult = 100;
//        int result = register.showCashHolding();
//        assertEquals("Yo man how much money you got",expResult, result);
//    }
//    @Test
//    public void testSubstractFromCashHolding() {
//        Register register = new Register();
//        register.addToCashHolding(100);
//        register.subtractFromCashHolding(50);
//        int expResult = 50;
//        int result = register.showCashHolding();
//        assertEquals("Yo man how much money you lost",expResult, result);
//    }
@Test
    public void testPayCashHolding() {
        Register register = new Register();
        Storage storage = Storage.getTestInstance();
        Type banana = new Type(150, 1, "banana");
        Type cucumber = new Type(200, 2, "banana");
        storage.add(banana);
        storage.add(banana);
        storage.add(banana);
        storage.add(banana);
        storage.add(cucumber);
        storage.add(cucumber);
        storage.add(cucumber);
        storage.add(cucumber);
        register.addToCashHolding(1000);
        System.out.println(register.getBasket().calcPrice());
        register.getBasket().addProduct(1);
        System.out.println(register.getBasket().calcPrice());
        register.getBasket().addProduct(1);
        System.out.println(register.getBasket().calcPrice());
        register.getBasket().addProduct(2);
        System.out.println(register.getBasket().calcPrice());
        register.getBasket().addProduct(2);
        System.out.println(register.getBasket().calcPrice());
        int expResult = 1700;
        register.pay();
        int actResult = register.showCashHolding();
        assertEquals("Yo man how much money you lost",expResult, actResult);
    }
}

