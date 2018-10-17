package e.mikae.lab6lunchmenu;

import java.util.Map;

public class SetMenus {
    private int SortOrder;
    private String Name;
    private String Price;
    private Meals[] Meals;

    public SetMenus(int sortOrder, String name, String price, Meals[] meals) {
        SortOrder = sortOrder;
        Name = name;
        Price = price;
        Meals = meals;
    }

    public int getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(int sortOrder) {
        SortOrder = sortOrder;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public e.mikae.lab6lunchmenu.Meals[] getMeals() {
        return Meals;
    }

    public void setMeals(e.mikae.lab6lunchmenu.Meals[] meals) {
        Meals = meals;
    }
}
