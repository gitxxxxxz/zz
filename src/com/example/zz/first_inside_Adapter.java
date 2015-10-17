package com.example.zz;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class first_inside_Adapter extends ArrayAdapter<firstinside>{
	private int resourceId;
	public first_inside_Adapter(Context context, int textViewResourceId,List<firstinside> objects) {
		super(context, textViewResourceId,objects);
		// TODO Auto-generated constructor stub
		resourceId=textViewResourceId;
	}
	public View getView(int position,View converView,ViewGroup parent){
		firstinside fi=getItem(position);
		View view =LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView firstinsideImage=(ImageView)view.findViewById(R.id.show);
		TextView firstinside1 =(TextView)view.findViewById(R.id.id);
		TextView firstinside2 =(TextView)view.findViewById(R.id.detailed);
		firstinsideImage.setImageResource(fi.getShowpic());
		firstinside1.setText(fi.getId());
		firstinside2.setText(fi.getDetailed());
		return view;
		
		
	}

	
	

}
