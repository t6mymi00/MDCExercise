package e.mikae.lab6lunchmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById (R.id.textViewDate)
    TextView textViewDate;

    @ViewById (R.id.listView)
    ListView listView;

    @ViewById (R.id.buttonPreviousDate)
    Button buttonPreviousDate;

    @ViewById (R.id.buttonNextDate)
    Button buttonNextDate;

    ArrayList<String> menuItems;
    ArrayAdapter<String> adapter;

    Date today;
    Date currentlySelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = Calendar.getInstance().getTime();
        currentlySelectedDate = today;
        reloadMenu(today);
    }

    @Click(R.id.buttonPreviousDate)
    void buttonPreviousDateClicked() {
        currentlySelectedDate = getNewDate(-1);
        reloadMenu(currentlySelectedDate);
    }

    @Click(R.id.buttonNextDate)
    void buttonNextDateClicked() {
        currentlySelectedDate = getNewDate(1);
        reloadMenu(currentlySelectedDate);
    }

    @UiThread
    public void printData(Menu menu) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentlySelectedDate);
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
                buttonNextDate.setEnabled(false);
            } else {
                buttonNextDate.setEnabled(true);
            }
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                buttonPreviousDate.setEnabled(false);
            } else {
                buttonPreviousDate.setEnabled(true);
            }

            StringBuilder stringBuilder = new StringBuilder(menu.getLunchMenu().getDayOfWeek());
            stringBuilder.append(" - ");
            stringBuilder.append(menu.getLunchMenu().getDate());
            textViewDate.setText(stringBuilder.toString());
            for (SetMenus menus : menu.getLunchMenu().getSetMenus()) {
                if (menuItems.size() != 0) {
                    menuItems.add("\r\n");
                }
                menuItems.add(menus.getName().trim().toUpperCase());
                listView.setAdapter(adapter);
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
    public void loadMenu(Date date) {
        APIReader apiReader = new APIReader();
        printData(apiReader.getMenuForDate(date));
    }

    private void reloadMenu(Date date) {
        menuItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, menuItems);
        listView.setAdapter(adapter);
        loadMenu(date);
    }

    private Date getNewDate(int dateInterval) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(currentlySelectedDate);
            calendar.add(Calendar.DATE, dateInterval);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calendar.getTime();
    }
}
