package ilyag.ac61;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import static org.xmlpull.v1.XmlPullParser.*;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class MainActivity extends Activity {
	
	class Download extends AsyncTask<String, Integer, String> {
		
		@Override
		protected String doInBackground(String... urls) {
			String input = urls[0];
			StringBuilder sb = new StringBuilder();
			try {
				InputStream is = new URL(input).openStream();
				XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
				factory.setNamespaceAware(true);
				XmlPullParser xpp = factory.newPullParser();
				xpp.setInput(is, null);
				int et = xpp.getEventType();
				int readiness = 0;
				int numOfArticles = 0;
				while (et != END_DOCUMENT) {
					if (et == START_TAG) {
						if ("item".equals(xpp.getName())) {
							readiness = 1;
							Log.e("ilyag", "in item");
						}
						if (readiness == 1 && "title".equals(xpp.getName())) {
							readiness = 2;
							Log.e("ilyag", "in item/title");
						}
					}
					
					if (et == END_TAG) {
						if ("item".equals(xpp.getName())) {
							readiness = 0;
							Log.e("ilyag", "out of item");
						}
						
						if (readiness == 2 && "title".equals(xpp.getName())) {
							readiness = 1;
							Log.e("ilyag", "out of item/title");
						}
					}
					
					if (readiness == 2 && et == TEXT) {
						numOfArticles++;
						publishProgress(numOfArticles);
						sb.append("\n").append(xpp.getText());
					}
					et = xpp.next();
				}
			} catch (IOException ex) {
				Log.e("ilyag", ex.getMessage());
			} catch (XmlPullParserException ex) {
				Log.e("ilyag", ex.getMessage());
			}
			return sb.toString();
		}
		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result); // To change body of generated methods, choose Tools | Templates.
			tv.setText(tv.getText().toString() + result + "\nMade it!");
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			tv.setText("Started to download...");
			Log.e("ilyag", "started to download");
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			tv.setText("downloaded " + values[0] + " articles");
			
		}
		
	}
	
	Button		b;
	
	TextView	tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		b = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.tv1);
		tv.setMovementMethod(new ScrollingMovementMethod());
		Log.e("ilyag", "in the app");
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new Download().execute("http://feeds.newsru.com/il/www/news/all");
				Log.e("ilyag", "finished");
			}
		});
		
	}
}
