package main;

import jim.h.common.android.lib.zxing.sample.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class BuildingList extends Activity {
	
	public String locationSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_list);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		View mcbButton = findViewById(R.id.mcb_rabButton);		
		mcbButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View pulloButton = findViewById(R.id.pulloButton);		
		pulloButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View jrrsccButton = findViewById(R.id.jrrsccButton);		
		jrrsccButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View istButton = findViewById(R.id.istButton);		
		istButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View eliasButton = findViewById(R.id.eliasButton);		
		eliasButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View bradleyButton = findViewById(R.id.bradleyButton);		
		bradleyButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View bistroButton = findViewById(R.id.bistroButton);		
		bistroButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View lionsDenButton = findViewById(R.id.lionsDenButton);		
		lionsDenButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View helpDeskButton = findViewById(R.id.helpDeskButton);		
		helpDeskButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		View gameRoomButton = findViewById(R.id.gameRoomButton);		
		gameRoomButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		mcbButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "MCB/RAB";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		pulloButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "PULLO CENTER (PAC)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		jrrsccButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "JRR STUDENT COMM. CNTR";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		istButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "GRUMBRACHER ISTC";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		eliasButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "SCIENCE BUILDING (ELIAS)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		bradleyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "BRADLEY BUILDING";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		bistroButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "BISTRO @ PULLO";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });

		lionsDenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "LION'S DEN(CAFETERIA)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		helpDeskButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "HELP DESK";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
		gameRoomButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "GAME ROOM";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
            	intent.putExtra("locationSelected", locationSelected);
            	
                startActivity(intent);
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.building_list, menu);
		return true;
	}

}
