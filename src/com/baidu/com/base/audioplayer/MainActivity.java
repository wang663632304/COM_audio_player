package com.baidu.com.base.audioplayer;

import java.util.IllegalFormatCodePointException;
import com.baidu.utils.LogUtil;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity {

	private Handler mHandler = new Handler();
	
	private ExtAudioPlayer mAudioPlayBar = null;
	
	private ImageButton mImageButton = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		setupViews();
	}
	
	public void setupViews()
	{
		
		LinearLayout main = (LinearLayout) findViewById(R.id.audioplayerbar);
		try
		{
			mAudioPlayBar = new ExtAudioPlayer(this, main);
			mAudioPlayBar.setHanlder(mHandler);
			mAudioPlayBar.setSrc("/sdcard/1.3gpp");
			
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
