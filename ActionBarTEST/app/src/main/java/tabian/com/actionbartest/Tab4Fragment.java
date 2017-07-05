package tabian.com.actionbartest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class Tab4Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4_layout,container,false);


        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setAdapter(MainActivity2.vgaAdapter);

        return view;
    }
    public static Tab4Fragment newInstance() {
        Tab4Fragment fragment = new Tab4Fragment();
        return fragment;
    }
    public void   UpdateAdapter(){
        mListView.setAdapter(MainActivity2.cpuAdapter);
    }

}