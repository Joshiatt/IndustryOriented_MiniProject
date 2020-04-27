package com.example.databasesample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et;
	Button add, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final DBHandler dbh = new DBHandler(this);
        
        et = (EditText)findViewById(R.id.editText1);
        add = (Button)findViewById(R.id.button1);
        view = (Button)findViewById(R.id.button2);
        
        add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String name = et.getText().toString().trim();
				dbh.addinfo(name);
				Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
				
			}
		});
        
        view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it = new Intent(MainActivity.this, ViewActivity.class);
				startActivity(it);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
