package SalesTax.Controller;

import SalesTax.Entity.ItemEntity;

import java.util.List;
import java.util.Scanner;

public interface TaxController {
    public  List<ItemEntity> addItem(Scanner scanner);

    public  void calculateTax(List<ItemEntity> cart);
}
