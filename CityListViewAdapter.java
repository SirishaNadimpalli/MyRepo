
/*
 * Adapter for getting CityList 
 */
package com.forkfly.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.forkfly.beans.Regions;
import com.forkfly.ui.R;
/**
 * This class is created as adapter class
 * for displaying cities in a list view
 * @author 
 *
 */
public class CityListViewAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<Regions> regionsNames;

	/**
	 * Constructor to CityListViewAdapter
	 * @param context  Context
	 * @param regions  ArraryList of regions
	 */
	public CityListViewAdapter(Context forkFlyActivity,	ArrayList<Regions> regions) {
		mContext     = forkFlyActivity;
		regionsNames = regions;
	}

	/**
	 * To check how many items are in the data set represented by this Adapter.
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		return regionsNames.size();
	}

	/**
	 * Get the data item associated with the specified position in the data set.
	 * @see android.widget.Adapter#getItem(int)
	 */
	public Object getItem(int position) {
		return regionsNames.get(position);
	}

	/**
	 * Get the row id associated with the specified position in the list.
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * Get a View that displays the data at the specified position in the data set
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = (View) LayoutInflater.from(mContext).inflate(
					R.layout.places_list_child, null);
		}
		TextView state_tv = (TextView) convertView.findViewById(R.id.state_txt);
		TextView  city_tv = (TextView) convertView.findViewById(R.id.city_txt);
		/**
		 * check if state name and city name are not null
		 * and set text in the view
		 */
		if(regionsNames.get(position).getState() != null){        
			state_tv.setText(regionsNames.get(position).getState());
		}
		if(regionsNames.get(position).getCity() != null){
			city_tv.setText(regionsNames.get(position).getCity());
		}
		return convertView;
	}
}
