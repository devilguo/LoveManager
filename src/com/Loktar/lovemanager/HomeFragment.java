package com.Loktar.lovemanager;



import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	public static Fragment[] sonFragment;
	public static TextView[] tv_titles;
	public static View homeLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		homeLayout = inflater.inflate(R.layout.homefragment_layout,
				container, false);
		sonFragment = new Fragment[3];
		sonFragment[0] = getActivity().getSupportFragmentManager().findFragmentById(R.id.home_state_fragment);
		sonFragment[1] = getActivity().getSupportFragmentManager().findFragmentById(R.id.home_pucture_fragment);
		sonFragment[2] = getActivity().getSupportFragmentManager().findFragmentById(R.id.home_days_fragment);
		
		getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
		.hide(sonFragment[2]).show(sonFragment[0]).commit();
		
		initViews();
		addEvents();
		
		return homeLayout;
	}



	private void initViews() {
		// TODO Auto-generated method stub
		tv_titles = new TextView[3];
		tv_titles[0] = (TextView) homeLayout.findViewById(R.id.tv_home_state);
		tv_titles[1] = (TextView) homeLayout.findViewById(R.id.tv_home_pictures);
		tv_titles[2] = (TextView) homeLayout.findViewById(R.id.tv_home_days);
		
		tv_titles[0].setTextColor(getResources().getColor(R.color.titlecolor));
		
	}
	
	private void addEvents() {
		// TODO Auto-generated method stub
	
		
		OnClickListener titleLinstener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				resetTitles();
				if (v.getId() == tv_titles[0].getId()){
					getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
					.hide(sonFragment[2]).show(sonFragment[0]).commit();
					tv_titles[0].setTextColor(getResources().getColor(R.color.titlecolor));
				}
				if (v.getId() == tv_titles[1].getId()){
					getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
					.hide(sonFragment[2]).show(sonFragment[1]).commit();
					tv_titles[1].setTextColor(getResources().getColor(R.color.titlecolor));
				}
				if (v.getId() == tv_titles[2].getId()){
					getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
					.hide(sonFragment[2]).show(sonFragment[2]).commit();
					tv_titles[2].setTextColor(getResources().getColor(R.color.titlecolor));
				}
			}

			private void resetTitles() {
				// TODO Auto-generated method stub
				for (int i=0;i<3;i++){
					tv_titles[i].setTextColor(getResources().getColor(R.color.lightseagreen));
				}
			}
		};
		for (int i=0; i<3;i++){
			tv_titles[i].setOnClickListener(titleLinstener);
		}
		
	}
	
	
	

}
