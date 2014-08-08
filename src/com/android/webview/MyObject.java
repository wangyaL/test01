package com.android.webview;

import com.android.test01.R;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

public class MyObject {
	Context mContext;
	MyObject(Context c){
		mContext = c;
	}

	//该方法将会暴露给JavaScript脚本调用
	public void showToast(String name){
		Toast.makeText(mContext, name + "，您好！", Toast.LENGTH_LONG).show();
	}
	//该方法将会暴露给JavaScript脚本调用
	public void showLit(){
		String[] strs = new String[]{"疯狂Java讲义","疯狂Android讲义","轻量级Java EE 企业应用实战"};
		//显示一个普通的列表对话框
		new AlertDialog.Builder(mContext)
			.setTitle("图书列表")
			.setIcon(R.drawable.ic_launcher)
			.setItems(strs, null)
			.setPositiveButton("确定", null)
			.create()
			.show();
	}
}
