package com.Loktar.lovemanager;



import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class HomeFragment extends Fragment {

	public  View homeLayout;
	
	public ListView homeList;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		homeLayout = inflater.inflate(R.layout.homefragment_list,
				container, false);
		
		homeList = (ListView) homeLayout.findViewById(R.id.home_listview);
		HomeListAdapter homeAdapter = new HomeListAdapter(this);
		homeList.setAdapter(homeAdapter);

		
		return homeLayout;
	}
	public View getHomeLayout(){
		return this.homeLayout;
	}


	
	
	

}
