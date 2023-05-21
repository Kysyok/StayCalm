
package com.example.staycalm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Heart_activity extends Activity {

	
	private View _bg__heart_ek2;
	private View rectangle_3;
	private View rectangle_4;
	final boolean[] isRunning = {false};
	private ImageView polygon_1;
	int clickcount = 0;


	@Override
	public void onCreate(Bundle savedInstanceState) {
			AlertDialog.Builder builder = new AlertDialog.Builder(Heart_activity.this);
			builder.setTitle("❤")
					.setMessage("Нащупайте у себя пульс на сердце или пальцем на руке. Затем нажимайте пальцем на розовый круг в такт биения пульса(сердца).")

					.setCancelable(false)
					.setNegativeButton("ОК",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.heart);
		polygon_1 = (ImageView) findViewById(R.id.polygon_3);
		ImageView rr = (ImageView) findViewById(R.id.rr);
		ImageView rr1 = (ImageView) findViewById(R.id.rr1);
		TextView tv = (TextView) findViewById(R.id.textView);
		TextView re = (TextView) findViewById(R.id.text);
		final Animation an = AnimationUtils.loadAnimation(this, R.anim.alpha);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
		final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.scale2);
		polygon_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				polygon_1.startAnimation(an);
				Intent main_activity = new Intent(Heart_activity.this, Main_activity.class);
				startActivity(main_activity);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
			}});
		rr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isRunning [0] == true){
				rr1.startAnimation(anim);
				rr.startAnimation(anim2);
				clickcount = clickcount + 1;}}
		});
		rr1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				re.setVisibility(View.INVISIBLE);
				rr1.setClickable(false);

				new CountDownTimer(30000, 1000) {

					public void onTick(long l) {
						tv.setText(" " + l/ 1000);
						isRunning [0] = true;}

					public void onFinish() {
						tv.setText("Ваш пульс:"+clickcount*2 );rr1.setClickable(true); clickcount = 0; re.setVisibility(View.VISIBLE);
					}
				}.start();
			}
		}
		);


	}
}
	
	