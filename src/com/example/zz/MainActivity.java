package com.example.zz;



import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.example.myinterface.DonationFragment;
import com.example.myinterface.HomeFragment;
import com.example.myinterface.MeFragment;
import com.example.myinterface.PublishFragment;
import com.example.zz.ChangeColorIconWithTextView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener; 


public  class MainActivity extends FragmentActivity implements
OnPageChangeListener, OnClickListener {

	private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;  
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private HomeFragment myFragment1 = null;
    private PublishFragment myFragment2 = null;
    private DonationFragment myFragment3 = null;
    private MeFragment myFragment4 = null;
	
	 public static final int PAGE_ONE = 0;
	 public static final int PAGE_TWO = 1;
	 public static final int PAGE_THREE = 2;
	 public static final int PAGE_FOUR = 3;

	private List<ChangeColorIconWithTextView> mTabIndicator = new ArrayList<ChangeColorIconWithTextView>();

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); 
		setContentView(R.layout.activity_main);
	    //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);   
		
		setOverflowShowingAlways(); 
		getActionBar().setDisplayShowHomeEnabled(false);
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
	
		initDatas();
		mViewPager.setAdapter(mAdapter);	
		mViewPager.setOnPageChangeListener(this);
		
	}
	
	  private void initDatas()  
	    {  
		    myFragment1 = new HomeFragment();
	        myFragment2 = new PublishFragment();
	        myFragment3 = new DonationFragment();
	        myFragment4 = new MeFragment();
	        mTabs.add(myFragment1);  
	        mTabs.add(myFragment2);  
	        mTabs.add(myFragment3); 
	        mTabs.add(myFragment4);  
	       
	mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())  
    {  

    
        @Override  
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public Object instantiateItem(ViewGroup vg, int position) {
            return super.instantiateItem(vg, position);
        }

     

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case PAGE_ONE:
                    fragment = myFragment1;
                    break;
                case PAGE_TWO:
                    fragment = myFragment2;
                    break;
                case PAGE_THREE:
                    fragment = myFragment3;
                    break;
                case PAGE_FOUR:
                    fragment = myFragment4;
                    break;
            }
            return fragment;
        }
    };  

    initTabIndicator();  

}  

	private void initTabIndicator()
	{
		ChangeColorIconWithTextView one = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_one);
		ChangeColorIconWithTextView two = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_two);
		ChangeColorIconWithTextView three = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_three);
		ChangeColorIconWithTextView four = (ChangeColorIconWithTextView) findViewById(R.id.id_indicator_four);

		mTabIndicator.add(one);
		mTabIndicator.add(two);
		mTabIndicator.add(three);
		mTabIndicator.add(four);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);

		one.setIconAlpha(1.0f);
	}
	
	 

	
	public void onPageSelected(int arg0)
	{
	}
	
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels)
	{
		// Log.e("TAG", "position = " + position + " , positionOffset = "
		// + positionOffset);

		if (positionOffset > 0)
		{
			ChangeColorIconWithTextView left = mTabIndicator.get(position);
			ChangeColorIconWithTextView right = mTabIndicator.get(position + 1);

			left.setIconAlpha(1 - positionOffset);
			right.setIconAlpha(positionOffset);
		}

	}
	
	public void onPageScrollStateChanged(int state)
	{

	}
	
	
	
	public void onClick(View v)
	{

		resetOtherTabs();

		switch (v.getId())
		{
		case R.id.id_indicator_one:
			
			mViewPager.setCurrentItem(PAGE_ONE);
			mTabIndicator.get(0).setIconAlpha(1.0f);
			break;
		case R.id.id_indicator_two:
			
			mViewPager.setCurrentItem(PAGE_TWO);
			mTabIndicator.get(1).setIconAlpha(1.0f);
			break;
		case R.id.id_indicator_three:
			
			mViewPager.setCurrentItem(PAGE_THREE);
			mTabIndicator.get(2).setIconAlpha(1.0f);
			break;
		case R.id.id_indicator_four:
			
			mViewPager.setCurrentItem(PAGE_FOUR);
			mTabIndicator.get(3).setIconAlpha(1.0f);
			break;
			
		}

	}
	
	private void resetOtherTabs()
	{
		for (int i = 0; i < mTabIndicator.size(); i++)
		{
			mTabIndicator.get(i).setIconAlpha(0);
		}
	}
	
	
	
	public boolean onMenuOpened(int featureId, Menu menu)
	{
		if (featureId == Window.FEATURE_ACTION_BAR && menu != null)
		{
			if (menu.getClass().getSimpleName().equals("MenuBuilder"))
			{
				try
				{
					Method m = menu.getClass().getDeclaredMethod(
							"setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				} catch (Exception e)
				{
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}


	
	 private void setOverflowShowingAlways() {  
	        try {  
	            ViewConfiguration config = ViewConfiguration.get(this);  
	            Field menuKeyField = ViewConfiguration.class  
	                    .getDeclaredField("sHasPermanentMenuKey");  
	            menuKeyField.setAccessible(true);  
	            menuKeyField.setBoolean(config, false);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();  
	    inflater.inflate(R.menu.main, menu); 
	 
	    //MenuItem shareItem = menu.findItem(R.id.action_share);  
	   // ShareActionProvider provider = (ShareActionProvider) shareItem.getActionProvider();  
	   // provider.setShareIntent(getDefaultIntent()); 
	    //SearchView searchView = (SearchView) searchItem.getActionView();
	    return super.onCreateOptionsMenu(menu);
	}
	
	private Intent getDefaultIntent() {  
	    Intent intent = new Intent(Intent.ACTION_SEND);  
	    intent.setType("image/*");  
	    return intent;  
	}  

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
