package main;

import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BuildingInfo extends Activity {	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		TextView buildingSelected = (TextView) findViewById(R.id.buildingSelected);
		TextView buildingSummary = (TextView) findViewById(R.id.buildingSummaryAndInfo);
		
		buildingSelected.setText(getIntent().getStringExtra("locationSelected"));
		buildingSummary.setText(getIntent().getStringExtra("locationSelected") + " Summary");
		
		
		View mainMenuButton = findViewById(R.id.mainMenuButton);
		View newBuildingButton = findViewById(R.id.newBuildingButton);
		
		mainMenuButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		newBuildingButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		mainMenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(BuildingInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
		
		newBuildingButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(BuildingInfo.this, BuildingList.class);
                startActivity(intent);
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.building_info, menu);
		return true;
	}

}
