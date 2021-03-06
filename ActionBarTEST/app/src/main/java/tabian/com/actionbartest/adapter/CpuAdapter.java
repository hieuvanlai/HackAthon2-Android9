package tabian.com.actionbartest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import tabian.com.actionbartest.MainActivity2;
import tabian.com.actionbartest.R;
import tabian.com.actionbartest.Tab1Fragment;
import tabian.com.actionbartest.Tab2Fragment;
import tabian.com.actionbartest.Tab3Fragment;
import tabian.com.actionbartest.databases.CpuModel;

/**
 * Created by hieuv on 7/3/2017.
 */

public class CpuAdapter extends ArrayAdapter<CpuModel> {
    private Context context;
    private int resource;
    private List<CpuModel> cpuModelList;
    private int potioncheck;

    public CpuAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CpuModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.cpuModelList = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.item_list_build_pc,null);
        final CpuModel cpuModel =  cpuModelList.get(position);
        TextView tv_species= (TextView) convertView.findViewById(R.id.tv_species);
        TextView tv_price= (TextView) convertView.findViewById(R.id.tv_price);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);
        tv_species.setText(cpuModel.getSpecies());
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String numberAsString = decimalFormat.format(cpuModel.getPrice());
        tv_price.setText(numberAsString+"(VND)");
        String image[] = cpuModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1],Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(decodeByte,0,decodeByte.length);
        ivStory.setImageBitmap(bitmap);
        CardView cardView = (CardView) convertView.findViewById(R.id.cv_listProduct);
        View view = convertView.findViewById(R.id.v_color);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                potioncheck=position;
                Tab2Fragment.newInstance.Update(cpuModel.getSocket());
                MainActivity2.mViewPager.setCurrentItem(MainActivity2.page+1,true);
                Tab1Fragment.Update();

            }
        });
        if (potioncheck==position){
            view.setBackgroundColor(Color.RED);
        }
        return convertView;
    }
}
