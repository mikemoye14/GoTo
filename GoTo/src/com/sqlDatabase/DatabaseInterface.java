package com.sqlDatabase;

import goToPackage.Direction;

import java.util.ArrayList;

import jim.h.common.android.lib.zxing.sample.R;
import main.MainActivity;

public class DatabaseInterface {
	
	public static TestAdapter mDbHelper;
	
	private String destination = "";
	private String beginning = "";
	

	public DatabaseInterface() {
		// TODO Auto-generated constructor stub
	}
	
	public DatabaseInterface(String destination, String beginning) {

		this.destination = destination;
		this.beginning = beginning;
		
	}
	
public ArrayList<Direction> getBuildingDirections() {
	
		String id = "";
		Direction dir = null;
		
		//comment
		
		ArrayList<Direction> directions = new ArrayList<Direction>();
		
		try{
		
		mDbHelper.open();
		
		if(destination.equalsIgnoreCase("MCB/RAB") && beginning.equalsIgnoreCase("GRUMBACHER ISTC")){
			
			id = "1";
			
			//dir = new Direction(id,"test", 0); // mDbHelper.getData("Direction", "d00" + i, "directions")
			
			//directions.add(dir);
			
			for(int i=12; i<19; i++){
				
				//if(mDbHelper.getData("Direction", "d00" + i, "image_Name") == "";
				
				dir = new Direction(id, "test", 0);
				
				//dir = new Direction(id, mDbHelper.getData("Direction", "d00" + i, "directions"), 0);
				
				directions.add(dir);
				
			}
		
		}
		
	else if(destination == "JRR STUDENT COMM. CNTR" && MainActivity.getScanResult() == "GRUMBACHER ISTC"){
			
			id = "1";
			
			for(int i=1; i<4; i++){
			
				//dir = new Direction(id, mDbHelper.getData("Direction", "d0" + i, "directions"), mDbHelper.getData("Direction", "d0" + i, "image_Name"));
									
				directions.add(dir);
				
			}
		
		}
		
		else{
			
			dir = new Direction(id, "There was an error\n" + "destination: " + destination + "\nsource: " + beginning, R.drawable.error);
			
			directions.add(dir);
			
		}
		
		
		}
		finally{
		
			mDbHelper.close();	
		
		}
				
				
		
		return directions;
		
	}

public void setDatabase(TestAdapter abc ){
	
	mDbHelper=abc;
	
}


}
