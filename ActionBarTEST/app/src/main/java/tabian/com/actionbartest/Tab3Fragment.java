package tabian.com.actionbartest;

        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import tabian.com.actionbartest.adapter.MainAdapter;
        import tabian.com.actionbartest.adapter.ProductAdapter;
        import tabian.com.actionbartest.databases.DatabaseHandle;


public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private ListView mListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout,container,false);
        mListView = (ListView) view.findViewById(R.id.listView);
        mListView.setAdapter(new ProductAdapter(getActivity(),R.layout.item_list_build_pc, DatabaseHandle.getInstance(getActivity()).getListProductModels("Ram",MainActivity2.color,"")));

        return view;
    }
    public static  Tab3Fragment ramFragment= new Tab3Fragment();


    public void Update(String ramOrSize){
            ProductAdapter ramAdapter= new ProductAdapter(getActivity(),R.layout.item_list_build_pc, DatabaseHandle.getInstance(getActivity()).getListProductModels("Ram",MainActivity2.color,ramOrSize));
            mListView.setAdapter(ramAdapter);

    }

}