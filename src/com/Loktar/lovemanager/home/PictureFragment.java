package com.Loktar.lovemanager.home;

import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class PictureFragment extends Fragment {
	public View pictureFragment;
	public int[] pictureID = new int[]{
			R.drawable.alien1,R.drawable.alien2,R.drawable.balloon,
			R.drawable.bear, R.drawable.beaver,R.drawable.birthdaycake,
			R.drawable.chocolatecake,R.drawable.david,R.drawable.davinci,
			R.drawable.dragon,R.drawable.earth,R.drawable.fireworks1,
			R.drawable.fireworks2,R.drawable.fish,R.drawable.frog1,
			R.drawable.frog2,R.drawable.hand,R.drawable.hitchcock,
	};
	
//	public PictureGridListAdapter adapter;
	public GridView gridList;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		pictureFragment = inflater.inflate(R.layout.home_picture_gridlist, container, false);
		gridList = (GridView) pictureFragment.findViewById(R.id.home_picture_gridview);
		
		gridList.setAdapter(new PictureGridListAdapter(this, pictureID));
		
		reSetListItemHeight();
		return pictureFragment;
	}
	
	private void reSetListItemHeight() {
		// TODO Auto-generated method stub
		//******�������ã������б���ʾ��ȫ
		PictureGridListAdapter ada = (PictureGridListAdapter) gridList.getAdapter();
		int totalHeight = 0;
		for (int i = 0, len = ada.getCount(); i < len; i++) { //listAdapter.getCount()�������������Ŀ
			View gridItem = ada.getView(i, null, gridList);
			gridItem.measure(0, 0); //��������View �Ŀ��
			totalHeight += gridItem.getMeasuredHeight(); //ͳ������������ܸ߶�
		}

		ViewGroup.LayoutParams params = gridList.getLayoutParams();
		params.height = totalHeight/3+1;
		
		//listView.getDividerHeight()��ȡ�����ָ���ռ�õĸ߶�
		//params.height���õ�����ListView������ʾ��Ҫ�ĸ߶�
		gridList.setLayoutParams(params);
		
	}
	

}
