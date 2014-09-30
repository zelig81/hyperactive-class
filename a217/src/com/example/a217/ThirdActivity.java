package com.example.a217;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	String[] arr = { "first word", "second word", "third word" };
	Random r = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		TextView tv = (TextView) findViewById(R.id.TextView2);
		int index = r.nextInt(3);
		tv.setText(arr[index]);
		Button b = (Button) findViewById(R.id.button3);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				final Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}