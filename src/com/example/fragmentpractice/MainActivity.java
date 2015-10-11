package com.example.fragmentpractice;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button first, second;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        first = (Button) findViewById(R.id.first);
        second = (Button) findViewById(R.id.second);
        
        first.setOnClickListener(this);
        second.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		 FirstFragment firstFragment = new FirstFragment();
		 SecondFragment secondFragment = new SecondFragment();
		 FragmentManager fragmentManager = getFragmentManager();
		 FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		 switch (v.getId()) {
		    case R.id.first:
				fragmentTransaction.replace(R.id.content, firstFragment);
				fragmentTransaction.commit();
				break;
		    case R.id.second:
		    	if(!secondFragment.isResumed()){
				fragmentTransaction.replace(R.id.content, secondFragment);
				fragmentTransaction.commit();
		    	}
				break;	
		    default:
			
			break;
		}
	}
    
}
