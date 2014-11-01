package ilyag.ac41;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageButton	ib;
	ImageView	iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ib = (ImageButton) findViewById(R.id.imageButton1);
		iv = (ImageView) findViewById(R.id.imageView2);
		ib.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TransitionDrawable td = (TransitionDrawable) iv.getDrawable();
				td.startTransition(3000);
			}
		});
	}
}
