package com.Loktar.lovemanager;

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

public class MainActivity extends FragmentActivity implements OnGestureListener {
	
	public static Fragment[] fragments;
	public static LinearLayout[] linearLayouts;
	public static TextView[] fragTexts;
	
	public static GestureDetector detector;
	public int MARK = 0;
	public static final int DISTANT = 50;
	
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
		
		detector = new GestureDetector(this);
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
			MARK=0;
			break;
		case R.id.lay2:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[1]).commit();
			fragTexts[1].setTextColor(getResources().getColor(R.color.lightseagreen));
			MARK=1;
			break;
		case R.id.lay3:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[2]).commit();
			fragTexts[2].setTextColor(getResources().getColor(R.color.lightseagreen));
			MARK = 2;
			break;
		case R.id.lay4:
			getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
			.hide(fragments[2]).hide(fragments[3]).show(fragments[3]).commit();
			fragTexts[3].setTextColor(getResources().getColor(R.color.lightseagreen));
			MARK = 3;
			break;
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		
		return detector.onTouchEvent(event);
	}
	

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		
		resetTabfootBg();
		
		if (0 == MARK){
			if (arg1.getX()>arg0.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[1]).commit();
				fragTexts[1].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=1;
			}
			else{
				fragTexts[0].setTextColor(getResources().getColor(R.color.lightseagreen));
			}
		}
		else if (1 == MARK){
			if(arg1.getX()>arg0.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[2]).commit();
				fragTexts[2].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=2;
			}
			else if (arg0.getX()>arg1.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[0]).commit();
				fragTexts[0].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=0;
			}
			else {
				fragTexts[1].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=1;
			}
		}
		else if (2 == MARK){
			if(arg1.getX()>arg0.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[3]).commit();
				fragTexts[3].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=3;
			}
			else if (arg0.getX()>arg1.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[1]).commit();
				fragTexts[1].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=1;
			}
			else {
				fragTexts[2].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=2;
			}
		}
		else if (3 == MARK){
			if (arg0.getX()>arg1.getX()+DISTANT){
				getSupportFragmentManager().beginTransaction().hide(fragments[0]).hide(fragments[1])
				.hide(fragments[2]).hide(fragments[3]).show(fragments[2]).commit();
				fragTexts[2].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK=2;
			}
			else{
				fragTexts[3].setTextColor(getResources().getColor(R.color.lightseagreen));
				MARK = 3;
			}
		}
		
		
		
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	

}
