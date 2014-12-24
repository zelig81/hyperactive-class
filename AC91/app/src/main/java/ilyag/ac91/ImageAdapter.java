package ilyag.ac91;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gorban on 12/24/2014.
 */
public class ImageAdapter extends BaseAdapter{
    Context context;
    ArrayList<Uri> list = new ArrayList<>();

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if(list.size() == 0){
            return null;
        }else {
            return list.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position / 4;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Bitmap bitmap = BitmapFactory.decodeFile(list.get(position).getPath());
        Bitmap thumbnail = ThumbnailUtils.extractThumbnail(bitmap, 40, 30);
        imageView.setImageBitmap(thumbnail);
        return imageView;
    }


    public void setList(ArrayList<Uri> list) {
        this.list = list;
    }
}
