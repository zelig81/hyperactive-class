package com.example.a313;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends Activity {
	private final static String options = "A313.options.ini";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences prefs = this.getSharedPreferences(options, MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		EditText et1 = (EditText) this.findViewById(R.id.editText1);
		EditText et2 = (EditText) this.findViewById(R.id.editText2);
		editor.putString("et1", et1.getText().toString());
		editor.putString("et2", et2.getText().toString());
		editor.commit();
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences prefs = this.getSharedPreferences(options, MODE_PRIVATE);
		String set1 = "";
		String set2 = "";
		if (prefs.contains("et1")) {
			set1 = prefs.getString("et1", "");
		}
		if (prefs.contains("et2")) {
			set2 = prefs.getString("et2", "");
		}
		EditText et1 = (EditText) this.findViewById(R.id.editText1);
		EditText et2 = (EditText) this.findViewById(R.id.editText2);
		et1.setText(set1);
		et2.setText(set2);
		
	}
	
}
