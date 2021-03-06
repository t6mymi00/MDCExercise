package e.mikae.lab6lunchmenu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class APIReader {

    private String url = null;

    public Menu getMenuForDate(Date date) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        String json = JSON.getJSON(getApiUrlForDate(date));
        Menu response = null;
        try {
            response = gson.fromJson(json, Menu.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String getApiUrlForDate(Date date) {
        if (url == null) {
            StringBuilder stringBuilder = new StringBuilder("https://www.amica.fi/api/restaurant/menu/day?date=");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            stringBuilder.append( df.format(date));
            stringBuilder.append("&language=");
            if (Locale.getDefault().getLanguage().equals("fi")) {
                stringBuilder.append("fi");
            } else {
                stringBuilder.append("en");
            }
            stringBuilder.append("&restaurantPageId=66287");
            url = stringBuilder.toString();
        }

        return url;
    }
}
