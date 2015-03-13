package com.Loktar.lovemanager.home;

import com.Loktar.lovemanager.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class PictureGridListAdapter extends BaseAdapter {
	public PictureFragment frag;
	public int[] pictures;
	public ViewHolder holder;
	
	public PictureGridListAdapter(PictureFragment fragment, int[] pictureIDs){
		this.frag = fragment;
		this.pictures = pictureIDs;
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.pictures.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		if ( convertView == null){
			holder = new ViewHolder();
			convertView = LayoutInflater.from(this.frag.getActivity()).inflate(R.layout.home_picture_gridlist_item, null);
			holder.image = (ImageView) convertView.findViewById(R.id.home_picture_iv);
			
			convertView.setTag(holder);
			
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.image.setImageResource(this.pictures[position]);
		
		return convertView;
	}

	class ViewHolder{
		ImageView image;
	}
}



