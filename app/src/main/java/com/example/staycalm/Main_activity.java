
package com.example.staycalm;

import android.app.Activity;
import android.content.Intent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import android.os.Bundle;


import android.view.View;
import android.widget.ImageView;

public class Main_activity extends Activity {


	private ImageView __img_group_3;
	private ImageView __img_group_4;
	private ImageView __img_group_2;
	MotionLayout an;

		public void imageClick1(View view) {
			Intent air_activity = new Intent(Main_activity.this, Air_activity.class);
			startActivity(air_activity);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
		}
		public void imageClick2(View view) {
			Intent heart_activity = new Intent(Main_activity.this, Heart_activity.class);
			startActivity(heart_activity);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
		}
		public void imageClick3(View view) {
			Intent deep_activity = new Intent(Main_activity.this, Deep_activity.class);
			startActivity(deep_activity);
			overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
		}

		@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
			an = findViewById(R.id.motion1);
			an.transitionToEnd();


		__img_group_3 = (ImageView) findViewById(R.id.__img_group_3);
		__img_group_4 = (ImageView) findViewById(R.id.__img_group_4);
		__img_group_2 = (ImageView) findViewById(R.id.__img_group_2);
	
		

	}

	}
	
	