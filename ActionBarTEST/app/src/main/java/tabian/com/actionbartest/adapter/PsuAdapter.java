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
import tabian.com.actionbartest.databases.ProductModel;

/**
 * Created by hieuv on 7/3/2017.
 */

public class PsuAdapter extends ArrayAdapter<ProductModel> {
    private Context context;
    private int resource;
    private List<ProductModel> cpuModelList;

    public PsuAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ProductModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.cpuModelList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_list_build_pc,null);
        ProductModel productModel =  cpuModelList.get(position);
        TextView tv_species= (TextView) convertView.findViewById(R.id.tv_species);
        TextView tv_price= (TextView) convertView.findViewById(R.id.tv_price);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);
        tv_species.setText(productModel.getSpecies());
        tv_price.setText(productModel.getPrice().toString()+"(VND)");
        String image[] = productModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1],Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(decodeByte,0,decodeByte.length);
        ivStory.setImageBitmap(bitmap);

        return convertView;
    }
}
