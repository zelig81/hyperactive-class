package ilyag.ac91;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListAdapter;

import java.util.ArrayList;


public class ShowActivity extends ActionBarActivity {
    ImageAdapter ia;
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        gv = (GridView)findViewById(R.id.gridView);
        ia = new ImageAdapter(this);
        Intent intent = getIntent();
        ArrayList<Uri> list = intent.getParcelableArrayListExtra("paths");
        ia.setList(list);
        gv.setAdapter(ia);
    }


}
