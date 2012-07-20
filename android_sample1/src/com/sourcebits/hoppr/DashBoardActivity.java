package com.sourcebits.hoppr;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class DashBoardActivity extends Activity implements OnClickListener{


	public static final int ADD_MODE = 2;

	ListView placeListView = null;
	CustomAdapter adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboardlayout);

		/* Creating Button variables by Id.*/
		Button mAddPlaceButton =  (Button)findViewById(R.id.addPlaceButton);

		/* Register the buttons with OnClickListener*/
		mAddPlaceButton.setOnClickListener(this);


		placeListView = (ListView) findViewById(R.id.placeList);

		View header = (View)getLayoutInflater().inflate(R.layout.placelistheader, null);
		placeListView.addHeaderView(header);


		
		ArrayList<Place> values = new ArrayList<Place>();
//		for(int i=0;i<10;i++){
//			Place p = new Place("Hari"+i,"Android"+i);
//			values.add(p);
//		}


		// First paramenter - Context
		// Second parameter -Layout of the View to which the data is written
		// Forth - the array list
		adapter = new CustomAdapter(this,R.layout.placelistitemrow, values);


		// Assign adapter to ListView
		placeListView.setAdapter(adapter); 


	}



	@Override
	public void onClick(View v) {

		if(v.getId()==R.id.addPlaceButton){

			Intent explicit = new Intent(this, AddPlaceActivity.class);
			startActivityForResult(explicit, ADD_MODE);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode ==ADD_MODE){
			Place placeObject = null;
			try{
				placeObject = (Place)data.getSerializableExtra("place");

				adapter.addPlaceObj(placeObject);
				adapter.notifyDataSetChanged();
			}
			finally{
				placeObject = null;
			}

		}
	}
}
