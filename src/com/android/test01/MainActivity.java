package com.android.test01;

import com.android.core.user.Person;
import com.android.webview.JsCallAndroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	/**
	 * 点击跳到第二个activity
	 */
	private Button bn;
	private Button to_urltest;
	private Button to_browser;
	private Button to_js_call;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.v("V", "打开第一个activity");
		
		bn = (Button) findViewById(R.id.button1);
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
		
		to_urltest = (Button) findViewById(R.id.to_urltest);
		to_urltest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent toUrl = new Intent(MainActivity.this, URLTestActivity.class);
				startActivity(toUrl);
				finish();
			}
		});
		
		to_browser = (Button) findViewById(R.id.to_browser);
		to_browser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent to_browser = new Intent(MainActivity.this, MiniBrowser.class);
				startActivity(to_browser);
				finish();
			}
		});
		
		to_js_call = (Button) findViewById(R.id.to_js_call);
		to_js_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent to_browser = new Intent(MainActivity.this, JsCallAndroid.class);
				startActivity(to_browser);
				finish();
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
