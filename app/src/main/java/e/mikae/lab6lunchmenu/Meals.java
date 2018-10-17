package e.mikae.lab6lunchmenu;

import java.util.Map;

public class Meals {
    private String Name;
    private int RecipeId;
    private String[] Diets;
    private String Nutrients;
    private String IconUrl;

    public Meals(String name, int recipeId, String[] diets, String nutrients, String iconUrl) {
        Name = name;
        RecipeId = recipeId;
        Diets = diets;
        Nutrients = nutrients;
        IconUrl = iconUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getRecipeId() {
        return RecipeId;
    }

    public void setRecipeId(int recipeId) {
        RecipeId = recipeId;
    }

    public String[] getDiets() {
        return Diets;
    }

    public void setDiets(String[] diets) {
        Diets = diets;
    }

    public String getNutrients() {
        return Nutrients;
    }

    public void setNutrients(String nutrients) {
        Nutrients = nutrients;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(String iconUrl) {
        IconUrl = iconUrl;
    }
}
