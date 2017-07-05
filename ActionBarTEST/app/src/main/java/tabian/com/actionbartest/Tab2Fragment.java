package tabian.com.actionbartest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);


        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setAdapter(MainActivity2.mainAdapter);

        return view;
    }
    public static Tab2Fragment newInstance() {
        Tab2Fragment fragment = new Tab2Fragment();
        return fragment;
    }


}