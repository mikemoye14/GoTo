package main;

import jim.h.common.android.lib.zxing.sample.R;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import goToPackage.*;

public class BuildingList extends Activity {
	
	public static String locationSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_list);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		final BootstrapButton mcbButton = (BootstrapButton) findViewById(R.id.mcb_rabButton);		
		
		final BootstrapButton pulloButton = (BootstrapButton) findViewById(R.id.pulloButton);		
		
		final BootstrapButton jrrsccButton = (BootstrapButton) findViewById(R.id.jrrsccButton);		
		
		final BootstrapButton istButton = (BootstrapButton) findViewById(R.id.istButton);		
		
		final BootstrapButton eliasButton = (BootstrapButton) findViewById(R.id.eliasButton);		
		
		final BootstrapButton bradleyButton = (BootstrapButton) findViewById(R.id.bradleyButton);		
		
		final BootstrapButton bistroButton = (BootstrapButton) findViewById(R.id.bistroButton);		
		
		final BootstrapButton lionsDenButton = (BootstrapButton) findViewById(R.id.lionsDenButton);		
		
		final BootstrapButton helpDeskButton = (BootstrapButton) findViewById(R.id.helpDeskButton);		
		
		final BootstrapButton gameRoomButton = (BootstrapButton) findViewById(R.id.gameRoomButton);		
		gameRoomButton.setRightIcon("fa-star");
		
		mcbButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "MCB/RAB";
            	
            	getBuilding();
            	
            	Intent intent = new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
			
        });
		
		pulloButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "PULLO CENTER (PAC)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		jrrsccButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "JRR STUDENT COMM. CNTR";            	
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		istButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "GRUMBRACHER ISTC";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		eliasButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "SCIENCE BUILDING (ELIAS)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		bradleyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "BRADLEY BUILDING";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		bistroButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "BISTRO @ PULLO";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });

		lionsDenButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "LION'S DEN(CAFETERIA)";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		helpDeskButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "HELP DESK";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		gameRoomButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	locationSelected = "GAME ROOM";
            	
            	Intent intent= new Intent(BuildingList.this, BuildingInfo.class);
            	
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
	
	public static Building getBuilding() {
		
		String location = locationSelected;		
		String id = "";
		String info = "";
		
		if(location == "MCB/RAB"){
			
			id = "1";
				
			info =	"<p>The Main Classroom Building(MCB) and "
					+ "The Romano Administration Building(RAB) "
					+ "are internally connected on the lowest and the first levels.</p>"
					+ "<b>What's inside the MCB</b>"
					+ "<br /><br />"
					+ "&nbsp;&#8226; Registrar<br />"
					+ "&nbsp;&#8226; Bursar <br />"
					+ "&nbsp;&#8226; Admissions"
					+ "<br /><br />"
					+ "<b>What's inside the RAB</b>"
					+ "<br />"
					+ "&nbsp;&#8226; Lair<br />"
					+ "&nbsp;&#8226; Security Office<br />"
					+ "&nbsp;&#8226; Chancellor’s Suite<br />"
					+ "&nbsp;&#8226; Nittany Success Center<br />";
		
		}
		
		if(location == "GRUMBRACHER ISTC"){
			
			id = "2";
				
			info =	"<p>The Grumbacher or ISTC is where most IST classes are held."
					+ "<br />The first floor also has a lot of the staff offices.</p>"
					+ "<b>What's inside the ISTC</b>"
					+ "<br />"
					+ "&nbsp;&#8226; Computer Lab/ Help Desk (106)<br />"
					+ "&nbsp;&#8226; Bookstore<br />"
					+ "&nbsp;&#8226; Faculty Offices (Floor 2)<br />";
		
		}
		
		if(location == "JRR STUDENT COMM. CNTR"){
			
			id = "3";
				
			info =	"<p>The Ruhl community center is the recreational building on campus."
					+ "<br />It’s where the SGA meets every Monday and also hosts other event.</p>"
					+ "<b>What’s inside the Ruhl Community Center</b>"
					+ "<br />"
					+ "&nbsp;&#8226; Community Room<br />"
					+ "&nbsp;&#8226; Basketball Court<br />"
					+ "&nbsp;&#8226; Gymnasium/Locker Rooms<br />"
					+ "&nbsp;&#8226; Game Room<br />"
					+ "&nbsp;&#8226; Lion’s Den (Cafeteria)<br />"
					+ "&nbsp;&#8226; Student Affairs Office<br />"
					+ "&nbsp;&#8226; Multicultural Office<br />";
		
		}
		
		if(location == "PULLO CENTER (PAC)"){
			
			id = "4";
				
			info =	"<p>The Pullo Performing Arts Center or PAC is a state of the art performing facility on campus. "
					+ "<br />In the past it has held events like ‘America’s Got Talent’, ‘Switchfoot’ and ‘Phillip Phillips’ to name a few. "
					+ "<br />The pullo is the only building that is open on Saturdays and Sundays.</p>"
					+ "<b>What’s inside the Pullo Performing Arts Center (PAC)</b>"
					+ "<br /><br />"
					+ "&nbsp;&#8226; Lee R. Glatfelter Library (Floor 2)<br />"
					+ "&nbsp;&#8226; Performing Arts Center<br />"
					+ "&nbsp;&#8226; Computer Lab/ Help Desk (102)<br />"
					+ "&nbsp;&#8226; Art Classrooms<br />"
					+ "&nbsp;&#8226; Cinema Classrooms<br />"
					+ "&nbsp;&#8226; Honors Student Room<br />"
					+ "&nbsp;&#8226; The Bistro<br />";
		
		}
		
		if(location == "SCIENCE BUILDING (ELIAS)"){
			
			id = "5";
				
			info =	"<p>The Edward M. Elias Science center holds science classes and has the labs for chemistry and biology.</p>"
					+ "<b>Edward M. Elias Science Center</b>"
					+ "<br /><br />"
					+ "&nbsp;&#8226; Classrooms<br />"
					+ "&nbsp;&#8226; Faculty Offices<br />"
					+ "&nbsp;&#8226; Chemistry Labs<br />"
					+ "&nbsp;&#8226; Biology Labs<br />"
					+ "&nbsp;&#8226; Starbucks Green House<br />";
		
		}
		
		if(location == "BRADLEY BUILDING"){
			
			id = "6";
				
			info =	"<p>The Bradley Building has continuing education offices."
					+ "<br /> VLN and OLLI classes are monitored by them.</p>"
					+ "<b>Bradley Building</b>"
					+ "<br /><br />"
					+ "&nbsp;&#8226; Offices of personnel who handle Continuing Education<br />";
		
		}
		
		Building building = new Building(id, location, Html.fromHtml(info).toString());
		
		return building;
		
	}

}
