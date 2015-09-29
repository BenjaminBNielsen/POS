/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chrisjust
 */
public class StorageTest {
    private Type testType = new Type(500, 1, "testType");
    private Storage storage = Storage.getInstance();
    private ArrayList<Product> productList = storage.getProducts();
    public StorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Storage.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Storage expResult = Storage.getInstance();
        Storage result = storage;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getProducts method, of class Storage.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        ArrayList<Product> expResult = productList;
        
        storage.add(new Type(100,1,"Bananer"));
        
        ArrayList<Product> result = storage.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducts method, of class Storage.
     */
    @Test
    public void testSetProducts() {
        System.out.println("setProducts");
        ArrayList<Product> products = productList;
        storage.setProducts(products);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class Storage.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        //int id = 1;       
        Storage instance = Storage.getInstance();
        Type type = new Type(100,1,"Agurk");
        
        instance.add(type);
        
        int expResult = 100;
        
        int result = instance.getProduct(1).getType().getPrice();
        
        assertEquals(expResult, result);
        
    
        
    }

    /**
     * Test of add method, of class Storage.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Type type = new Type(100,1,"Agurk");
        Storage instance = Storage.getInstance();
        instance.add(type);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
