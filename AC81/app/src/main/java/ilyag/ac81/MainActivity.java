package ilyag.ac81;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    SimpleCursorAdapter mAdapter;
    static final Worker[] workers = new Worker[]{
            new Worker("ilya", "yossi", 234234),
            new Worker("sdf", "sdfsdf", 43234),
            new Worker("ggsa", "ghfdsfewr", 23423),
            new Worker("asd", "asdasd", 11012),
            new Worker("os", "sdf", 123)
    };
    static final String[] PROJECTION = new String[] {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar pb = new ProgressBar(this);
        pb.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        getListView().setEmptyView(pb);

        ViewGroup root = (ViewGroup)findViewById(android.R.id.content);
        root.addView(pb);
        String
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

