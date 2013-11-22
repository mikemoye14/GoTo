package main;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;

import com.beardedhen.androidbootstrap.BootstrapButton;


//import com.beardedhen.androidbootstrap.FontAwesomeText;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
//import android.annotation.SuppressLint;
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

public class WrongQRCode extends Activity {
	
	private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
    
    private String scanResultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_qrcode);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//zxingLibConfig = new ZXingLibConfig();
        //zxingLibConfig.useFrontLight = true;
        
        final BootstrapButton reScanButton = (BootstrapButton) findViewById(R.id.wrongQRCodeRescanButton);    
        final BootstrapButton mainmenuButton = (BootstrapButton) findViewById(R.id.wrongQRCodemainmenuButton);    	

		//reScanButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		
		reScanButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	IntentIntegrator.initiateScan(WrongQRCode.this, zxingLibConfig);
            }
        });
		
		mainmenuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	Intent intent= new Intent(WrongQRCode.this, MainActivity.class);
                startActivity(intent);
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
	        	IntentIntegrator.initiateScan(WrongQRCode.this, zxingLibConfig);
	        }
	     })
	     .setNegativeButton("Quit.", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	Intent intent= new Intent(WrongQRCode.this, MainActivity.class);
	            startActivity(intent);
	        }
	     });
		
		qrCodeErrorPopUp.show();
		
	}
    
    private void validateQRCode(){
    	
    	if(
    			scanResultTxt.equalsIgnoreCase("GRUMBACHER ISTC")
	    		|| scanResultTxt.equalsIgnoreCase("MCB/RAB")
	    		|| scanResultTxt.equalsIgnoreCase("PULLO CENTER (PAC)")
	    		|| scanResultTxt.equalsIgnoreCase("JRR STUDENT COMM. CNTR")
	    		|| scanResultTxt.equalsIgnoreCase("SCIENCE BUILDING (ELIAS)")
	    		|| scanResultTxt.equalsIgnoreCase("BRADLEY BUILDING")
    	){
    		
    		Intent intent= new Intent(WrongQRCode.this, ChooseDestination.class);
        	
        	intent.putExtra("scanResult", scanResultTxt);
        	
            startActivity(intent);    		
    		   		
    	}
    	
    	else{
    	
    		Intent intent= new Intent(WrongQRCode.this, WrongQRCode.class);
        	
            startActivity(intent);
    		
    	}   	    	
    	
    }
}
