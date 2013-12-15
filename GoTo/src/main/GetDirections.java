package main;

import java.util.ArrayList;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.sqlDatabase.DatabaseInterface;
import com.sqlDatabase.TestAdapter;

import goToPackage.*;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.text.SpannableString;
//import android.text.style.ImageSpan;
//import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.TextView;

public class GetDirections extends Activity {
	
	private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
    
    private String scanResultTxt;

    public static TestAdapter mDbHelper;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_directions);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;
        
        final BootstrapButton newDestinationButton = (BootstrapButton) findViewById(R.id.newDestinationButton);
        final BootstrapButton reScanDirectionsButton = (BootstrapButton) findViewById(R.id.reScanDirectionsButton);
        final BootstrapButton mainmenuButton = (BootstrapButton) findViewById(R.id.mainMenuButton);
    	
    	//reScanDirectionsButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        //newDestinationButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
       
        setText();
        
        reScanDirectionsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
                IntentIntegrator.initiateScan(GetDirections.this, zxingLibConfig);
                
            }
        });
        
        newDestinationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            	Intent intent = new Intent(GetDirections.this, ChooseDestination.class);
            	
            	intent.putExtra("scanResult", ChooseDestination.getBeginning());
            	
                startActivity(intent);
            	
            }
        });
        
        mainmenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            	Intent intent = new Intent(GetDirections.this, MainActivity.class);
            	
            	intent.putExtra("scanResult", ChooseDestination.getBeginning());
            	
                startActivity(intent);
            	
            }
        });
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
	                        	
	                        	scanResultTxt = result;
	                        	
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
		        	IntentIntegrator.initiateScan(GetDirections.this, zxingLibConfig);
		        }
		     })
		     .setNegativeButton("Quit.", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		        	Intent intent = new Intent(GetDirections.this, MainActivity.class);
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
	    		
	    		Intent intent = new Intent(GetDirections.this, ChooseDestination.class);
	        	
	        	intent.putExtra("scanResult", scanResultTxt);
	        	
	            startActivity(intent);    		
	    		   		
	    	}
	    	
	    	else{
	    	
	    		Intent intent= new Intent(GetDirections.this, WrongQRCode.class);
	        	
	            startActivity(intent);
	    		
	    	}    	    	
	    	
	    }
	    
	    private void setText(){
	    	
	    	DatabaseInterface dbInterface = new DatabaseInterface(ChooseDestination.getDestination(), MainActivity.getScanResult());
	    	
	    	ArrayList<Direction> directionsArray = new ArrayList<Direction>();
	    	dbInterface.setDatabase(mDbHelper);
	    	directionsArray = dbInterface.getBuildingDirections();
	    	
	    	TextView toFrom = (TextView) findViewById(R.id.toFromTextView);
	        
	        TextView directionsTextView1 = (TextView) findViewById(R.id.textView2);
	        
	        toFrom.setText("From: " + ChooseDestination.getDestination() + " \nTo: " + ChooseDestination.getBeginning());

	        //ImageSpan is = new ImageSpan(this, R.drawable.error);
	        
	        directionsTextView1.setText("  " + directionsArray.get(0).getDirectionTxt());
	        
	        directionsTextView1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.error, 0, 0, 0);
	        
	    	
	    }
	    
	    public static void setDatabase(TestAdapter abc ){
			
			mDbHelper=abc;
			
		}
}
