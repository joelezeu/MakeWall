package com.makewall.phatjoe50;

import static com.makewall.phatjoe50.HeavyLifter.FAIL;
import static com.makewall.phatjoe50.HeavyLifter.SUCCESS;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.makewall.phatjoe50.R;
import com.makewall.phatjoe50.HeavyLifter;

public class MakeWallGallery extends Activity {
	/** A list containing the resource identifiers for all of our selectable backgrounds */
	private static final List<Integer> backgrounds = new ArrayList<Integer>();
	/** The total number of backgrounds in the list */
	private static final int TOTAL_IMAGES;
	/** Instantiate the list statically, so this will be done once on App load, also calculate the total number of backgrounds */
	static {
		backgrounds.add(R.drawable.lloyd);
		backgrounds.add(R.drawable.background1);
		backgrounds.add(R.drawable.background2);
		backgrounds.add(R.drawable.spongebob);
		backgrounds.add(R.drawable.dragon);
		backgrounds.add(R.drawable.bg10);
		backgrounds.add(R.drawable.bg11);
		backgrounds.add(R.drawable.bg12);
		backgrounds.add(R.drawable.bg13);
		backgrounds.add(R.drawable.bg16);
		backgrounds.add(R.drawable.bg15);
		backgrounds.add(R.drawable.bg17);
		backgrounds.add(R.drawable.bg18);
		backgrounds.add(R.drawable.bg19);
		backgrounds.add(R.drawable.bg20);
		backgrounds.add(R.drawable.bg21);
		backgrounds.add(R.drawable.bg22);
		backgrounds.add(R.drawable.bg23);
		backgrounds.add(R.drawable.bg24);
		backgrounds.add(R.drawable.bg25);
		backgrounds.add(R.drawable.bg26);
		backgrounds.add(R.drawable.bg27);
		backgrounds.add(R.drawable.bg28);
		backgrounds.add(R.drawable.bg29);
		backgrounds.add(R.drawable.bg30);
		backgrounds.add(R.drawable.bg3);
		backgrounds.add(R.drawable.bg31);
		backgrounds.add(R.drawable.bg32);
		backgrounds.add(R.drawable.bg33);
		backgrounds.add(R.drawable.bg34);
		backgrounds.add(R.drawable.bg35);
		backgrounds.add(R.drawable.bg36);
		backgrounds.add(R.drawable.bg37);
		backgrounds.add(R.drawable.bg4);
		backgrounds.add(R.drawable.bg5);
		backgrounds.add(R.drawable.bg6);
		backgrounds.add(R.drawable.bg7);
		backgrounds.add(R.drawable.bg8);
		backgrounds.add(R.drawable.bg9);
		backgrounds.add(R.drawable.bhg14);
		backgrounds.add(R.drawable.bg38);
		backgrounds.add(R.drawable.bg39);
		backgrounds.add(R.drawable.bg40);
		backgrounds.add(R.drawable.bg41);
		backgrounds.add(R.drawable.bg42);
		backgrounds.add(R.drawable.bg43);
		backgrounds.add(R.drawable.bg44);
		backgrounds.add(R.drawable.bg45);
		backgrounds.add(R.drawable.bg46);
		backgrounds.add(R.drawable.bg47);
		backgrounds.add(R.drawable.bg48);
		backgrounds.add(R.drawable.bg49);
		backgrounds.add(R.drawable.bg50);
		backgrounds.add(R.drawable.bg51);
		backgrounds.add(R.drawable.bg52);
		backgrounds.add(R.drawable.bg53);
		backgrounds.add(R.drawable.bg54);
		backgrounds.add(R.drawable.bg55);
		backgrounds.add(R.drawable.bg56);
		backgrounds.add(R.drawable.bg57);
		backgrounds.add(R.drawable.bg58);
		backgrounds.add(R.drawable.bg59);
		backgrounds.add(R.drawable.bg60);
		backgrounds.add(R.drawable.bg61);
		backgrounds.add(R.drawable.bg62);
		backgrounds.add(R.drawable.bg63);
		backgrounds.add(R.drawable.bg64);
		backgrounds.add(R.drawable.bg65);
		backgrounds.add(R.drawable.bg66);
		backgrounds.add(R.drawable.bg67);
		backgrounds.add(R.drawable.bg68);
		backgrounds.add(R.drawable.bg70);
		backgrounds.add(R.drawable.bg71);
		backgrounds.add(R.drawable.bg72);
		backgrounds.add(R.drawable.bg73);
		backgrounds.add(R.drawable.bg74);
		backgrounds.add(R.drawable.bg75);
		backgrounds.add(R.drawable.bg76);
		backgrounds.add(R.drawable.bg77);
		backgrounds.add(R.drawable.bg78);
		backgrounds.add(R.drawable.bg79);
		backgrounds.add(R.drawable.bg80);
		
		// We -1 as lists are zero indexed (0-2 is a size of 3) - we'll mke use of this to implement a browsing loop
		TOTAL_IMAGES = (backgrounds.size() - 1);
	}
	/** the state of what wallpaper is currently being previewed */
	private int currentPosition = 0;
	/** our image wallpaper preview */
	private ImageView backgroundPreview;
	/** A helper class that will do the heavy work of decoding images and actually setting the wallpaper */
	private HeavyLifter phatjoe;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);
		
		backgroundPreview = (ImageView) findViewById(R.id.backgroundPreview);
		// Set the default image to be shown to start with
		changePreviewImage(currentPosition);
		// Load are heavy lifter (goes and does work on another thread), to get a response after the lifters thread
		// has finished we pass in a Handler that will be notified when it completes
		phatjoe = new HeavyLifter(this, DigitalGuys);
	}
	
	/**
	 * Called from XML when the previous button is pressed
	 * Decrement the current state position
	 * If the position is now less than 0 loop round and show the last image (the array size)
	 * @param v
	 */
	public void gotoPreviousImage(View v) {
		int positionToMoveTo = currentPosition;
		positionToMoveTo--;
		if(positionToMoveTo < 0){
			positionToMoveTo = TOTAL_IMAGES;
		}
		changePreviewImage(positionToMoveTo);
	}

	/**
	 * Called from XML when the set wallpaper button is pressed
	 * Thie retrieves the id of the current image from our list
	 * It then asks chuck to set it as a wallpaper!
	 * The chuckHandler will be called when this operation is complete
	 * @param v
	 */
	public void setAsWallpaper(View v) {
		int resourceId = backgrounds.get(currentPosition);
		phatjoe.setResourceAsWallpaper(resourceId);
	}

	/**
	 * Called from XML when the next button is pressed
	 * Increment the current state position
	 * If the position is now greater than are array size loop round and show the first image again
	 * @param v
	 */
	public void gotoNextImage(View v) {
		int positionToMoveTo = currentPosition;
		positionToMoveTo++;
		if(currentPosition == TOTAL_IMAGES){
			positionToMoveTo = 0;
		} 

		changePreviewImage(positionToMoveTo);
	}
	
	/**
	 * Change the currently showing image on the screen
	 * This is quite an expensive operation as each time the system
	 * has to decode the image from our resources - alternatives are possible (a list of drawables created at app start)
	 * @param pos the position in {@link MakeWallGallery#backgrounds} to select the image from
	 */
	public void changePreviewImage(int pos) {
		currentPosition = pos;
		backgroundPreview.setImageResource(backgrounds.get(pos));
		Log.d("Main", "Current position: "+pos);
	}
	
	/**
	 * This is the handler that is notified when are HeavyLifter is finished doing an operation
	 */
	private Handler DigitalGuys = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
			case SUCCESS:
				Toast.makeText(MakeWallGallery.this, "Wallpaper don set", Toast.LENGTH_SHORT).show();
				break;
			case FAIL:
				Toast.makeText(MakeWallGallery.this, "I no fit set this pix as wallpaper", Toast.LENGTH_SHORT).show();
				break;
			default:
				super.handleMessage(msg);
			}
		}
	};
	
}