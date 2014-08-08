package com.android.test01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SelectCityActivity extends Activity {
	
	private String[] provinces = new String[]{"浙江","山西","北京"};
	private String[][] cities = new String[][]{
			{"杭州","金华","宁波"},
			{"太原","吕梁","运城"},
			{"海淀","中关村"}
	};
	/**
	 * 确认区域
	 */
	private Button bn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_city);
		
		bn = (Button) findViewById(R.id.select_bn);
		
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SelectCityActivity.this, StartActivity.class);
				Bundle data = new Bundle();
				intent.putExtra("city", "浙江-杭州");
				SelectCityActivity.this.setResult(0, intent);
				SelectCityActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_city, menu);
		return true;
	}

}
