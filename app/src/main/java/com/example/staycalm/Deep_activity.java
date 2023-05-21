
package com.example.staycalm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class Deep_activity extends AppCompatActivity {
	private EditText txt;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deep);
		txt = findViewById(R.id.editText);
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
		ImageView polygon_1 = (ImageView) findViewById(R.id.imageView);
		polygon_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				polygon_1.startAnimation(anim);
				Intent main_activity = new Intent(Deep_activity.this, Main_activity.class);
				startActivity(main_activity);
				overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
			}
		});
	}
	@Override
	protected void onResume() {
		super.onResume();

		SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
		String s1 = sh.getString("txt", "");

		txt.setText(s1);
	}
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
		SharedPreferences.Editor myEdit = sharedPreferences.edit();

		myEdit.putString("txt", txt.getText().toString());
		myEdit.apply();
	}
}