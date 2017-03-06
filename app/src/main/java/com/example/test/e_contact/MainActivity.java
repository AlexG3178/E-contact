package com.example.test.e_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView test;
    public static final String TAG = "###### MY LOGS:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button_allAppeals = (Button) findViewById(R.id.allAppeals);
        Button button_appealsOnMap = (Button) findViewById(R.id.appealsOnMap);
        Button button_login = (Button) findViewById(R.id.login);
        TextView yalantis = (TextView) findViewById(R.id.yalantis);
        TextView itRuhDnipro = (TextView) findViewById(R.id.itRuhDnipro);
        test = (TextView) findViewById(R.id.test);

        button_allAppeals.setOnClickListener(this);
        button_appealsOnMap.setOnClickListener(this);
        button_login.setOnClickListener(this);
        yalantis.setOnClickListener(this);
        itRuhDnipro.setOnClickListener(this);

        registerForContextMenu(itRuhDnipro);
        registerForContextMenu(yalantis);
        registerForContextMenu(test);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.allAppeals:
                Intent intent = new Intent(this, AllAppealsActivity.class);
                startActivity(intent);
                Log.d(TAG, "All Appears pushed");
                break;
            case R.id.appealsOnMap:
                test.setText(R.string.appealsOnMap);
                break;
            case R.id.login:
                test.setText(R.string.loggingIn);
                break;
            case R.id.yalantis:
                test.setText(R.string.yalantis);
                break;
            case R.id.itRuhDnipro:
                test.setText(R.string.it_ruh_dnipro);
                break;
        }
    }
}
