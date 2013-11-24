package main;

import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.text.Html;
//import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class BuildingInfo extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		setText();
		
		final BootstrapButton mainMenuButton = (BootstrapButton) findViewById(R.id.mainMenuButton);
		final BootstrapButton newBuildingButton = (BootstrapButton) findViewById(R.id.newBuildingButton);
		
		//mainMenuButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		//newBuildingButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
				
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

	private void setText() {
		
		TextView buildingSelected = (TextView) findViewById(R.id.buildingSelected);
		TextView buildingSummary = (TextView) findViewById(R.id.buildingSummaryAndInfo);
		
		buildingSelected.setText(BuildingList.getLocationSelected());
		
		if(BuildingList.getLocationSelected().equalsIgnoreCase("GRUMBACHER ISTC")){
			
			buildingSummary.setText(istInfo());
			
		}
		
	}
	
	private String istInfo(){
		
		String info =  "<p>The Grumbacher or ISTC is where most IST classes are held."
						+ "<br />The first floor also has a lot of the staff offices.</p>"
						+ "<p><strong>What's inside the ISTC</strong></p>"
						+ "&#8226; Computer Lab/ Help Desk (106)<br />"
						+ "&#8226; Bookstore<br />"
						+ "&#8226; Faculty Offices (Floor 2)";
		
		return info;
		
	}
	
	private String mcbInfo(){
		
		String info =  "<p>The Main Classroom Building(MCB) and "
						+ "The Romano Administration Building(RAB) "
						+ "are internally connected on the lowest and the first levels.</p>"
						+ "<p><strong>What's inside the MCB</strong></p>"
						+ "&#8226; Registrar<br />"
						+ "&#8226; Bursar <br />"
						+ "&#8226; Admissions"
						+ "<br /><br />"
						+ "<p><strong>What's inside the RAB</strong></p>"
						+ "&#8226; Lair<br />"
						+ "&#8226; Security Office<br />"
						+ "&#8226; Chancellor’s Suite"
						+ "&#8226; Nittany Success Center";
		
		
		return info;
		
	}
	
	private String bradleyInfo(){
		
		String info =  "<p>The Main Classroom Building(MCB) and "
						+ "The Romano Administration Building(RAB) "
						+ "are internally connected on the lowest and the first levels.</p>"
						+ "<p><strong>What's inside the MCB</strong></p>"
						+ "&#8226; Registrar<br />"
						+ "&#8226; Bursar <br />"
						+ "&#8226; Admissions"
						+ "<br /><br />"
						+ "<p><strong>What's inside the RAB</strong></p>"
						+ "&#8226; Lair<br />"
						+ "&#8226; Security Office<br />"
						+ "&#8226; Chancellor’s Suite"
						+ "&#8226; Nittany Success Center";
		
		
		return info;
		
	}

}
