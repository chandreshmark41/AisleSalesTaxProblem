package SalesTax.Entity;

public class ItemEntity {
    public ItemEntity(int unit, String name, double price, boolean isImported, String categoryChoice) {
        this.unit = unit;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.categoryChoice = categoryChoice;
    }


    private int unit;
    private String name;
    private double price;
    private boolean isImported = false;
    private String categoryChoice;

    public ItemEntity() {
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }



    public String getCategoryChoice() {
        return categoryChoice;
    }

    public void setCategoryChoice(String categoryChoice) {
        this.categoryChoice = categoryChoice;
    }


    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    @Override
    public String toString() {
        return
                "unit=" + unit +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryChoice='" + categoryChoice + '\'' ;
    }
}
