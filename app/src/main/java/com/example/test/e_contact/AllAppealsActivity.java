package com.example.test.e_contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.view.View.inflate;
import static com.example.test.e_contact.R.id.btn_allAppeals_menu;

public class AllAppealsActivity extends Activity implements View.OnClickListener {

    final String ICON = "icon";
    final String HEADER = "header";
    final String CONTENT = "content";
    final String DATE = "date";
    final String DAYS_IN_PROGRESS = "days in progress";
    final String LIKES = "likes";
    final String LIKES_COUNTER = "likes_counter";

    ListView lv_allAppeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_appeals);

        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
//        tabSpec.setIndicator("В РОБОТI");
        tabSpec.setIndicator(inflate(this, R.layout.all_appeals_tab_1, null));

        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
//        tabSpec.setIndicator("ВЫКОНАНО");
        tabSpec.setIndicator(inflate(this, R.layout.all_appeals_tab_2, null));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
//        tabSpec.setIndicator("ОЧИКУЄ");
        tabSpec.setIndicator(inflate(this, R.layout.all_appeals_tab_3, null));
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);

        // default tab
        tabHost.setCurrentTabByTag("tag1");

        View v = findViewById(R.id.v_allAppealsLine);
        v.bringToFront();

        Button btn_allAppeals_menu = (Button) findViewById(R.id.btn_allAppeals_menu);
        Button btn_allAppeals_filter = (Button) findViewById(R.id.btn_allAppeals_filter);

        btn_allAppeals_menu.setOnClickListener(this);
        btn_allAppeals_filter.setOnClickListener(this);

        int[] icons = {R.mipmap.all_appeals_icon1,
                R.mipmap.all_appeals_icon2,
                R.mipmap.all_appeals_icon1,
                R.mipmap.all_appeals_icon2,
                R.mipmap.all_appeals_icon1};
        String[] headers = {"Комунальне господарство", "Благоустрiй та будiвництво", "Благоустрiй", "Будiвництво", "Господарство"};
        String[] contents = {"вул. Б. Кротова, 22. Днiпропетровськ",
                "вул. Б. Кротова, 22. Днiпропетровськ",
                "вул. Б. Кротова, 22. Днiпропетровськ",
                "вул. Б. Кротова, 22. Днiпропетровськ",
                "вул. Б. Кротова, 22. Днiпропетровськ"};
        String[] dates = {"Лют. 09,2016", "Лют. 08,2016", "Лют. 05,2016", "Лют. 03,2016", "Лют. 02,2016"};
        String[] days_in_progress = {"7 днiв", "6 днiв", "5 днiв", "4 днi", "3 днi"};
        int likes = R.mipmap.all_appeals_icon_likes;
        int[] likes_counter = {0, 1, 3, 2, 5};

        ArrayList<Map<String, Object>> data = new ArrayList<>(headers.length);
        Map<String, Object> m;
        for (int i = 0; i < headers.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ICON, icons[i]);
            m.put(HEADER, headers[i]);
            m.put(CONTENT, contents[i]);
            m.put(DATE, dates[i]);
            m.put(DAYS_IN_PROGRESS, days_in_progress[i]);
            m.put(LIKES, likes);
            m.put(LIKES_COUNTER, likes_counter[i]);
            data.add(m);

        }

        String[] from = {ICON, HEADER, CONTENT, DATE, DAYS_IN_PROGRESS, LIKES, LIKES_COUNTER};
        int[] to = {R.id.iv_icons, R.id.tv_header, R.id.tv_content, R.id.tv_date, R.id.tv_daysInProgress, R.id.iv_likes, R.id.tv_likesCounter};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.all_appeals_item, from, to);

        lv_allAppeals = (ListView) findViewById(R.id.lv_allAppeals);
        lv_allAppeals.setAdapter(simpleAdapter);

        lv_allAppeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent = new Intent(AllAppealsActivity.this, UtilitiesActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case btn_allAppeals_menu:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
