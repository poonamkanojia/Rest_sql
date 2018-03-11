package com.poonam.rest_sql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class View_history extends AppCompatActivity {

    TextView tvHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        tvHistory=(TextView)findViewById(R.id.tvHistory);
        Intent i2=getIntent();
        String pk=i2.getStringExtra("pk");
        tvHistory.setText(pk);
    }
}
