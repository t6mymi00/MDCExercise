package e.mikae.lab6lunchmenu;

import org.json.JSONObject;

import java.util.Map;

public class LunchMenu {
    private String DayOfWeek;
    private String Date;
    private SetMenus[] SetMenus;
    private String Html;

    public LunchMenu(String dayOfWeek, String date, SetMenus[] setMenus, String html) {
        DayOfWeek = dayOfWeek;
        Date = date;
        SetMenus = setMenus;
        Html = html;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public e.mikae.lab6lunchmenu.SetMenus[] getSetMenus() {
        return SetMenus;
    }

    public void setSetMenus(e.mikae.lab6lunchmenu.SetMenus[] setMenus) {
        SetMenus = setMenus;
    }

    public String getHtml() {
        return Html;
    }

    public void setHtml(String html) {
        Html = html;
    }
}

