package com.example.databasesmaple2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText name, email, addr;
	Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final DBHandler dbh = new DBHandler(this);
        
        name = (EditText)findViewById(R.id.editText1);
        email = (EditText)findViewById(R.id.editText2);
        addr = (EditText)findViewById(R.id.editText3);
        
        add = (Button)findViewById(R.id.button1);
        
        add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String dname = name.getText().toString().trim();
				String demail = email.getText().toString().trim();
				String daddr = addr.getText().toString().trim();
				
				dbh.addinfo(dname, demail, daddr);
				Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_LONG).show();
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
