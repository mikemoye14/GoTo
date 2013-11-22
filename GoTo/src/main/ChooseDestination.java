package main;

import com.beardedhen.androidbootstrap.BootstrapButton;
import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
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
            	
            	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	            	
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
            }
        });
		
		currentLocationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent intent= new Intent(ChooseDestination.this, BuildingInfo.class);
            	
            	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            	
            	intent.putExtra("buildingSelected", getIntent().getStringExtra("scanResult"));
            	
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
                if (scanResult == null) {
                    return;
                }
                final String result = scanResult.getContents();
                if (result != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        	
                        	scanResultTxt = result;
                        	
                        	Intent intent= new Intent(ChooseDestination.this, ChooseDestination.class);
                        	
                        	intent.putExtra("scanResult", scanResultTxt);
                        	
                            startActivity(intent);
                        	
                           // txtScanResult.setText(result);
                        }
                    });
                }
                break;
            default:
        }
    }
	
	public static String getDestination(){
		
		return buildingSelected;		
	
	}
	
	public static String getBeginning(){
		
		return scanResult;		
	
	}
}
