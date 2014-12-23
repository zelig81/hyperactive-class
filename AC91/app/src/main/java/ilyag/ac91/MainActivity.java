package ilyag.ac91;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
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
                startActivity(intent);
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fileUri != null){
                    Toast.makeText(getApplication(),"path added to album:\n" + fileUri.getPath(),Toast.LENGTH_LONG).show();
                    list.add(fileUri);
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
            et.setText(fileUri.getPath());
            iv.setImageURI(fileUri);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
