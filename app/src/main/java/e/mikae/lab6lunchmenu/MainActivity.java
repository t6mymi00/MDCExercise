package e.mikae.lab6lunchmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById (R.id.textViewDate)
    TextView textViewDate;

    @ViewById (R.id.listView)
    ListView listView;

    ArrayList<String> menuItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);

        loadMenu();
    }

    @UiThread
    public void printData(Menu menu) {
        try {
            //Log.d("LUNCH_MENU", menu.getLunchMenu().getDayOfWeek());
            StringBuilder stringBuilder = new StringBuilder(menu.getLunchMenu().getDayOfWeek());
            stringBuilder.append(" - ");
            stringBuilder.append(menu.getLunchMenu().getDate());
            textViewDate.setText(stringBuilder.toString());
            for (SetMenus menus : menu.getLunchMenu().getSetMenus()) {
                for (Meals meals : menus.getMeals()) {
                    //Log.d("LUNCH_MENU", meals.getName());
                    if (!meals.getName().isEmpty()) {
                        menuItems.add(meals.getName().trim());
                        listView.setAdapter(adapter);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Background
    public void loadMenu() {
        APIReader apiReader = new APIReader();
        printData(apiReader.getMenuForToday());
    }
}
