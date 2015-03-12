package com.Loktar.lovemanager.home;

import java.util.List;

import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SayingFragment extends Fragment {
	private static View sayingFragment;
	public ListView sayingList;
	public SayingListAdapter adapter;
	public List<SayingListItem> data ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		sayingFragment = inflater.inflate(R.layout.home_saying_list,
				container, false);
		sayingList = (ListView) sayingFragment.findViewById(R.id.home_saying_listview);
		setData();
		
		adapter = new SayingListAdapter(this, data);
		
		
		return sayingFragment;
	}

	private void setData() {
		// TODO Auto-generated method stub
		for (int i=0; i<10; i++){
			SayingListItem item = new SayingListItem("what the weather today "+i);
			
			
		}
	}
	
	
}
