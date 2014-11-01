package ilyag.ac43;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView iv = (ImageView) findViewById(R.id.imageView1);
		Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.moving);
		iv.startAnimation(a);
	}
}
