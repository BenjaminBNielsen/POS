/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.model;

import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import pos.model.Basket;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pos.model.Product;
import pos.model.Storage;
import pos.model.Type;

/**
 *
 * @author ut
 */
public class BasketTest {
    
    Type agurkType = new Type(300, 1 ,  "agurk");
    Storage storage = Storage.getInstance();
    
    public BasketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        for (int i = 0; i < 10; i++) {
            storage.add(agurkType);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcPrice method, of class Basket.
     */
    @Test
    public void testCalcPriceOneItem() {
        Basket basketInstance = new Basket();
        basketInstance.addProduct(1);
        int expResult = 300;
        int actResult = basketInstance.calcPrice();
        assertEquals("could not calc price for one item", expResult, actResult);
    }
    /**
     * Test of calcPrice method, of class Basket.
     */
    @Test
    public void testCalcPriceMultipleItems() {
        Basket basketInstance = new Basket();
        basketInstance.addProduct(1);
        basketInstance.addProduct(1);
        basketInstance.addProduct(1);
        int expResult = 900;
        int actResult = basketInstance.calcPrice();
        assertEquals("could not calc price for 3 items",expResult, actResult);
    }
}
