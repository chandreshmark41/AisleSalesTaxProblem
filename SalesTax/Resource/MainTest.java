package SalesTax.Resource;

import SalesTax.Controller.TaxController;
import SalesTax.Controller.TaxControllerImpl;
import SalesTax.Entity.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        TaxController taxController = new TaxControllerImpl();

        ItemEntity item1 = new ItemEntity(1, "maggie", 10, true, "food");
        ItemEntity item2 = new ItemEntity(1, "purfume", 100, true, "others");
        List<ItemEntity> cart = new ArrayList<>();
        cart.add(item1);
        cart.add(item2);

        taxController.calculateTax(cart);

    }
}
