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
	 * ���� SharedPreferences ʵ��
	 * @param filename
	 * @return
	 */
	public SharedPreferences getSharedpre(String filename){
		mSharedPre = mContext.getSharedPreferences(filename, Context.MODE_APPEND);
		return mSharedPre;
	}
	
	/**
	 * ���� Editor ʵ��
	 * @param filename
	 * @return
	 */
	public Editor getEditor(String filename){
		mSharedPre = mContext.getSharedPreferences(filename, Context.MODE_APPEND);
		mEditor = mSharedPre.edit();
		return mEditor;
	}
		
	
}
