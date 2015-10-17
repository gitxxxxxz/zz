package com.example.myinterface;

//import com.example.sqlite.Younidb;
import com.example.zz.R;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;

public class LoginActivity extends Activity {
//	private Younidb younidb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
//		younidb=Younidb.getInstance(this);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
