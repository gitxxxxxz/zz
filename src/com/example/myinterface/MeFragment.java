package com.example.myinterface;



import com.example.zz.R;
import com.example.zz.R.id;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; 
import android.view.View.OnClickListener;
import android.widget.Button;

public class MeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me, container, false); 
        
		Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(new NewButtonListener()); 
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(new NewButtonListener()); 
        Button button3 = (Button) view.findViewById(R.id.Button01);
        button3.setOnClickListener(new NewButtonListener()); 
        Button button4 = (Button) view.findViewById(R.id.Button02);
        button4.setOnClickListener(new NewButtonListener()); 
        return view; 
    }
    
	  class NewButtonListener implements OnClickListener{  
		   
		    public void onClick(View v) {  
		          
		          
		        switch (v.getId()) {  
		        case R.id.button1:  
		        	Intent intent1 = new Intent();  
		            intent1.setClass(getActivity(), LoginActivity.class);  
		            getActivity().startActivity(intent1);  
		            break;  
		        case R.id.button2:  
		        	Intent intent2 = new Intent();  
		            intent2.setClass(getActivity(), MyPublish.class);  
		            getActivity().startActivity(intent2); 
		            break;  
		        case R.id.Button01:  
		        	Intent intent3 = new Intent();  
		            intent3.setClass(getActivity(), MyFollow.class);  
		            getActivity().startActivity(intent3); 
		            break;  
		        case R.id.Button02:  
		        	Intent intent4 = new Intent();  
		            intent4.setClass(getActivity(), MyFollow.class);  
		            getActivity().startActivity(intent4); 
		            break;   
		        }  
		          
		   
		    }
	  }
	

}