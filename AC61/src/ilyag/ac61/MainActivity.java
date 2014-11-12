package ilyag.ac61;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class MainActivity extends Activity {

    Button b;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.tv1);
        b.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try {
                    new Download().execute(new URL("http://rss.nytimes.com/services/xml/rss/nyt/internationalhome.xml"));
                } catch (MalformedURLException ex) {
                    Log.e("ilyag", ex.getMessage());
                }
            }
        });

    }

    class Download extends AsyncTask<URL, Integer, String> {

        @Override
        protected String doInBackground(URL... urls) {
            URL input = urls[0];
            try {
                InputStream is = input.openStream();
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new InputStreamReader(is));
            } catch (IOException ex) {
                Log.e("ilyag", ex.getMessage());
            } catch (XmlPullParserException ex) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result); //To change body of generated methods, choose Tools | Templates.
            tv.setText("Made it!");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tv.setText("Started to download...");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values); 
            tv.setText("downloaded " + values[0] + " articles");
            
        }
        
        

    }
}
