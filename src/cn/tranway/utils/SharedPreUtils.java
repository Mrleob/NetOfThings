package cn.tranway.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.tranway.base.BaseClass;

public class SharedPreUtils extends BaseClass{

	private BaiduApplication mApplication; 
	private Context mContext;
	private SharedPreferences mSharedPre;
	private Editor mEditor;
	
	public SharedPreUtils(){
		mApplication = new BaiduApplication();
		mContext = mApplication.getContext();
	}
	
	/**
	 * 返回 SharedPreferences 实例
	 * @param filename
	 * @return
	 */
	public SharedPreferences getSharedpre(String filename){
		mSharedPre = mContext.getSharedPreferences(filename, Context.MODE_APPEND);
		return mSharedPre;
	}
	
	/**
	 * 返回 Editor 实例
	 * @param filename
	 * @return
	 */
	public Editor getEditor(String filename){
		mSharedPre = mContext.getSharedPreferences(filename, Context.MODE_APPEND);
		mEditor = mSharedPre.edit();
		return mEditor;
	}
		
	
}
