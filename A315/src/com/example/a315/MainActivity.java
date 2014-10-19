package com.example.a315;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		Button b = (Button) this.findViewById(R.id.buttonM);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("my.own.rating.action");
				MainActivity.this.startActivity(intent);
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences prefs = this.getSharedPreferences("options", MODE_PRIVATE);
		this.tv = (TextView) this.findViewById(R.id.textView1);
		if (prefs.contains("name")) {
			String rating = "Cinema called \"" + prefs.getString("name", "") + "\" has rating ";
			rating +=
					prefs.getInt("rating", 0) + " and marked as " + prefs.getString("cFantasy", "");
			this.tv.setText(rating);
		} else {
			this.tv.setText("there was not rating set");
		}
	}
	
}
