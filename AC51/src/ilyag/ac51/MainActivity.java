package ilyag.ac51;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.animation.AnimationUtils;

public class MainActivity extends Activity {
	EditText	et;
	ImageView	iv;
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id = item.getItemId();
		Log.e("test", "got id " + id + " when maa=" + R.id.maa + "/mab=" + R.id.mab + "/manimate=" + R.id.manimate);
		if (id == R.id.maa) {
			String text = et.getText().toString();
			text = text + "? Could be?";
			et.setText(text);
			Log.e("test", "chosen add after");
		} else if (id == R.id.mab) {
			String text = et.getText().toString();
			text = "So it should be:" + text;
			et.setText(text);
			Log.e("test", "chosen add before");
		} else if (id == R.id.manimate) {
			Animation a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_anim);
			iv.startAnimation(a);
			Log.e("test", "chosen animation");
		} else {
			return false;
		}
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.editText);
		iv = (ImageView) findViewById(R.id.imageView);
		registerForContextMenu(et);
		registerForContextMenu(iv);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if (v == et) {
			getMenuInflater().inflate(R.menu.edit_text_menu, menu);
		}
		if (v == iv) {
			getMenuInflater().inflate(R.menu.image_view_menu, menu);
		}
	}
	
}
