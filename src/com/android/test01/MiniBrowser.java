package com.android.test01;

import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.EditText;

public class MiniBrowser extends Activity {

	private EditText url_address;
	private WebView browser_show;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mini_browser);
		
		url_address = (EditText) findViewById(R.id.url_address);
		browser_show = (WebView) findViewById(R.id.browser_show);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mini_browser, menu);
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		Log.i("TAG_I", keyCode+"");
		Log.i("TAG_I", event+"");
		if(keyCode == KeyEvent.KEYCODE_SEARCH){
			String urlStr = url_address.getText().toString();
			Log.i("我是普通信息", urlStr);
			//加载、并显示urlStr对应的网页
			browser_show.loadUrl(urlStr);
			return true;
		}
		return false;
	}
}
