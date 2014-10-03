package com.example.a226;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b = (Button) findViewById(R.id.button1);
		et = (EditText) findViewById(R.id.EditText1);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String s = et.getText().toString();
				Intent intent = new Intent("com.example.translate");
				intent.putExtra("word", s);
				startActivity(intent);
			}
		});
	}
}
