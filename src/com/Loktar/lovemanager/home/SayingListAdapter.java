package com.Loktar.lovemanager.home;

import java.util.List;

import com.Loktar.lovemanager.R;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SayingListAdapter extends BaseAdapter {
	
	Fragment SayingFragment;
	Fragment ctx;
	List<SayingListItem> list;
	ViewHolder holder;
	
	public SayingListAdapter(Fragment fragment, List<SayingListItem> datalist){
		this.ctx = fragment;
		this.list = datalist;
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
		
		if (convertView == null){
			convertView = LayoutInflater.from(this.ctx.getActivity()).inflate(R.layout.home_saying_list_item, null);
			holder  = new ViewHolder();
			holder.contentText = (TextView) convertView.findViewById(R.id.home_saying_content_tv);
			
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.contentText.setText(this.list.get(position).getContent());
		Log.i("yangluo","list length"+position);
		return convertView;
	}
	class ViewHolder{
		TextView contentText;
	}

}











