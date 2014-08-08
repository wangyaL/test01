package com.android.test01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class URLTestActivity extends Activity {
	
	private Button urltest_return;
	
	ImageView show;
	Bitmap bitmap;
	Handler handler = new Handler(){
		public void handleMessage(Message msg){
			if(msg.what == 0x123){
				//使用ImageView显示该图片
				show.setImageBitmap(bitmap);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_urltest);
		
		show = (ImageView) findViewById(R.id.show);
		new Thread(){
			public void run(){
				try {
					//定义一个URL对象
					URL url = new URL("http://www.zhijianlife.com/images/buyer/food2.jpg");
					//打开该URL对应的资源的输入流
					InputStream is = url.openStream();
					//从InputStream中解析图片
					bitmap = BitmapFactory.decodeStream(is);
					//发送消息、通知UI组件显示该图片
					handler.sendEmptyMessage(0x123);
					is.close();
					//再次打开URL对应的资源的输入流
					is = url.openStream();
					//打开手机文件对应的输出流
					OutputStream os = openFileOutput("crazyit.png", MODE_WORLD_READABLE);
					byte[] buff = new byte[1024];
					int hasRead = 0;
					//将URL对应的资源下载到本地
					while((hasRead = is.read(buff)) > 0){
						os.write(buff, 0, hasRead);
					}
					is.close();
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		
		urltest_return = (Button) findViewById(R.id.urltest_return);
		urltest_return.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent toMain = new Intent(URLTestActivity.this, MainActivity.class);
				startActivity(toMain);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.urltest, menu);
		return true;
	}

}
