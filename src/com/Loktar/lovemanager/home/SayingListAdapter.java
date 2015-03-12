package com.Loktar.lovemanager.home;

import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SayingListAdapter extends BaseAdapter {
	
	Fragment SayingFragment;
	Fragment ctx;
	List<SayingListItem> list;
	
	public SayingListAdapter(Fragment fragment, List<SayingListItem> list){
		this.ctx = fragment;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.list.get(0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}











