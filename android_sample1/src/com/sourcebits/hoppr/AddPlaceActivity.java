package com.sourcebits.hoppr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlaceActivity extends Activity implements OnClickListener{


	private EditText mPlaceName = null;
	private EditText mAddress = null;
	private EditText mDesc = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.placelayout);


		/* Creating Button variables by Id.*/
		Button mDonepButton =  (Button)findViewById(R.id.doneBtn);

		/* Register the buttons with OnClickListener*/
		mDonepButton.setOnClickListener(this);

		/* Creating Button variables by Id.*/
		Button mClearButton =  (Button)findViewById(R.id.clearBtn);

		/* Register the buttons with OnClickListener*/
		mClearButton.setOnClickListener(this);


		/*Creating Edit Text Views*/
		mPlaceName = (EditText)findViewById(R.id.placenameBox);
		mAddress = (EditText)findViewById(R.id.addAddress);
		mDesc = (EditText)findViewById(R.id.addDescrip);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.doneBtn){

		
			Place placeObj = null;
			try{
				if(mPlaceName.getText().toString().length()>0 && !mPlaceName.getText().toString().equalsIgnoreCase(getText(R.string.email_text).toString()) && 

						mAddress.getText().toString().length()>0 && !mAddress.getText().toString().equalsIgnoreCase(getText(R.string.name_text).toString())&&

						mDesc.getText().toString().length()>0 && !mDesc.getText().toString().equalsIgnoreCase((getText(R.string.password_text).toString()))){

					placeObj = new Place(mPlaceName.getText().toString(), mDesc.getText().toString());


					Intent explicit = new Intent(this, DashBoardActivity.class);
					explicit.putExtra("place", placeObj);
					setResult(DashBoardActivity.ADD_MODE,explicit);
					finish();
				}
				else{
					Toast.makeText(this, "Please Enter All The Values", Toast.LENGTH_SHORT).show();
				}
			}finally{
				 placeObj = null;
			}


		}else if(v.getId() == R.id.clearBtn){

		}


	}
}
