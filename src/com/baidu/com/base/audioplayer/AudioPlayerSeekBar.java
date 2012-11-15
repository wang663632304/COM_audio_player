package com.baidu.com.base.audioplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class AudioPlayerSeekBar extends SeekBar
{

	public AudioPlayerSeekBar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		return false;
	}
}
