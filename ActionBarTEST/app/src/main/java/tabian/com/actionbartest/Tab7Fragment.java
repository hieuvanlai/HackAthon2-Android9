package tabian.com.actionbartest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import tabian.com.actionbartest.adapter.MainAdapter;
import tabian.com.actionbartest.adapter.ProductAdapter;
import tabian.com.actionbartest.databases.DatabaseHandle;


public class Tab7Fragment extends Fragment {
    private static final String TAG = "Tab7Fragment";
    public static String size="";
    public String size2="";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        mListView = (ListView) view.findViewById(R.id.listView);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(),R.layout.item_list_build_pc,DatabaseHandle.getInstance(getActivity()).getListProductModels("Case",MainActivity2.color,size));
        mListView.setAdapter(productAdapter);
        return view;
    }

}