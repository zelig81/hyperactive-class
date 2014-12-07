package ilyag.ac74;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton	ta, tw, ti;
	TableLayout		tbl;
	Button			b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ta = (ToggleButton) findViewById(R.id.toggleAge);
		tw = (ToggleButton) findViewById(R.id.toggleWeight);
		ti = (ToggleButton) findViewById(R.id.toggleId);
		tbl = (TableLayout) findViewById(R.id.tableLayout1);
		b = (Button) findViewById(R.id.button1);
		ta.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (ta.isChecked()) {
					tbl.setColumnCollapsed(1, true);
				} else {
					tbl.setColumnCollapsed(1, false);
				}
			}
		});
		
		tw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (tw.isChecked()) {
					tbl.setColumnCollapsed(2, true);
				} else {
					tbl.setColumnCollapsed(2, false);
				}
			}
		});
		ti.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (ti.isChecked()) {
					tbl.setColumnCollapsed(3, true);
				} else {
					tbl.setColumnCollapsed(3, false);
				}
			}
		});
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tbl.setColumnCollapsed(1, false);
				tbl.setColumnCollapsed(2, false);
				tbl.setColumnCollapsed(3, false);
				
			}
		});
	}
}
