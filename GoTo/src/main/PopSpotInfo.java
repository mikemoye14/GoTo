package main;

import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

//import gotoPackage.*;

public class PopSpotInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pop_spot_info);
		
		setText();
		
		final BootstrapButton mainMenuButton = (BootstrapButton) findViewById(R.id.popSpotMainMenuButton);
		final BootstrapButton newBuildingButton = (BootstrapButton) findViewById(R.id.popSpotNewBuildingButton);
		
		
		mainMenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(PopSpotInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
		
		newBuildingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(PopSpotInfo.this, LocationList.class);
                startActivity(intent);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pop_spot_info, menu);
		return true;
	}
	
	private void setText() {
		
		TextView popSpotBuildingSelected = (TextView) findViewById(R.id.popSpotBuildingSelected);
		TextView popSpotBuildingSummary = (TextView) findViewById(R.id.popSpotBuildingSummaryAndInfo);
		
		popSpotBuildingSelected.setText(LocationList.getPopSpot().getPopSpotName());
		
		popSpotBuildingSummary.setText(
				
				Html.fromHtml(LocationList.getPopSpot().getPopSpotDescription()).toString()
				+ Html.fromHtml(LocationList.getPopSpot().getPopSpotLocation()).toString()
				+ Html.fromHtml(LocationList.getPopSpot().getPopSpothours()).toString()
				
				);
		
	}

}
