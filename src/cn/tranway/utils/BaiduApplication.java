package cn.tranway.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;

public class BaiduApplication extends Application{
	
	private static Context mContext;
	
	@Override
	public void onCreate() {
		super.onCreate();
		// ��ʹ�� SDK �����֮ǰ��ʼ�� context ��Ϣ������ ApplicationContext
		SDKInitializer.initialize(this);
		mContext = getApplicationContext();
	}
	
	public Context getContext(){
		if(mContext == null){
			Log.d("liubin","context can not be null");
		}
		return mContext;
	}
}
