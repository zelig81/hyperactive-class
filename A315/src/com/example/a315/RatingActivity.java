package com.example.a315;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

public class RatingActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_rating);
		Button b = (Button) this.findViewById(R.id.buttonR);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences prefs =
						RatingActivity.this.getSharedPreferences("options", MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				EditText et = (EditText) RatingActivity.this.findViewById(R.id.editText1);
				editor.putString("name", et.getText().toString());
				RatingBar rb = (RatingBar) RatingActivity.this.findViewById(R.id.ratingBar1);
				editor.putInt("rating", rb.getNumStars());
				CheckBox cb = (CheckBox) RatingActivity.this.findViewById(R.id.checkBox1);
				editor.putString("cFantasy", cb.isChecked() ? "Fiction" : "Non-fiction");
				editor.commit();
				RatingActivity.this.finish();
			}
		});
	}
	
}
