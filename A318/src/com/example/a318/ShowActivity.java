package com.example.a318;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = (TextView) this.findViewById(R.id.textView1);
		try {
			FileInputStream fis = this.openFileInput("array.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			StringBuilder sb = new StringBuilder();
			while (ois.read() != -1) {
				
				sb.append(ois.readObject() + "\n");
			}
			tv.setText(sb.toString());
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Button b = (Button) this.findViewById(R.id.buttonS);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ShowActivity.this.finish();
			}
		});
	}
	
}
