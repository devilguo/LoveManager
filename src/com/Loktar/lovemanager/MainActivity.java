package com.Loktar.lovemanager;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity{
	
	public static Fragment[] fragments;
	public static LinearLayout[] linearLayouts;
	public static TextView[] fragTexts;
	
	
	//public int MARK = 0;
	public static final int DISTANT = 50;
	SlidingMenu slidingMenu;
	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.main_layout);
		
		//initialize fragments
		initFragment();
		initViews();
		addevents();
		
	}

	private void initFragment() {
		// TODO Auto-generated method stub
		fragments = new Fragment[4];
		fragments[0] = getSupportFragmentManager().findFragmentById(R.id.homefragment);
		fragments[1] = getSupportFragmentManager().findFragmentById(R.id.playfragment);
		fragments[2] = getSupportFragmentManager().findFragmentById(R.id.datingfragment);
		fragments[3] = getSupportFragmentManager().findFragmentById(R.id.sharefragment);
		
		getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[0]).commit();
		
		
	}

	private void initViews() {
		// TODO Auto-generated method stub
		linearLayouts = new LinearLayout[4];
		linearLayouts[0] = (LinearLayout) findViewById(R.id.lay1);
		linearLayouts[1] = (LinearLayout) findViewById(R.id.lay2);
		linearLayouts[2] = (LinearLayout) findViewById(R.id.lay3);
		linearLayouts[3] = (LinearLayout) findViewById(R.id.lay4);
		
		fragTexts = new TextView[4];
		fragTexts[0] = (TextView) findViewById(R.id.hometext);
		fragTexts[1] = (TextView) findViewById(R.id.playtext);
		fragTexts[2] = (TextView) findViewById(R.id.datingtext);
		fragTexts[3] = (TextView) findViewById(R.id.sharetext);
		
		fragTexts[0].setTextColor(getResources().getColor(R.color.lightseagreen));
		
		slidingMenu = new SlidingMenu(this);
		slidingMenu.setMode(SlidingMenu.LEFT);
		
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		//slidingMenu.setShadowWidthRes(R.dimen.shade_width);
		slidingMenu.setFadeDegree(0.35f);
		slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		
		slidingMenu.setMenu(R.layout.settingmenu);
		
		
	}

	private void addevents() {
		// TODO Auto-generated method stub
		
	}
	
	public void resetTabfootBg(){
		for (int i=0;i<4;i++){
			fragTexts[i].setTextColor(getResources().getColor(R.color.white));
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load, menu);
		return true;
	}
	
	public void LayoutOnclick(View v){
		
		resetTabfootBg();
		
		switch(v.getId()){
		case  R.id.lay1:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[0]).commit();
			fragTexts[0].setTextColor(getResources().getColor(R.color.lightseagreen));
//			MARK=0;
			break;
		case R.id.lay2:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[1]).commit();
			fragTexts[1].setTextColor(getResources().getColor(R.color.lightseagreen));
//			MARK=1;
			break;
		case R.id.lay3:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[2]).commit();
			fragTexts[2].setTextColor(getResources().getColor(R.color.lightseagreen));
//			MARK = 2;
			break;
		case R.id.lay4:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[3]).commit();
			fragTexts[3].setTextColor(getResources().getColor(R.color.lightseagreen));
//			MARK = 3;
			break;
		}
	}
	

	
	
	

}
