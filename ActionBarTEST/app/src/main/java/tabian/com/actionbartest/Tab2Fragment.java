package tabian.com.actionbartest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import tabian.com.actionbartest.adapter.MainAdapter;
import tabian.com.actionbartest.databases.DatabaseHandle;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);

        MainAdapter mainAdapter= new MainAdapter(getActivity(),R.layout.item_list_build_pc, DatabaseHandle.getInstance(getActivity()).getListMainModels("",MainActivity2.color));
        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setAdapter(mainAdapter);
        return view;
    }
    public static Tab2Fragment newInstance =new Tab2Fragment();
    public void Update(String socket){
            MainAdapter mainAdapter = new MainAdapter(getActivity(), R.layout.item_list_build_pc, DatabaseHandle.getInstance(getActivity()).getListMainModels(socket, MainActivity2.color));
            mListView.setAdapter(mainAdapter);

    }


}