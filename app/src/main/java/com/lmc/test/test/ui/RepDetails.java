package com.lmc.test.test.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lmc.test.test.R;

public class RepDetails extends AppCompatActivity {
    String repName;
    String repUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rep_details);


        Intent intent=getIntent();
        repName=intent.getStringExtra("rep_name");
        repUrl=intent.getStringExtra("rep_url");

        TextView textView= (TextView) findViewById(R.id.repNameValtextView);
        textView.setText(repName);

        TextView textView2= (TextView) findViewById(R.id.repoUrlValtextView7);
        textView2.setText(repUrl);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
