package com.example.test.e_contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import static android.view.View.OnClickListener;

public class UtilitiesActivity extends AppCompatActivity implements OnClickListener {

    RecyclerView recycler_view;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    int[] myDataset = {R.mipmap.image1, R.mipmap.image2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utilities);

        Button btn_back = (Button) findViewById(R.id.btn_utilities_back);
        btn_back.setOnClickListener(this);

        recycler_view = (RecyclerView) findViewById(R.id.rv_utilities);
        recycler_view.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recycler_view.setLayoutManager(layoutManager);

        adapter = new UtilitiesAdapter(myDataset);
        recycler_view.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_utilities_back:
                Intent intent = new Intent(this, AllAppealsActivity.class);
                startActivity(intent);
                break;
        }
    }

//    public List <String> fillData(){
//        List <String> data = new ArrayList<>();
//        data.add(R.mipmap.image1, "image1");
//        data.add(R.mipmap.image2, "image2");
//        return data;
//    }
}
