
package com.example.staycalm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Air_activity extends Activity { private Handler mHandler = new Handler();

	
	private View _bg__air_ek2;
	private View ellipse_15;
	private View ellipse_16;
	private ImageView polygon_1;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.air);

		ellipse_15 = (View) findViewById(R.id.ellipse_15);
		ellipse_16 = (View) findViewById(R.id.ellipse_16);
		polygon_1 = (ImageView) findViewById(R.id.polygon_1);
		TextView t = (TextView) findViewById(R.id.text);
		TextView tv = (TextView) findViewById(R.id.text1);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.sc);
		final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.sc2);
		final Animation an = AnimationUtils.loadAnimation(this, R.anim.alpha);
		final boolean[] isRunning = {false};

		polygon_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				polygon_1.startAnimation(an);
				Intent main_activity = new Intent(Air_activity.this, Main_activity.class);
				startActivity(main_activity);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
			}
		}
		);
		ellipse_15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ellipse_16.startAnimation(anim);
				ellipse_15.startAnimation(anim2);
				ellipse_15.setClickable(false);
						new CountDownTimer(30000, 1000) {
							public void onTick(long l) {
								if (l >= 26000 | l <= 14000 & l >= 10000 ){
								tv.setText(" "); t.setText("Вдох");} else if (l <= 23000 & l >= 17000 | l < 7000 & l >= 1000) {tv.setText( " "); t.setText("Выдох");}
								else {tv.setText(" "); t.setText("Пауза");}

							}

							public void onFinish() {tv.setText(""); t.setText("Повторить"); ellipse_15.setClickable(true);}
						}.start();

					}
				private void doStuff() {
				new CountDownTimer(4000, 1000) {
					public void onTick(long l) {tv.setText(" " + l/ 1000); t.setText("Вдох");}
					public void onFinish() {tv.setText(""); t.setText("Пауза");}
				}.start();
			}});
	}
}
	
	