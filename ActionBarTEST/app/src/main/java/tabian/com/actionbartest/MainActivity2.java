package tabian.com.actionbartest;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import tabian.com.actionbartest.adapter.CpuAdapter;
import tabian.com.actionbartest.adapter.MainAdapter;
import tabian.com.actionbartest.adapter.ProductAdapter;
import tabian.com.actionbartest.databases.DatabaseHandle;

public  class MainActivity2 extends FragmentActivity {

    private static final String TAG = "MainActivity";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public  static ViewPager mViewPager;
    public static int page;

    TabLayout tabLayout;

    public static MainAdapter mainAdapter ;
    public static CpuAdapter cpuAdapter ;


    public static   String color="";
    private Integer pc;
    public static   Integer price;
    public static String socket="";
    private int option[];

    public static String ramSupport="";


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
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                page=i;

                }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.cpu);
        tabLayout.getTabAt(1).setIcon(R.drawable.motherboard);
        tabLayout.getTabAt(2).setIcon(R.drawable.ram);
        tabLayout.getTabAt(3).setIcon(R.drawable.cards);
        tabLayout.getTabAt(4).setIcon(R.drawable.psu);
        tabLayout.getTabAt(5).setIcon(R.drawable.disk);
        tabLayout.getTabAt(6).setIcon(R.drawable.computer);


        mainAdapter= new MainAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListMainModels("",color));
        cpuAdapter= new CpuAdapter(this, R.layout.item_list_build_pc, DatabaseHandle.getInstance(this).getListCpuModels(pc));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment( Tab2Fragment.newInstance);
        adapter.addFragment( Tab3Fragment.ramFragment);
        adapter.addFragment( new Tab4Fragment());
        adapter.addFragment( new Tab5Fragment());
        adapter.addFragment( new Tab6Fragment());
        adapter.addFragment( new Tab7Fragment());
        viewPager.setAdapter(adapter);
    }
}
