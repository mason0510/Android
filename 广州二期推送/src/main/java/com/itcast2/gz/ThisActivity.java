package com.itcast2.gz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class ThisActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thisactivity);
		
		//http://www.ooxx.com/abcd.html--->WebView
		String url = getIntent().getStringExtra("url");
		Toast.makeText(getApplicationContext(), url, 1).show();
	}
}
