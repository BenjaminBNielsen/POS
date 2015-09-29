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
    
    private Type testType = new Type(300, 1, "testType");
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

    /**
     * Test of calcReturn method, of class Register.
     */
    @Test
    public void testCalcReturn() {
        System.out.println("calcReturn");
        int input = 400;
        testType.setPrice(300);
        int expResult = 100;
        int actResult = testRegister.calcReturn(input);
        assertEquals("Did not correctly calc return", expResult, actResult);
    }
    
    @Test
    public void testCalcReturnBelowPrice() {
        System.out.println("calcReturn");
        int input = 300;
        testType.setPrice(500);
        int expResult = -200;
        int result = testRegister.calcReturn(input);
        assertEquals("Could not calc a proper return for smaller input than basketprice",expResult, result);
    }
    
}