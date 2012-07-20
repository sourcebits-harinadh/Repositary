package com.sourcebits.hoppr;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{

	private Context mContext; 
	private int mLayoutResourceId;    
	private ArrayList<Place> mData = null;

	

	public CustomAdapter(Context context, int layoutResourceId, ArrayList<Place> data) {

		super();
		this.mLayoutResourceId = layoutResourceId;
		this.mContext = context;
		this.mData = data;
	}

	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		RelativeLayout row = null;


		if(convertView == null)
		{
			LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();

			row = (RelativeLayout)inflater.inflate(mLayoutResourceId, parent, false);

			ImageView icon = (ImageView)row.findViewById(R.id.profIcon);

			icon.setBackgroundResource(R.drawable.icon_profile);

			TextView title =   (TextView)row.findViewById(R.id.listTxtTitle);

			TextView subTitle =   (TextView)row.findViewById(R.id.listTxtSubTitle);

			title.setText(((Place)mData.get(position)).getTitle());

			subTitle.setText(((Place)mData.get(position)).getSubTitle());


		}
		else
		{
			row = (RelativeLayout)convertView;


			ImageView icon = (ImageView)row.findViewById(R.id.profIcon);

			icon.setBackgroundResource(R.drawable.icon_profile);

			TextView title =   (TextView)row.findViewById(R.id.listTxtTitle);

			TextView subTitle =   (TextView)row.findViewById(R.id.listTxtSubTitle);

			title.setText(((Place)mData.get(position)).getTitle());

			subTitle.setText(((Place)mData.get(position)).getSubTitle());
		}


		return row;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position ;
	}


	protected ArrayList<Place> getmData() {
		return mData;
	}

	protected void setmData(ArrayList<Place> mData) {
		this.mData = mData;
	}
	
	protected void addPlaceObj(Place placeObj) {
		this.mData.add(placeObj);
		this.notifyDataSetChanged();
	}
	
}
