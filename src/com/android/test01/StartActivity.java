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
import android.widget.TextView;

public class StartActivity extends Activity {
	private Button button;
	private Button bn_return;
	private Button bn_city_select;
	private TextView edit_text_start;
	private TextView edit_city_start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		Log.v("V", "打开第二个activity");
		
		button = (Button) findViewById(R.id.bn_return2one);
		bn_return = (Button) findViewById(R.id.bn_return);
		edit_text_start = (TextView) findViewById(R.id.edit_text_start);
		edit_city_start = (TextView) findViewById(R.id.edit_city_start);
		bn_city_select = (Button) findViewById(R.id.city_select);
		
		//不关闭返回上一个
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		//关闭放回上一个
		bn_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
		//得到第一个activity传过来的值
		Intent getIntent = getIntent();
		Person p = (Person) getIntent.getSerializableExtra("person");
		edit_text_start.setText(p.getUserName());
		
		bn_city_select.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, SelectCityActivity.class);
				startActivityForResult(intent, 0);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		if(requestCode == 0 && resultCode == 0){
			Bundle data = intent.getExtras();
			String resultCity = data.getString("city");
			edit_city_start.setText(resultCity);
		}
	}
}
