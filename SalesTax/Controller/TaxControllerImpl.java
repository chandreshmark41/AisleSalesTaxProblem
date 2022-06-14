package SalesTax.Controller;

import SalesTax.Entity.ItemEntity;

import java.util.*;

public class TaxControllerImpl  implements  TaxController{

    Map<String,String> category = new HashMap<String,String>(){{
        put("1", "Book");
        put("2", "Medical");
        put("3", "Food");
        put("4", "Others");
    }};
    List<ItemEntity> listOfItem = new ArrayList<>();

    /***
     * adds item in the cart as per the user input.
     * @param scanner
     * @return
     */
    public  List<ItemEntity> addItem(Scanner scanner) {


        ItemEntity item = new ItemEntity();
        System.out.println("Please enter name of item");
        item.setName(scanner.nextLine());

        System.out.println("Please enter unit of item");
        item.setUnit(scanner.nextInt());

        scanner.nextLine();

        System.out.println(("Please select Category of Item between and 1 and 4"));
        System.out.println(category);

        String choiceOfCategory = scanner.nextLine();
        item.setCategoryChoice(category.get(choiceOfCategory));

        System.out.println("Is the item imported Y/N");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            item.setImported(true);
        }

        System.out.println("Please enter price of item");
        item.setPrice(scanner.nextDouble());
        scanner.nextLine();

        System.out.println("Do you want add more item Y/N");
        String isAddNewItem = scanner.nextLine();

        listOfItem.add(item);
        if (isAddNewItem.equalsIgnoreCase("Y")) {
            addItem(scanner);
        }
        else {
            //System.out.println(item);
            for (ItemEntity items : listOfItem) {
                //System.out.println(items.toString());
            }
            //System.out.println("You don't want to add items into cart");
        }

        return listOfItem;
    }

    /***
     * Calculate Tax for the given items which are added in the cart
     * @param cart
     */
    @Override
    public void calculateTax(List<ItemEntity> cart) {
        double cartAmount = 0;
        double cartTax = 0;
        double tax = 0;
        int directTax = 10;
        int importTax = 5;
        for (ItemEntity item : cart) {
            int totalTax = 0;
            if (item.isImported()) {
                totalTax += importTax;
                if (item.getCategoryChoice().equalsIgnoreCase("book") ||
                        item.getCategoryChoice().equalsIgnoreCase("food")
                        || item.getCategoryChoice().equalsIgnoreCase("medical")) {
                    //System.out.println("No tax");
                } else if (item.getCategoryChoice().equalsIgnoreCase("others")) {
                    totalTax += directTax;

                }


            } else {
                if (item.getCategoryChoice().equalsIgnoreCase("book") ||
                        item.getCategoryChoice().equalsIgnoreCase("food")
                        || item.getCategoryChoice().equalsIgnoreCase("medical")) {
                    //System.out.println("No tax");
                } else if (item.getCategoryChoice().equalsIgnoreCase("others")) {
                    totalTax += directTax;

                }

            }
            // rounded = Math.round(x * 20.0) / 20.0;
            tax =  (item.getPrice() * totalTax / 100 ) * item.getUnit();
            double priceAfterTax = item.getPrice()* item.getUnit() + tax ;
            cartAmount += priceAfterTax;
            cartTax += tax;


            System.out.println(item.getUnit() + " " + item.getName() + " : " + priceAfterTax);

        }
        // rounded = Math.round(x * 20.0) / 20.0;
        cartTax = Math.round(cartTax * 20.0) / 20.0; // rounding value for .05 round off
        System.out.println("Sales Taxes : "+ cartTax);
        System.out.println("Total : "+ cartAmount);
    }
}
