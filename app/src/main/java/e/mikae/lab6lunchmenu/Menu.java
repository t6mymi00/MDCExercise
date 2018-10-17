package e.mikae.lab6lunchmenu;

public class Menu {
    private LunchMenu LunchMenu;
    private DietFilter[] RequireDietFilters;
    private DietFilter[] ExcludeDietFilters;
    private DietFilter[] RestaurantDietFilters;

    public Menu(e.mikae.lab6lunchmenu.LunchMenu lunchMenu, DietFilter[] requireDietFilters, DietFilter[] excludeDietFilters, DietFilter[] restaurantDietFilters) {
        LunchMenu = lunchMenu;
        RequireDietFilters = requireDietFilters;
        ExcludeDietFilters = excludeDietFilters;
        RestaurantDietFilters = restaurantDietFilters;
    }

    public e.mikae.lab6lunchmenu.LunchMenu getLunchMenu() {
        return LunchMenu;
    }

    public void setLunchMenu(e.mikae.lab6lunchmenu.LunchMenu lunchMenu) {
        LunchMenu = lunchMenu;
    }

    public DietFilter[] getRequireDietFilters() {
        return RequireDietFilters;
    }

    public void setRequireDietFilters(DietFilter[] requireDietFilters) {
        RequireDietFilters = requireDietFilters;
    }

    public DietFilter[] getExcludeDietFilters() {
        return ExcludeDietFilters;
    }

    public void setExcludeDietFilters(DietFilter[] excludeDietFilters) {
        ExcludeDietFilters = excludeDietFilters;
    }

    public DietFilter[] getRestaurantDietFilters() {
        return RestaurantDietFilters;
    }

    public void setRestaurantDietFilters(DietFilter[] restaurantDietFilters) {
        RestaurantDietFilters = restaurantDietFilters;
    }
}
