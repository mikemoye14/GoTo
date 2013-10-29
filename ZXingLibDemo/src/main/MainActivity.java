package main;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.TextView;

public class MainActivity extends Activity {
    private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
    
    private static String scanResultTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //txtScanResult = (TextView) findViewById(R.id.scan_result);
        zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;

        View btnScan = findViewById(R.id.scan_button);
        View getInfoButton = findViewById(R.id.getInfoButton);
        View aboutButton = findViewById(R.id.aboutButton);
		
        btnScan.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        getInfoButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        aboutButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
                
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
            	Intent intent= new Intent(MainActivity.this, BuildingList.class);
                startActivity(intent);
            }
        });
        
        
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
                        	
                        	Intent intent= new Intent(MainActivity.this, ChooseDestination.class);
                        	
                        	intent.putExtra("scanResult", scanResultTxt.toUpperCase());
                        	
                            startActivity(intent);
                        	
                        }
                    });
                }
                break;
            default:
        }        
        
    }  
    
    public static String getScanResult(){
    	
    	return scanResultTxt.toUpperCase();
    	
    }
    
    
}
