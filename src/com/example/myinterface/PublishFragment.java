package com.example.myinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import model.Search_out;

//import com.example.myinterface.PersonFragment.NewButtonListener;
import com.example.sqlite.*;
//import com.example.youni.Firstpanel;
import com.example.zz.R;
//import com.example.zz.R.id;

//import android.app.Activity;
//import android.content.Intent;
//import android.content.Intent;
//import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import com.example.zz.R.layout;



public class PublishFragment extends Fragment {
//    private search_DatabaseHelper dbhelper;
    private Younidb younidb;
    private EditText editText;
    @Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.publish, container, false);
        Button checkp=(Button)view.findViewById(R.id.button1);
        editText=(EditText)view.findViewById(R.id.editText2);
        checkp.setOnClickListener(new NewButtonListener()); 
//        EditText editText=(EditText)view.findViewById(R.id.editText2);
//        editText.setOnClickListener(new NewEditTextListener()); 
        return view; 
    }
    
    
    
    class NewButtonListener implements OnClickListener{  
		   
        @Override  
        public void onClick(View arg0) {  
            // TODO Auto-generated method stub  
        	Search_out so=new Search_out();
			String detailed=editText.getText().toString();
			SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日HH时mm分", Locale.getDefault()); 
			Date curDate=new Date(System.currentTimeMillis());//获取当前时间
			String str=formatter.format(curDate);
			so.setDetailed(detailed);
			so.setName("LUAN");
			so.setTime(str);
			younidb.saveSearch_out(so);
        }  
          
    } 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        younidb=Younidb.getInstance(this.getActivity().getApplicationContext());
    }
}
