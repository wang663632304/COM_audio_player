package com.baidu.com.base.audioplayer;

import java.io.File;
import java.io.FileNotFoundException;

import com.baidu.utils.LogUtil;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * 语音播放类
 * @author huangweigan
 * @version 1.0
 * @date 2012-11-13
 */
public class ExtAudioPlayer
{
	
//	private AudioPlayerButton mImageButton = null;
	
	private ImageButton mImageButton = null;
	
	private AudioPlayerSeekBar mSeekBar = null;
	
	private boolean mIsPlaying = false;
	
	private MediaPlayer mMediaPlayer = null;
	
	private String mFilePath = null;
	
	private Handler mHandler = null;
	
	private Context mContext = null;

	public ExtAudioPlayer(Context context, ViewGroup parent) throws NullPointerException
	{	
		mSeekBar = (AudioPlayerSeekBar) parent.findViewById(R.id.seekbar_audioplayer);
		mImageButton = (ImageButton) parent.findViewById(R.id.button_audioplayer);
		mImageButton.setOnClickListener(mOnClickListener);
		mContext = context;
		mIsPlaying = false;
	}
	
	public void setSrc(String filePath) throws Exception
	{
		if(filePath == null)
		{
			throw new IllegalArgumentException();
		}
		
		File file = new File(filePath);
		if(file.exists() == false)
		{
			throw new FileNotFoundException();
		}
		
		mFilePath = filePath;		
	}
	
	public void setHanlder(Handler handler) throws IllegalArgumentException
	{
		if(handler == null)
		{
			throw new IllegalArgumentException();
		}
		
		mHandler = handler;
	}
	
	private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mIsPlaying == false)
			{
				mImageButton.setBackgroundResource(R.drawable.icon_zoomin_disable);
				mIsPlaying = true;
				if(mFilePath != null)
				{
					Uri uri = Uri.parse(mFilePath); 
					mMediaPlayer = MediaPlayer.create(mContext, uri);
					mSeekBar.setMax(mMediaPlayer.getDuration());
					mMediaPlayer.start();
					mHandler.post(updateThread);
				}
			}
			else
			{
				mImageButton.setBackgroundResource(R.drawable.icon_zoomin_enable);
				mIsPlaying = false;
				mMediaPlayer.stop();
				mHandler.removeCallbacks(updateThread);
				mSeekBar.setProgress(0);
			}
//			LogUtil.e("click!!");
		}
	};
	
	private Runnable updateThread = new Runnable(){

		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			if(mMediaPlayer != null)
			{
				int position = mMediaPlayer.getCurrentPosition();
				mSeekBar.setProgress(mMediaPlayer.getCurrentPosition());
				if(position == mMediaPlayer.getDuration())
				{
					mMediaPlayer.stop();
					mHandler.removeCallbacks(updateThread);
					mSeekBar.setProgress(0);
				}
				else 
				{
					mHandler.postDelayed(updateThread, 100);
				}
			}
		}
	
	};
}
