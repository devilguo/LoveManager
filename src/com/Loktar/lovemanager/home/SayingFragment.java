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
		//******�������ã������б���ʾ��ȫ
		SayingListAdapter ada = (SayingListAdapter) sayingList.getAdapter();
		int totalHeight = 0;
		for (int i = 0, len = ada.getCount(); i < len; i++) { //listAdapter.getCount()�������������Ŀ
		View listItem = ada.getView(i, null, sayingList);
		listItem.measure(0, 0); //��������View �Ŀ��
		totalHeight += listItem.getMeasuredHeight(); //ͳ������������ܸ߶�
		}

		ViewGroup.LayoutParams params = sayingList.getLayoutParams();
		params.height = totalHeight + (sayingList.getDividerHeight() * (ada.getCount() - 1));
		//listView.getDividerHeight()��ȡ�����ָ���ռ�õĸ߶�
		//params.height���õ�����ListView������ʾ��Ҫ�ĸ߶�
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
