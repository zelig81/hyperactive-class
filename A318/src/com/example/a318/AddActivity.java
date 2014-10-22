package com.example.a318;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AddActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_add);
		final EditText name = (EditText) this.findViewById(R.id.editText1);
		final EditText age = (EditText) this.findViewById(R.id.editText2);
		final CheckBox isMale = (CheckBox) this.findViewById(R.id.checkBox1);
		Button b = (Button) this.findViewById(R.id.buttonA);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Client c =
						new Client(name.getText().toString(), Integer.parseInt(age.getText()
								.toString()), isMale.isChecked());
				Intent data = AddActivity.this.getIntent();
				data.putExtra("client", c);
				AddActivity.this.setResult(1, data);
				AddActivity.this.finish();
				
			}
		});
	}
	
}
