package io.github.BGPtII.ch8designingclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void testPurchase1() {
        Customer customer1 = new Customer();
        customer1.makePurchase(100, 1);
        customer1.makePurchase(50, 2);
        customer1.makePurchase(60, 3);
        customer1.makePurchase(20, 1);
        assertEquals(20, customer1.getTotalPurchases());
        assertEquals(1, customer1.getNumberOfUniqueShopsPurchasedFrom());

        customer1.makePurchase(5, 2);
        customer1.makePurchase(5, 3);
        customer1.makePurchase(5, 4);
        customer1.makePurchase(5, 5);
        assertEquals(40, customer1.getTotalPurchases());
        assertEquals(5, customer1.getNumberOfUniqueShopsPurchasedFrom());

        customer1.makePurchase(100, 5);
        assertEquals(140, customer1.getTotalPurchases());
        assertEquals(5, customer1.getNumberOfUniqueShopsPurchasedFrom());

        customer1.makePurchase(30, 3);
        assertEquals(60, customer1.getTotalPurchases());
        assertEquals(1, customer1.getNumberOfUniqueShopsPurchasedFrom());
    }

    @Test
    public void testPurchases2() {
        Customer customer2 = new Customer();
        customer2.makePurchase(100, 1);
        customer2.makePurchase(100, 2);
        customer2.makePurchase(100, 2);
        customer2.makePurchase(100, 2);
        assertEquals(400, customer2.getTotalPurchases());
        assertEquals(2, customer2.getNumberOfUniqueShopsPurchasedFrom());

        customer2.makePurchase(100, 3);
        customer2.makePurchase(100, 3);
        assertEquals(90, customer2.getTotalPurchases());
        assertEquals(1, customer2.getNumberOfUniqueShopsPurchasedFrom());
    }
}
