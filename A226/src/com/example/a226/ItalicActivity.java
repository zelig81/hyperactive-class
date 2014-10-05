package com.example.a226;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ItalicActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_translation);
		HashMap<String, String> map = new HashMap<>();
		map.put("one", "one italic");
		map.put("two", "two italic");
		String s = getIntent().getStringExtra("word");
		String translation = map.get(s);
		if (translation == null) {
			translation = "no translation";
		}
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(translation);

	}

}
