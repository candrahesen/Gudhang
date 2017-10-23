package com.example.lenovopc.gudhang;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovopc.gudhang.tab.MyAdapter;
import com.example.lenovopc.gudhang.tab.SlidingTabLayout;

;

public class MainActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager=(ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(), this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
      //  mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorPrimaryLight));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);

     //   setupBottomNavigationView();
    }

 /*   private void setupBottomNavigationView() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
    	bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    		
    		@Override
    		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragment = fragmentManager.beginTransaction();
            //    Fragment fragment = null;
    			switch(item.getItemId()) {
    				case R.id.menu_daftar_produk:
    					fragment.replace(R.id.content,new DaftarProdukFragment()).commit();
    					return true;
    				case R.id.menu_search:
                        fragment.replace(R.id.content,new SearchFragment()).commit();
    					return true;
    				case R.id.menu_produk_disimpan:
                        fragment.replace(R.id.content,new ProdukDisimpanFragment()).commit();
    					return true;
     				case R.id.menu_profil:
                        fragment.replace(R.id.content,new ProfilFragment()).commit();
    					return true;

    			}
    			return false;
    		}
    	});
    } */
}
