package com.sourcebits.hoppr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SinupActivity extends Activity implements OnClickListener{



	public static final String KEY = "123user";
	
	public static final int LOGOUTMODE = 23;
	

	private EditText mEmail = null;
	private EditText mName = null;
	private EditText mPasword = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.signuplayout);

		/* Creating Button variables by Id.*/
		Button mSignUpButton =  (Button)findViewById(R.id.signupButton);

		/* Register the buttons with OnClickListener*/
		mSignUpButton.setOnClickListener(this);
		
		/* Creating Button variables by Id.*/
		Button mCancelButton =  (Button)findViewById(R.id.cancelButton);

		/* Register the buttons with OnClickListener*/
		mCancelButton.setOnClickListener(this);
		


		/*Creating Edit Text Views*/
		mEmail = (EditText)findViewById(R.id.emailBox);
		mName = (EditText)findViewById(R.id.nameBox);
		mPasword = (EditText)findViewById(R.id.passwordBox);
	}

	@Override
	public void onClick(View v) {


		if(v.getId()== R.id.signupButton){

			/* SignUp  Button Event */

			doSignUpButtonEvent();

		}
		if(v.getId()== R.id.cancelButton){

			/* SignUp  Button Event */

			finish();

		}
		


	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode == LOGOUTMODE){
			finish();
		}
	}
	private void doSignUpButtonEvent(){

		String data = null;
		try{
		if(mEmail.getText().toString().length()>0 && !mEmail.getText().toString().equalsIgnoreCase(getText(R.string.email_text).toString()) && 

				mName.getText().toString().length()>0 && !mName.getText().toString().equalsIgnoreCase(getText(R.string.name_text).toString())&&

				mPasword.getText().toString().length()>0 && !mPasword.getText().toString().equalsIgnoreCase((getText(R.string.password_text).toString()))){

			 data =  mEmail.getText().toString()+","+mName.getText().toString()+","+mPasword.getText().toString();;

			saveToSharedPrefersnce(KEY,data);
			
			Intent explicit = new Intent(this, ProfileAndPlaceActivity.class);
			startActivityForResult(explicit, LOGOUTMODE);

		}
		else{
			Toast.makeText(this, "Please Enter All The Values", Toast.LENGTH_SHORT).show();
		}
		}finally{
			data = null;
		}

	}

	private boolean saveToSharedPrefersnce(String key,String data){

		boolean result = false;
		SharedPreferences myPrefs = null;
		SharedPreferences.Editor prefsEditor = null;
		try{

			myPrefs = this.getSharedPreferences(key, MODE_WORLD_WRITEABLE);
			prefsEditor = myPrefs.edit();
			prefsEditor.putString(key, data);
			prefsEditor.commit();
			result = true;
		}
		finally{
			prefsEditor = null;
			myPrefs = null;
			data = null;
		}
		return result;
	}
}
