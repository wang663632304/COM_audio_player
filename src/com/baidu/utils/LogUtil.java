package com.baidu.utils;

import android.util.Log;

/**
 * 日志工具类，集中控制日志的打印
 * 后期考虑打印入file或者上传到服务器等策略
 * 
 * @author yuankai
 * @version 1.0
 * @date 2011-1-19
 */
public class LogUtil
{
	/**
	 * 默认的文库日志Tag标签
	 */
	public final static String DEFAULT_TAG = "iknow";
	
	/**
	 * 此常量用于控制是否打日志到Logcat中
	 * release版本中本变量应置为false
	 */
	private final static boolean LOGGABLE = true;
	
	/**
	 * 打印debug级别的log
	 * @param tag tag标签
	 * @param str 内容
	 */
	public static void d(String tag, String str)
	{
		if(LOGGABLE)
		{
			Log.d(tag, str);
		}
	}
	
	/**
	 * 打印debug级别的log
	 * @param str 内容
	 */
	public static void d(String str)
	{
		if(LOGGABLE)
		{
			Log.d(DEFAULT_TAG, str);
		}
	}
	
	/**
	 * 打印warning级别的log
	 * @param tag tag标签
	 * @param str 内容
	 */
	public static void w(String tag, String str)
	{
		if(LOGGABLE)
		{
			Log.w(tag, str);
		}
	}
	
	/**
	 * 打印warning级别的log
	 * @param str 内容
	 */
	public static void w(String str)
	{
		if(LOGGABLE)
		{
			Log.w(DEFAULT_TAG, str);
		}
	}
	
	/**
	 * 打印error级别的log
	 * @param tag tag标签
	 * @param str 内容
	 */
	public static void e(String tag, String str)
	{
		if(LOGGABLE)
		{
			Log.e(tag, str);
		}
	}
	
	/**
	 * 打印error级别的log
	 * @param str 内容
	 */
	public static void e(String str)
	{
		if(LOGGABLE)
		{
			Log.e(DEFAULT_TAG, str);
		}
	}
	
	/**
	 * 打印info级别的log
	 * @param tag tag标签
	 * @param str 内容
	 */
	public static void i(String tag, String str)
	{
		if(LOGGABLE)
		{
			Log.i(tag, str);
		}
	}
	
	/**
	 * 打印info级别的log
	 * @param str 内容
	 */
	public static void i(String str)
	{
		if(LOGGABLE)
		{
			Log.i(DEFAULT_TAG, str);
		}
	}
	
	/**
	 * 打印verbose级别的log
	 * @param tag tag标签
	 * @param str 内容
	 */
	public static void v(String tag, String str)
	{
		if(LOGGABLE)
		{
			Log.v(tag, str);
		}
	}
	
	/**
	 * 打印verbose级别的log
	 * @param str 内容
	 */
	public static void v(String str)
	{
		if(LOGGABLE)
		{
			Log.v(DEFAULT_TAG, str);
		}
	}
	
}
