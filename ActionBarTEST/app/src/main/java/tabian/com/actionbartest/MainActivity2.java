package tabian.com.actionbartest;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import tabian.com.actionbartest.adapter.CpuAdapter;
import tabian.com.actionbartest.adapter.MainAdapter;
import tabian.com.actionbartest.adapter.PsuAdapter;
import tabian.com.actionbartest.adapter.RamAdapter;
import tabian.com.actionbartest.adapter.VgaAdapter;
import tabian.com.actionbartest.databases.DatabaseHandle;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    TabLayout tabLayout;
    public static MainAdapter mainAdapter ;
    public static CpuAdapter cpuAdapter ;
    public static RamAdapter ramAdapter ;
    public static VgaAdapter vgaAdapter ;
    public static PsuAdapter psuAdapter ;
    private  String color="";
    private Integer pc;
    private  Integer price;
    private int option[];
    public  static  String socket="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        option = intent.getIntArrayExtra("option");
        price= option[0];
        pc=option[1];
        switch (option[2]){
            case 1:
                color="WHITE";
                break;
            case 2:
                color="GREEN";
                break;
            case 3:
                color="BLUE";
                break;
            case 4:
                color="RED";
                break;
            case 5:
                color="RGB";
                break;
            case 0:
                color="";
                break;
        }



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.cpu);
        tabLayout.getTabAt(1).setIcon(R.drawable.motherboard);
        tabLayout.getTabAt(2).setIcon(R.drawable.ram);
        tabLayout.getTabAt(3).setIcon(R.drawable.cards);
        tabLayout.getTabAt(4).setIcon(R.drawable.psu);

        mainAdapter= new MainAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListMainModels("",color));
        cpuAdapter= new CpuAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListCpuModels(pc));
        Toast.makeText(this, "Oncreate", Toast.LENGTH_SHORT).show();
        ramAdapter= new RamAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListProductModels(color,"DDR4"));
        vgaAdapter= new VgaAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListProductModels(color,null));
        psuAdapter= new PsuAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListProductModels(null,null));
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        adapter.addFragment(new Tab4Fragment());
        adapter.addFragment(new Tab5Fragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
}
