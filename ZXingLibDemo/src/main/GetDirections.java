package main;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;
import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetDirections extends Activity {
	
	private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    private ZXingLibConfig zxingLibConfig;
    
    private String scanResultTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_directions);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;  
        
        TextView toFrom = (TextView) findViewById(R.id.toFromTextView);
        
        toFrom.setText("From " + ChooseDestination.getDestination() + " to " + ChooseDestination.getBeginning());
               
        View newDestinationButton = (Button) findViewById(R.id.newDestinationButton);
    	View reScanDirectionsButton = (Button) findViewById(R.id.reScanDirectionsButton);
    	
    	reScanDirectionsButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        newDestinationButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
        
        
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
                        	
                        	Intent intent= new Intent(GetDirections.this, ChooseDestination.class);
                        	
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

}
