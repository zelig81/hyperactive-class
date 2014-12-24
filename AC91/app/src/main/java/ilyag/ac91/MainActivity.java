package ilyag.ac91;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Geocoder;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.media.ThumbnailUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    EditText et;
    Button bShot, bSave, bShow;
    ImageView iv;
    Uri fileUri;
    ArrayList<Uri> list = new ArrayList<>();
    static final int requestCode = 234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editText);
        bShot = (Button)findViewById(R.id.bShot);
        bSave = (Button)findViewById(R.id.bSave);
        bShow = (Button)findViewById(R.id.bShow);
        iv = (ImageView)findViewById(R.id.imageView);

        bShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                File dir = new File(Environment.getExternalStorageDirectory(),"My photos");
                dir.mkdirs();
                Calendar calendar = Calendar.getInstance();
                File file = new File(dir,"shot" + calendar.getTime().toString() + ".jpg");
                fileUri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent,requestCode);
            }
        });

        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ShowActivity.class);
                intent.putParcelableArrayListExtra("paths", list);
                startActivity(intent);
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileUri != null){
                    Toast.makeText(getApplication(),"path added to album:\n" + fileUri.getPath(),Toast.LENGTH_LONG).show();
                    list.add(fileUri);
                    et.setText("");
                    iv.setImageBitmap(null);
                }else{
                    Toast.makeText(getApplication(),R.string.toastNoShot, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MainActivity.requestCode && resultCode == RESULT_OK){
            Toast.makeText(getApplication(),"saved on path:\n" + fileUri.getPath(),Toast.LENGTH_LONG).show();
            Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath());
            ExifInterface ei;
            try {
                ei = new ExifInterface(fileUri.getPath());
                //ei.setAttribute(ExifInterface.TAG_GPS_LATITUDE, Geocoder.);
                et.setText(ei.getAttribute(ExifInterface.TAG_GPS_LATITUDE) + "/" + ei.getAttribute(ExifInterface.TAG_GPS_LONGITUDE) + "/" + ei.getAttribute(ExifInterface.TAG_MAKE));
            } catch (IOException e) {
                Log.e("ilyag", e.getMessage());
            }

            Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, 400, 300);
            iv.setImageBitmap(thumbnail);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
