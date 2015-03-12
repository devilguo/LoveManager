package com.Loktar.lovemanager.home;

import java.util.ArrayList;
import java.util.List;

import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SayingFragment extends Fragment {
	private static View sayingFragment;
	public ListView sayingList;
	public SayingListAdapter adapter;
	public List<SayingListItem> data = new ArrayList<SayingListItem>() ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		sayingFragment = inflater.inflate(R.layout.home_saying_list,
				container, false);
		sayingList = (ListView) sayingFragment.findViewById(R.id.home_saying_listview);
		setData();
		Log.i("yangluo","list length"+data.size());
		adapter = new SayingListAdapter(this, data);
		
		sayingList.setAdapter(adapter);
		
		reSetListItemHeight();
		
		
		
		return sayingFragment;
	}

	private void reSetListItemHeight() {
		// TODO Auto-generated method stub
		//******必须设置，否则列表显示不全
		SayingListAdapter ada = (SayingListAdapter) sayingList.getAdapter();
		int totalHeight = 0;
		for (int i = 0, len = ada.getCount(); i < len; i++) { //listAdapter.getCount()返回数据项的数目
		View listItem = ada.getView(i, null, sayingList);
		listItem.measure(0, 0); //计算子项View 的宽高
		totalHeight += listItem.getMeasuredHeight(); //统计所有子项的总高度
		}

		ViewGroup.LayoutParams params = sayingList.getLayoutParams();
		params.height = totalHeight + (sayingList.getDividerHeight() * (ada.getCount() - 1));
		//listView.getDividerHeight()获取子项间分隔符占用的高度
		//params.height最后得到整个ListView完整显示需要的高度
		sayingList.setLayoutParams(params);
		
	}

	private void setData() {
		// TODO Auto-generated method stub
		for (int i=0; i<20; i++){
			SayingListItem item = new SayingListItem();
			item.setContent("what the sunny day! "+i);
			data.add(item);
			
		}
	}
	
	
}
