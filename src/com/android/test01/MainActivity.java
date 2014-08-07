package com.android.test01;

import com.android.core.user.Person;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("V", "打开第一个activity");
		
		Button bn = (Button) findViewById(R.id.button1);
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Person person = new Person(1, "wyl", "王亚龙", "123456");

				Bundle data = new Bundle();
				data.putSerializable("person", person);
				
				Intent intent = new Intent(MainActivity.this, StartActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
