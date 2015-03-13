package com.Loktar.lovemanager;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class HomeListAdapter extends BaseAdapter {
	
	public Fragment ctx;
	
	public static Fragment[] sonFragment;
	public static TextView[] tv_titles;
	
	public HomeListAdapter(Fragment context){
		this.ctx = (HomeFragment)context;
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		if (position == 0){
			if (convertView == null){
				convertView = LayoutInflater.from(ctx.getActivity()).inflate(R.layout.homefragment_titlebg, null);
				
			}
			else {
				
			}
		}
		else if ( position == 1){
			if (convertView == null){
				convertView = LayoutInflater.from(ctx.getActivity()).inflate(R.layout.homefragment_content, null);
				sonFragment = new Fragment[3];
				sonFragment[0] = ctx.getActivity().getSupportFragmentManager().findFragmentById(R.id.home_state_fragment);
				sonFragment[1] = ctx.getActivity().getSupportFragmentManager().findFragmentById(R.id.home_pucture_fragment);
				sonFragment[2] = ctx.getActivity().getSupportFragmentManager().findFragmentById(R.id.home_days_fragment);
				
				ctx.getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
				.hide(sonFragment[2]).show(sonFragment[0]).commit();
				
				tv_titles = new TextView[3];
				tv_titles[0] = (TextView) convertView.findViewById(R.id.tv_home_state);
				tv_titles[1] = (TextView) convertView.findViewById(R.id.tv_home_pictures);
				tv_titles[2] = (TextView) convertView.findViewById(R.id.tv_home_days);
				
				tv_titles[0].setTextColor(this.ctx.getResources().getColor(R.color.palevioletred));
				
				OnClickListener titleLinstener = new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						resetTitles();
						if (v.getId() == tv_titles[0].getId()){
							ctx.getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
							.hide(sonFragment[2]).show(sonFragment[0]).commit();
							tv_titles[0].setTextColor(ctx.getResources().getColor(R.color.palevioletred));
						}
						if (v.getId() == tv_titles[1].getId()){
							ctx.getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
							.hide(sonFragment[2]).show(sonFragment[1]).commit();
							tv_titles[1].setTextColor(ctx.getResources().getColor(R.color.palevioletred));
						}
						if (v.getId() == tv_titles[2].getId()){
							ctx.getActivity().getSupportFragmentManager().beginTransaction().hide(sonFragment[0]).hide(sonFragment[1])
							.hide(sonFragment[2]).show(sonFragment[2]).commit();
							tv_titles[2].setTextColor(ctx.getResources().getColor(R.color.palevioletred));
						}
					}

					private void resetTitles() {
						// TODO Auto-generated method stub
						for (int i=0;i<3;i++){
							tv_titles[i].setTextColor(ctx.getResources().getColor(R.color.lightseagreen));
						}
					}
				};
				for (int i=0; i<3;i++){
					tv_titles[i].setOnClickListener(titleLinstener);
				}
				

				
			}
			else{
				
			}
		}
		
		return convertView;
	}

}









