package com.makewall.phatjoe50;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Bonuses extends Activity{
	TextView textView;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bonus);
		
		textView = (TextView) findViewById(R.id.tvbonus);
		button = (Button) findViewById(R.id.bbutton);
		button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DisplayMetrics metrics = new DisplayMetrics();
				Display mDisplay = Bonuses.this.getWindowManager().getDefaultDisplay();getWindowManager().getDefaultDisplay().getMetrics(metrics);
				float screenDensity = metrics.density;
				float screenDensityDPI = metrics.densityDpi;
				int width = mDisplay.getWidth();
				int height = mDisplay.getHeight();
				Log.e("Density:", String.valueOf(screenDensity + "---" + screenDensityDPI));
				textView.setText("Device Density = "  + screenDensity + "\nHeight = " + height + "\nWidth = " + width);
			}
			
		});
	}
	

}
