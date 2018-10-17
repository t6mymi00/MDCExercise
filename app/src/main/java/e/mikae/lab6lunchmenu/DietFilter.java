package e.mikae.lab6lunchmenu;

public class DietFilter {
    private String Name;
    private String TranslatedName;
    private String Diet;
    private Boolean Selected;
    private Boolean Inactive;
    private String[] AdditionalVisibleDiets;

    public DietFilter(String name, String translatedName, String diet, Boolean selected, Boolean inactive, String[] additionalVisibleDiets) {
        Name = name;
        TranslatedName = translatedName;
        Diet = diet;
        Selected = selected;
        Inactive = inactive;
        AdditionalVisibleDiets = additionalVisibleDiets;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTranslatedName() {
        return TranslatedName;
    }

    public void setTranslatedName(String translatedName) {
        TranslatedName = translatedName;
    }

    public String getDiet() {
        return Diet;
    }

    public void setDiet(String diet) {
        Diet = diet;
    }

    public Boolean getSelected() {
        return Selected;
    }

    public void setSelected(Boolean selected) {
        Selected = selected;
    }

    public Boolean getInactive() {
        return Inactive;
    }

    public void setInactive(Boolean inactive) {
        Inactive = inactive;
    }

    public String[] getAdditionalVisibleDiets() {
        return AdditionalVisibleDiets;
    }

    public void setAdditionalVisibleDiets(String[] additionalVisibleDiets) {
        AdditionalVisibleDiets = additionalVisibleDiets;
    }
}
