package com.example.a318;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		//
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		Button add = (Button) this.findViewById(R.id.buttonAdd);
		Button show = (Button) this.findViewById(R.id.buttonShow);
		// check if file exist if no -> create it
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddActivity.class);
				MainActivity.this.startActivityForResult(intent, 1);
			}
		});
		
		show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, ShowActivity.class);
				MainActivity.this.startActivityForResult(intent, 2);
			}
		});
	}
}
