package tabian.com.actionbartest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import tabian.com.actionbartest.MainActivity2;
import tabian.com.actionbartest.R;
import tabian.com.actionbartest.Tab2Fragment;
import tabian.com.actionbartest.databases.ProductModel;

/**
 * Created by hieuv on 7/3/2017.
 */

public class ProductAdapter extends ArrayAdapter<ProductModel> {
    private Context context;
    private int resource;
    private List<ProductModel> cpuModelList;

    public ProductAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ProductModel> objects) {
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
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String numberAsString = decimalFormat.format(productModel.getPrice());
        tv_price.setText(numberAsString+"(VND)");
        try {
            String image[] = productModel.getImage().split(",");
            byte[] decodeByte = Base64.decode(image[1],Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(decodeByte,0,decodeByte.length);
            ivStory.setImageBitmap(bitmap);
        }
        catch (Exception e){
            ivStory.setImageResource(R.drawable.cards);
        }
        CardView cardView = (CardView) convertView.findViewById(R.id.cv_listProduct);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity2.page!=6){
                    MainActivity2.mViewPager.setCurrentItem(MainActivity2.page+1,true);
                }



            }
        });
        return convertView;
    }
}
