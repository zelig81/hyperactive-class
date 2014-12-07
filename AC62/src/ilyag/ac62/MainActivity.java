package ilyag.ac62;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ArrayAdapter;
import android.text.InputFilter;
import android.text.Spanned;

public class MainActivity extends Activity {
	Button							b;
	Spinner							s;
	TextView						tv;
	ToggleButton					tb;
	AutoCompleteTextView			actv;
	
	private static final String[]	aStr	= { "Adi", "Anya", "Andrey", "David", "Benya" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b = (Button) findViewById(R.id.button1);
		s = (Spinner) findViewById(R.id.spin1);
		tv = (TextView) findViewById(R.id.textView);
		ArrayAdapter<String> adapter =
				new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, aStr);
		actv = (AutoCompleteTextView) findViewById(R.id.actv);
		actv.setAdapter(adapter);
		tb = (ToggleButton) findViewById(R.id.togBut);
		
		InputFilter inFi = new InputFilter() {
			
			@Override
			public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				boolean append = false;
				String changeText = source.toString().substring(start, end);
				StringBuilder sb = new StringBuilder(dest.toString());
				if (dstart == sb.length()) {
					append = true;
					sb.append(changeText);
				} else {
					sb.replace(dstart, dend, changeText);
				}
				if (sb.toString().contains("Bin Laden")) {
					if (append) {
						return "";
					} else {
						return dest.subSequence(dstart, dend);
					}
				}
				
				return null;
			}
		};
		actv.setFilters(new InputFilter[] { inFi });
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				StringBuilder sb = new StringBuilder(actv.getText());
				boolean interested = tb.isChecked();
				sb.append(" from ").append(s.getSelectedItem());
				sb.append(" is ").append(interested ? "" : "not").append(" interested in local news");
				tv.setText(sb.toString());
				
			}
		});
		
	}
}
