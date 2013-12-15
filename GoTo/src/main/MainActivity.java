package main;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.sqlDatabase.*;

//import com.beardedhen.androidbootstrap.FontAwesomeText;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.TextView; 

@SuppressLint("DefaultLocale")
public class MainActivity extends Activity {
    private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
   
    public TestAdapter mDbHelper; 
    
    private static String scanResultTxt;
        
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDbHelper = new TestAdapter(this); 
        mDbHelper.createDatabase();
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //txtScanResult = (TextView) findViewById(R.id.scan_result);
        zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;

        final BootstrapButton  btnScan = (BootstrapButton)findViewById(R.id.scan_button);
        final BootstrapButton getInfoButton = (BootstrapButton)findViewById(R.id.getInfoButton);
        final BootstrapButton aboutButton = (BootstrapButton) findViewById(R.id.aboutButton);
        
        final AlertDialog.Builder aboutPopUp = new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("GoTo allows navigation between the various building at Penn State York. This app will also provide information about the various buildings." 
                			+ "\n\nTap \"Get Directions\" and then scan the QR code. Select the building you need to GoTo."
                			+ " \n\nTap \"Get Information\" to get information about the various buildings.")
                .setPositiveButton("OK. Got It.", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) { 
                       // do nothing
                    }
                 });  
		
        //btnScan.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
       // getInfoButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        //aboutButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
                
        // æ‰«æ��æŒ‰é’®
        btnScan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.initiateScan(MainActivity.this, zxingLibConfig);
            }
        });
        
        
        // æ‰«æ��æŒ‰é’®
        getInfoButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(MainActivity.this, LocationList.class);
            	LocationList.setDatabase(mDbHelper);
                startActivity(intent);
            }
        });
        
        aboutButton.setOnClickListener(new OnClickListener() {
        	             @Override
        	             public void onClick(View v) {
        	            	 aboutPopUp.show();
        	            }
        	         });
        
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wrong_qrcode, menu);
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
	        	IntentIntegrator.initiateScan(MainActivity.this, zxingLibConfig);
	        }
	     })
	     .setNegativeButton("Quit.", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	Intent intent= new Intent(MainActivity.this, MainActivity.class);
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
    		
    		Intent intent= new Intent(MainActivity.this, ChooseDestination.class);
        	
        	intent.putExtra("scanResult", scanResultTxt);
        	ChooseDestination.setDatabase(mDbHelper);
            startActivity(intent);    		
    		   		
    	}
    	
    	else{
    	
    		Intent intent= new Intent(MainActivity.this, WrongQRCode.class);
        	
            startActivity(intent);
    		
    	}    	    	
    	
    }
    
    public static String getScanResult(){
    	
    	return scanResultTxt.toUpperCase();    	
    
    }
    
}
