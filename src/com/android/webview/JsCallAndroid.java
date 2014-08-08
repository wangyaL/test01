package com.android.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.test01.R;

public class JsCallAndroid extends Activity {
	private WebView myWebView;

	@SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_js_call_android);
		
		myWebView = (WebView) findViewById(R.id.js_call_webview);
		myWebView.loadUrl("file:///android_asset/test.html");
		
		//wView.loadUrl("file:///android_asset/index.html");    打开本包内asset目录下的index.html文件
        //wView.loadUrl("content://com.android.htmlfileprovider/sdcard/index.html");  打开本地sd卡内的index.html文件
		//wView.loadUrl("http://wap.baidu.com"); 打开指定URL的html文件
		
		//获取WebView的设置对象
		WebSettings webSettings = myWebView.getSettings();
		//开启JavaScript调用
		webSettings.setJavaScriptEnabled(true);
		//将MyObject对象暴露给JavaScript脚本
		//这样test.html页面中的Javascript可以通过myObj来调用MyObject的方法
		myWebView.addJavascriptInterface(new MyObject(this), "myObj");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.js_call_android, menu);
		return true;
	}

}
