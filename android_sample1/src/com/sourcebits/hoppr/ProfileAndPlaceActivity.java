package com.sourcebits.hoppr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProfileAndPlaceActivity extends Activity implements OnClickListener{

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profileandplacelayout);

		/* Creating Button variables by Id.*/
		Button mEditProfileButton =  (Button)findViewById(R.id.editProfile);

		/* Register the buttons with OnClickListener*/
		mEditProfileButton.setOnClickListener(this);

		/* Creating Button variables by Id.*/
		Button mMyPlacesButton =  (Button)findViewById(R.id.myPlaceBtn);

		/* Register the buttons with OnClickListener*/
		mMyPlacesButton.setOnClickListener(this);

		/* Creating Button variables by Id.*/
		Button mLogutButton =  (Button)findViewById(R.id.logoutButton);

		/* Register the buttons with OnClickListener*/
		mLogutButton.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.editProfile){

			Intent explicit = new Intent(this, EditProfileAcivity.class);
			startActivity(explicit);
			
		}else if(v.getId() == R.id.myPlaceBtn){

			Intent explicit = new Intent(this, DashBoardActivity.class);
			startActivity(explicit);
		}
		else if(v.getId() == R.id.logoutButton){

			setResult(SinupActivity.LOGOUTMODE);
			finish();
			
		}

	}
}
