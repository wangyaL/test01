package com.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BookDetailFragment extends Fragment {

	public static final String ITEM_ID = "item_id";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//如果启动该Fragment时包含了ITEM_ID参数
		if(getArguments().containsKey(ITEM_ID)){
			
		}
	}
}
