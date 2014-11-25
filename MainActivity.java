package modbrin.libchanger;

import java.io.DataOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity {
    
    TextView text;
	Button btnInst;
	Button btnRest;
	
	
    String[] inst = {"cp /system/lib/libmmcamera_imx179.so /sdcard/LC-Cache/backup/backup.so", "mount -o remount,rw /system", "install -m644 /sdcard/LC-Cache/mod.so /system/lib/libmmcamera_imx179.so", "mount -o remount,ro /system","killall mm-qcamera-daemon mediaserver", "killall pkmx.lcamera"};
	String[] rest = {"mount -o remount,rw /system", "install -m644 /sdcard/LC-Cache/orig.so /system/lib/libmmcamera_imx179.so", "mount -o remount,ro /system","killall mm-qcamera-daemon mediaserver", "killall pkmx.lcamera"};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		text = (TextView) findViewById(R.id.text);
		btnInst = (Button) findViewById(R.id.btnInst);
		btnRest = (Button) findViewById(R.id.btnRest);
		
		
		
		//Process of restoring to original
		OnClickListener oclBtnRest = new OnClickListener() {
			@Override
			public void onClick(View v){
				try {
					SuRun(rest);
				} catch (IOException e) {
					e.printStackTrace();
				}; 
			text.setText("Restored To Normal");
			}	
		};
		btnRest.setOnClickListener(oclBtnRest);
		
		//Process of installing the modification
		OnClickListener oclBtnInst = new OnClickListener() {
			 @Override
			public void onClick(View v){
				 try {
						SuRun(inst);
					} catch (IOException e) {
						e.printStackTrace();
					}; 
			text.setText("Installed Modified Lib");
			}	
		};
		btnInst.setOnClickListener(oclBtnInst);
	}
	public void SuRun(String[] cmds) throws IOException{
        Process p = Runtime.getRuntime().exec("su");
        DataOutputStream os = new DataOutputStream(p.getOutputStream());            
        for (String tmpCmd : cmds) {
                os.writeBytes(tmpCmd+"\n");
        }           
        os.writeBytes("exit\n");  
        os.flush();    
}
}	
