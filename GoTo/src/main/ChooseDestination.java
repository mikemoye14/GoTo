package main;

import goToPackage.*;

import com.beardedhen.androidbootstrap.BootstrapButton;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.Button;

@SuppressLint("DefaultLocale")
public class ChooseDestination extends Activity {
	
	private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;    
    
    private String scanResultTxt;
    
    private static String scanResult;
    
    private static String buildingSelected;
    
    //private Intent wrongCodeIntent = new Intent(ChooseDestination.this, WrongQRCode.class);
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_destination);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;
        
        scanResult = getIntent().getStringExtra("scanResult").toUpperCase();
        
        final BootstrapButton mcbButton = (BootstrapButton) findViewById(R.id.mcb_rabDestinationButton);
    	final BootstrapButton pulloButton = (BootstrapButton) findViewById(R.id.pulloDestinationButton);
    	final BootstrapButton jrrsccButton = (BootstrapButton) findViewById(R.id.jrrsccDestinationButton);
    	final BootstrapButton istButton = (BootstrapButton) findViewById(R.id.istDestinationButton);
    	final BootstrapButton eliasButton = (BootstrapButton) findViewById(R.id.eliasDestinationButton);
    	final BootstrapButton bradleyButton = (BootstrapButton) findViewById(R.id.bradleyDestinationButton);

    	final BootstrapButton goToButton = (BootstrapButton) findViewById(R.id.goToButton);	
    	final BootstrapButton currentLocationButton = (BootstrapButton) findViewById(R.id.currentLocatonButton);
    	final BootstrapButton clearButton = (BootstrapButton) findViewById(R.id.clearButton);
    	final BootstrapButton reScanButton = (BootstrapButton) findViewById(R.id.rescanButton);
    	    	
    	if(scanResult.equalsIgnoreCase("GRUMBACHER ISTC")){
        	
    		istButton.setBootstrapButtonEnabled(false);
        	
        }
    	
    	if(scanResult.equalsIgnoreCase("MCB/RAB")){
        	
    		mcbButton.setBootstrapButtonEnabled(false);
        	
        }
    	
		if(scanResult.equalsIgnoreCase("PULLO CENTER (PAC)")){
			
			pulloButton.setBootstrapButtonEnabled(false);		
			
		}
		
		if(scanResult.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
			
			jrrsccButton.setBootstrapButtonEnabled(false);		
			
		}
		
		if(scanResult.equalsIgnoreCase("SCIENCE BUILDING (ELIAS)")){
			
			eliasButton.setBootstrapButtonEnabled(false);		
			
		}
		
		if(scanResult.equalsIgnoreCase("BRADLEY BUILDING")){
			
			bradleyButton.setBootstrapButtonEnabled(false);		
			
		}
		
    	
		currentLocationButton.setText(scanResult);
		
		goToButton.setBootstrapButtonEnabled(false);
		
		reScanButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	IntentIntegrator.initiateScan(ChooseDestination.this, zxingLibConfig);
            }
        });
		
		goToButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent intent= new Intent(ChooseDestination.this, GetDirections.class);
            	            	
                startActivity(intent);
            	
            }
        });
		
		clearButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(true);
            	pulloButton.setBootstrapButtonEnabled(true);
            	jrrsccButton.setBootstrapButtonEnabled(true);
            	istButton.setBootstrapButtonEnabled(true);
            	eliasButton.setBootstrapButtonEnabled(true);
            	bradleyButton.setBootstrapButtonEnabled(true);
            	
            	goToButton.setBootstrapButtonEnabled(false);
            	
            	if(scanResult.equalsIgnoreCase("GRUMBACHER ISTC")){
                	
            		istButton.setBootstrapButtonEnabled(false);
                	
                }

            	if(scanResult.equalsIgnoreCase("MCB/RAB")){
                	
            		mcbButton.setBootstrapButtonEnabled(false);
                	
                }
            	
        		if(scanResult.equalsIgnoreCase("PULLO CENTER (PAC)")){
        			
        			pulloButton.setBootstrapButtonEnabled(false);		
        			
        		}
        		
        		if(scanResult.equalsIgnoreCase("JRR STUDENT COMM. CNTR")){
        			
        			jrrsccButton.setBootstrapButtonEnabled(false);		
        			
        		}
        		
        		if(scanResult.equalsIgnoreCase("SCIENCE BUILDING (ELIAS)")){
        			
        			eliasButton.setBootstrapButtonEnabled(false);		
        			
        		}
        		
        		if(scanResult.equalsIgnoreCase("BRADLEY BUILDING")){
        			
        			bradleyButton.setBootstrapButtonEnabled(false);		
        			
        		}
            }
        });
		
		currentLocationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	LocationList.setLocationSelected(MainActivity.getScanResult().toUpperCase());
            	
            	LocationList.getBuilding();
            	
            	Intent intent = new Intent(ChooseDestination.this, BuildingInfo.class);
            	
                startActivity(intent);
            }
        });
		
		mcbButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	pulloButton.setBootstrapButtonEnabled(false);
            	jrrsccButton.setBootstrapButtonEnabled(false);
            	istButton.setBootstrapButtonEnabled(false);
            	eliasButton.setBootstrapButtonEnabled(false);
            	bradleyButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "MCB/RAB"; 
            	
            	getBuildingDirections();
            }
        });
		
		pulloButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(false);
            	jrrsccButton.setBootstrapButtonEnabled(false);
            	istButton.setBootstrapButtonEnabled(false);
            	eliasButton.setBootstrapButtonEnabled(false);
            	bradleyButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "PULLO CENTER (PAC)"; 
            }
        });
		
		jrrsccButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(false);
            	pulloButton.setBootstrapButtonEnabled(false);
            	istButton.setBootstrapButtonEnabled(false);
            	eliasButton.setBootstrapButtonEnabled(false);
            	bradleyButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "JRR STUDENT COMM. CNTR"; 
            }
        });
		
		istButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(false);
            	pulloButton.setBootstrapButtonEnabled(false);
            	jrrsccButton.setBootstrapButtonEnabled(false);
            	eliasButton.setBootstrapButtonEnabled(false);
            	bradleyButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "GRUMBACHER ISTC"; 
            }
        });
		
		eliasButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(false);
            	pulloButton.setBootstrapButtonEnabled(false);
            	jrrsccButton.setBootstrapButtonEnabled(false);
            	istButton.setBootstrapButtonEnabled(false);
            	bradleyButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "SCIENCE BUILDING (ELIAS)"; 
            }
        });
		
		bradleyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setBootstrapButtonEnabled(false);
            	pulloButton.setBootstrapButtonEnabled(false);
            	jrrsccButton.setBootstrapButtonEnabled(false);
            	istButton.setBootstrapButtonEnabled(false);
            	eliasButton.setBootstrapButtonEnabled(false);
            	
            	goToButton.setBootstrapButtonEnabled(true);
            	
            	buildingSelected = "BRADLEY BUILDING"; 
            }
        });	
				
	}
	
	

	public static Building getBuildingDirections() {
		
		String location = buildingSelected;		
		String id = "";
		Image img = null;
		Direction dir = null;
		
		if(location == "MCB/RAB"){
			
			id = "1";
			
			img = new Image();
				
			
		
		}
		
		if(location == "GRUMBACHER ISTC"){
			
			id = "2";
				
			
		
		}
		
		if(location == "JRR STUDENT COMM. CNTR"){
			
			id = "3";
				
			
		
		}
		
		if(location == "PULLO CENTER (PAC)"){
			
			id = "4";
				
			
		
		}
		
		if(location == "SCIENCE BUILDING (ELIAS)"){
			
			id = "5";
				
			
		
		}
		
		if(location == "BRADLEY BUILDING"){
			
			id = "6";
				
			
		
		}
		
		Building building = new Building(id, location, img, dir);
		
		return building;
		
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_directions, menu);
		return true;
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE: // æ‰«æ��ç»“æžœ
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
                        resultCode, data);
                if (scanResult == null || scanResult.getContents() == "" || scanResult.getContents() == null) {
                	
                	showQRCodeError();
                    return;
                    
                }
                final String result = scanResult.getContents();
                if (result != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        	
                        	scanResultTxt = result.toUpperCase();
                        	
                        	validateQRCode();                        	
                        	
                        }
                    });
                }
                break;
            default:
        }        
        
    }    
    
    private void showQRCodeError(){		
		
		final AlertDialog.Builder qrCodeErrorPopUp = new AlertDialog.Builder(this)
	    .setTitle("QR Code Error")
	    .setMessage("There seems to have been an error while scanning the QR Code. \n\nA team of highly trained monkeys has been dispatched to deal with this situation.")
	    .setPositiveButton("Scan Again.", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	IntentIntegrator.initiateScan(ChooseDestination.this, zxingLibConfig);
	        }
	     })
	     .setNegativeButton("Quit.", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	Intent intent= new Intent(ChooseDestination.this, MainActivity.class);
	            startActivity(intent);
	        }
	     });
		
		qrCodeErrorPopUp.show();
		
	}
    
    private void validateQRCode(){
    	
    	if(
    			scanResultTxt.equalsIgnoreCase("Grumbacher ISTC")
	    		|| scanResultTxt.equalsIgnoreCase("MCB/RAB")
	    		|| scanResultTxt.equalsIgnoreCase("Pullo Building (PAC)")
	    		|| scanResultTxt.equalsIgnoreCase("JRR Student Comm. Cntr")
	    		|| scanResultTxt.equalsIgnoreCase("Elias (Science Building)")
	    		|| scanResultTxt.equalsIgnoreCase("Bradley Building")
    	){
    		
    		Intent intent= new Intent(ChooseDestination.this, ChooseDestination.class);
        	
        	intent.putExtra("scanResult", scanResultTxt);
        	
            startActivity(intent);    		
    		   		
    	}
    	
    	else{
    	
    		Intent intent= new Intent(ChooseDestination.this, WrongQRCode.class);
        	
            startActivity(intent);
    		
    	}    	    	    	    	
    	
    }
    
	
    
	public static String getDestination(){
		
		return buildingSelected;		
	
	}
	
	public static String getBeginning(){
		
		return scanResult;		
	
	}	
	
}
