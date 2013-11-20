package main;

import jim.h.common.android.lib.zxing.sample.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WrongQRCode extends Activity {
	
	//private Handler        handler = new Handler();
    //private TextView       txtScanResult;
    //private ZXingLibConfig zxingLibConfig;
    
   // private String scanResultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_qrcode);
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		//zxingLibConfig = new ZXingLibConfig();
        //zxingLibConfig.useFrontLight = true;
        
        Button reScanButton = (Button) findViewById(R.id.rescanButton);    	
		reScanButton.getBackground().setColorFilter(new LightingColorFilter(0x073763, 0x073763));
		
		
		reScanButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	//IntentIntegrator.initiateScan(WrongQRCode.this, zxingLibConfig);
            }
        });
		
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.wrong_qrcode, menu);
        return true;
    }
    /*
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
                        	
                        	Intent intent= new Intent(WrongQRCode.this, GetDirections.class);
                        	
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
    */
}
