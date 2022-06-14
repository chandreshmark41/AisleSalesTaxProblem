package SalesTax.Resource;

import SalesTax.Controller.TaxController;
import SalesTax.Entity.ItemEntity;
import SalesTax.Controller.TaxControllerImpl;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        TaxController taxController = new TaxControllerImpl();
        List<ItemEntity> cart = taxController.addItem(scanner);
        taxController.calculateTax(cart);

    }


}
