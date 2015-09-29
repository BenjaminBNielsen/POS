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
//    /**
//     * Test of add method, of class Storage.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        Type type = new Type(100,1,"Agurk");
//        Storage instance = Storage.getInstance();
//        instance.add(type);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
    @Test
    public void testRemoveOneItem(){
        Storage storage = Storage.getTestInstance();
        Type typeBanana = new Type(50, 1, "Banana");
        Type typeCucumber  = new Type(33, 2, "Cucumber");
        storage.add(typeBanana);
        storage.add(typeCucumber);
        storage.removeProduct(storage.getProduct(2));
        int expResult = 1;
        int actresult = storage.getProducts().size();
        assertEquals(expResult, actresult);
    }
    @Test
    public void testRemoveOneItem2(){
        Storage storage = Storage.getTestInstance();
        Type typeBanana = new Type(50, 1, "Banana");
        Type typeCucumber  = new Type(33, 2, "Cucumber");
        storage.add(typeBanana);
        storage.add(typeCucumber);
        storage.removeProduct(storage.getProduct(2));
        String expResult = "Banana";
        String actreslut = storage.getProduct(1).getType().getDesc();
        assertEquals(expResult, actreslut);
    }
    @Test
    public void testRemoveAllProducts(){
        Storage storage = Storage.getTestInstance();
        Type typeBanana = new Type(50, 1, "Banana");
        Type typeCucumber  = new Type(33, 2, "Cucumber");
        storage.add(typeBanana);
        storage.add(typeCucumber);
        storage.removeProduct(storage.getProduct(1));
        storage.removeProduct(storage.getProduct(2));
        int expResult = 0;
        int actresult = storage.getProducts().size();
        assertEquals(expResult, actresult);
    }
    @Test
    public void testRemoveProductsNotInStorage(){
        Storage storage = Storage.getTestInstance();
        Product testProduct = new Product(new Type(1,1,"testDesc"));
        storage.removeProduct(testProduct);
        int expResult = 0;
        int actresult = storage.getProducts().size();
        assertEquals(expResult, actresult);
    }
     @Test
    public void testRemoveOneProductOutOfTwo(){
        Storage storage = Storage.getTestInstance();
        Type typeBanana = new Type(50, 1, "Banana");
        storage.add(typeBanana);
        storage.add(typeBanana);
        storage.removeProduct(storage.getProduct(1));
        int expResult = 1;
        int actresult = storage.getProducts().size();
        assertEquals(expResult, actresult);
    }     
    
}
