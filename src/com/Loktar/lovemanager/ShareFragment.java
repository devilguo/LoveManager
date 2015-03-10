package com.Loktar.lovemanager;

import com.Loktar.lovemanager.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShareFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View shareLayout = inflater.inflate(R.layout.sharefragment_layout,
				container, false);
		return shareLayout;
	}

}
