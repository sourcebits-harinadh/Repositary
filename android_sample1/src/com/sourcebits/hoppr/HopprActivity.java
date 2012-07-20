package com.sourcebits.hoppr;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HopprActivity extends Activity implements OnClickListener{ 

	private EditText mEmail = null;

	private EditText mPasword = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		setContentView(R.layout.main);

		/* Creating Button variables by Id.*/
		TextView mSignUpTextView =  (TextView)findViewById(R.id.signUpView);

		/* Register the buttons with OnClickListener*/
		mSignUpTextView.setOnClickListener(this);

		/* Creating Button variables by Id.*/
		Button mLoginUpButton =  (Button)findViewById(R.id.loginButton);

		/* Register the buttons with OnClickListener*/
		mLoginUpButton.setOnClickListener(this);

		/*Creating Edit Text Views*/
		mEmail = (EditText)findViewById(R.id.emailLoginBox);

		mPasword = (EditText)findViewById(R.id.loginPasswordBox);
		
		


	}


	@Override
	public void onClick(View v) {


		if(v.getId()== R.id.signUpView){

			/* SignUp  Button Event */

			doSignUpButtonEvent();

		}else if(v.getId()== R.id.loginButton){

			/* Login  Button Event */
			doLogInButtonEvent();
		}


	}
	private void doLogInButtonEvent(){

		String data = null;
		try{
			if(mEmail.getText().toString().length()>0 && !mEmail.getText().toString().equalsIgnoreCase(getText(R.string.email_text).toString()) && 
					mPasword.getText().toString().length()>0 && !mPasword.getText().toString().equalsIgnoreCase((getText(R.string.password_text).toString()))){

				data =  mEmail.getText().toString()+","+mPasword.getText().toString();;
				
				if(isUserExisted(data)){
					Intent explicit = new Intent(this, DashBoardActivity.class);
					startActivity(explicit);
				}

			}
			else{
				Toast.makeText(this, "Please Enter All The Values", Toast.LENGTH_SHORT).show();
			}
		}finally{
			data = null;
		}
		

	}

	private boolean isUserExisted(String data){

		boolean result  = false;
		SharedPreferences myPrefs = null;

		try{

			myPrefs = this.getSharedPreferences(SinupActivity.KEY, MODE_WORLD_READABLE);
			if(myPrefs!=null && myPrefs.contains(SinupActivity.KEY)){

				String credentials = myPrefs.getString(SinupActivity.KEY, "No User Data Available");

				if(!credentials.equalsIgnoreCase("No User Data Available") && credentials.equalsIgnoreCase(data)){

					result = true;
					Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(this, "Please Enter Correct Credentials", Toast.LENGTH_SHORT).show();
				}
			}else{
				Toast.makeText(this, "No User Data Available.Please Sign Up", Toast.LENGTH_SHORT).show();	
			}


		}
		finally{

			myPrefs = null;
			data = null;
		}
		return result;
	}

	private void doSignUpButtonEvent(){

		Intent intent = new Intent(this, SinupActivity.class);
		startActivity(intent);

	}
}