
package com.example.staycalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Homescreen_activity extends Activity {

	private ImageView ellipse_1;
	MotionLayout an;


	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
		an = findViewById(R.id.motion);
		an.transitionToEnd();


		ellipse_1 = (ImageView) findViewById(R.id.ellipse_1);
		Button start = (Button) findViewById(R.id.button);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		start.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						start.startAnimation(anim);
						Intent main_activity = new Intent(Homescreen_activity.this, Main_activity.class);
						startActivity(main_activity);
						overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

					}
				}
		);



	}
}
	
	