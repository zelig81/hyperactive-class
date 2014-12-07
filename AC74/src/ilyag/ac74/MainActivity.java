package ilyag.ac74;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton	ta, tw, ti;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ta = (ToggleButton) findViewById(R.id.toggleAge);
		tw = (ToggleButton) findViewById(R.id.toggleWeight);
		ti = (ToggleButton) findViewById(R.id.toggleId);
		ta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (ta.isChecked()) {
					
				}
			}
		});
		
	}
}
