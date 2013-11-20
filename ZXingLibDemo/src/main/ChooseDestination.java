package main;

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
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
        
       // scanResult = getIntent().getStringExtra("scanResult").toUpperCase();
        
        scanResult = MainActivity.getScanResult();
        
        final Button mcbButton = (Button) findViewById(R.id.mcb_rabDestinationButton);
    	final Button pulloButton = (Button) findViewById(R.id.pulloDestinationButton);
    	final Button jrrsccButton = (Button) findViewById(R.id.jrrsccDestinationButton);
    	final Button istButton = (Button) findViewById(R.id.istDestinationButton);
    	final Button eliasButton = (Button) findViewById(R.id.eliasDestinationButton);
    	final Button bradleyButton = (Button) findViewById(R.id.bradleyDestinationButton);

    	final Button goToButton = (Button) findViewById(R.id.goToButton);	
    	Button currentLocationButton = (Button) findViewById(R.id.currentLocatonButton);
    	Button clearButton = (Button) findViewById(R.id.clearButton);
    	Button reScanButton = (Button) findViewById(R.id.rescanButton);
    	currentLocationButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));		
		mcbButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		pulloButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		jrrsccButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		istButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		eliasButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		bradleyButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		reScanButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		goToButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		clearButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		currentLocationButton.setText(scanResult);
		
		goToButton.setEnabled(false);
		
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
            	
            	mcbButton.setEnabled(true);
            	pulloButton.setEnabled(true);
            	jrrsccButton.setEnabled(true);
            	istButton.setEnabled(true);
            	eliasButton.setEnabled(true);
            	bradleyButton.setEnabled(true);
            	
            	goToButton.setEnabled(false);
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
            	
            	pulloButton.setEnabled(false);
            	jrrsccButton.setEnabled(false);
            	istButton.setEnabled(false);
            	eliasButton.setEnabled(false);
            	bradleyButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
            	buildingSelected = "MCB/RAB"; 
            }
        });
		
		pulloButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setEnabled(false);
            	jrrsccButton.setEnabled(false);
            	istButton.setEnabled(false);
            	eliasButton.setEnabled(false);
            	bradleyButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
            	buildingSelected = "PULLO CENTER (PAC)"; 
            }
        });
		
		jrrsccButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setEnabled(false);
            	pulloButton.setEnabled(false);
            	istButton.setEnabled(false);
            	eliasButton.setEnabled(false);
            	bradleyButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
            	buildingSelected = "JRR STUDENT COMM. CNTR"; 
            }
        });
		
		istButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setEnabled(false);
            	pulloButton.setEnabled(false);
            	jrrsccButton.setEnabled(false);
            	eliasButton.setEnabled(false);
            	bradleyButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
            	buildingSelected = "GRUMBACHER ISTC"; 
            }
        });
		
		eliasButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setEnabled(false);
            	pulloButton.setEnabled(false);
            	jrrsccButton.setEnabled(false);
            	istButton.setEnabled(false);
            	bradleyButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
            	buildingSelected = "SCIENCE BUILDING (ELIAS)"; 
            }
        });
		
		bradleyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	mcbButton.setEnabled(false);
            	pulloButton.setEnabled(false);
            	jrrsccButton.setEnabled(false);
            	istButton.setEnabled(false);
            	eliasButton.setEnabled(false);
            	
            	goToButton.setEnabled(true);
            	
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
