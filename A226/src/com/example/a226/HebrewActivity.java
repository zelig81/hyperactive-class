package com.example.a226;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HebrewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_translation);
		HashMap<String, String> map = new HashMap<>();
		map.put("one", "ehad");
		map.put("two", "shtaim");
		String s = getIntent().getStringExtra("word");
		String translation = map.get(s);
		if (translation == null){
			translation = "no translation";
		}
		TextView tv = (TextView)findViewById(R.id.textView1);
		tv.setText(translation);
		
	}

}
