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
import android.widget.Toast;

import java.util.List;

import tabian.com.actionbartest.R;
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

    public CpuAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CpuModel> objects) {
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
        final CpuModel cpuModel =  cpuModelList.get(position);
        TextView tv_species= (TextView) convertView.findViewById(R.id.tv_species);
        TextView tv_price= (TextView) convertView.findViewById(R.id.tv_price);
        ImageView ivStory = (ImageView) convertView.findViewById(R.id.iv_story);
        tv_species.setText(cpuModel.getSpecies());
        tv_price.setText(cpuModel.getPrice().toString()+"(VND)");
        String image[] = cpuModel.getImage().split(",");
        byte[] decodeByte = Base64.decode(image[1],Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(decodeByte,0,decodeByte.length);
        ivStory.setImageBitmap(bitmap);
        CardView cardView = (CardView) convertView.findViewById(R.id.cv_listProduct);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tab2Fragment.newInstance.Update(cpuModel.getSocket());
            }
        });

        return convertView;
    }
}
