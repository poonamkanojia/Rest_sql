package com.poonam.rest_sql;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText etPrice , etDish , etTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Database_Handler db= new Database_Handler(this);
        Button btnView = (Button) findViewById(R.id.btnView);
        Button btnSave = (Button) findViewById(R.id.btnSave);

        etPrice = (EditText) findViewById(R.id.etPrice);
        etDish = (EditText) findViewById(R.id.etDish);
        etTable = (EditText) findViewById(R.id.etTable);



        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pk="something will apear here ";
                String data=db.getHistory();
                Intent i2=new Intent(MainActivity.this,View_history.class);
                i2.putExtra("pk",data);

                //Intent i = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(i2);
            }
        });//end of button

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                String dish=(intent.getStringExtra("time"));

                long millis=System.currentTimeMillis();
                Date date = new Date(millis);
                String price = etPrice.getText().toString();
                String dish1 = etDish.getText().toString();
                String table_no = etTable.getText().toString();
                db.addRecord(date,dish1,price,table_no);
            }
        });//end of button
    }
}
