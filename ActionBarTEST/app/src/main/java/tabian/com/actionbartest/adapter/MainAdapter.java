package tabian.com.actionbartest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tabian.com.actionbartest.R;
import tabian.com.actionbartest.databases.MainModel;

/**
 * Created by hieuv on 7/3/2017.
 */

public class MainAdapter extends ArrayAdapter<MainModel> {
    private Context context;
    private int resource;
    private List<MainModel> mainModelList;

    public MainAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<MainModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.mainModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_list_build_pc,null);
        MainModel mainModel =  mainModelList.get(position);
        TextView tv_species= (TextView) convertView.findViewById(R.id.tv_species);
        TextView tv_price= (TextView) convertView.findViewById(R.id.tv_price);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);
        tv_species.setText(mainModel.getSpecies());
        tv_price.setText(mainModel.getPrice().toString()+"(VND)");
        String image[] = mainModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1],Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(decodeByte,0,decodeByte.length);
        ivStory.setImageBitmap(bitmap);

        return convertView;
    }
}
