package cn.tranway.utils;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import cn.tranway.base.BaseClass;
import android.content.SharedPreferences;
import android.util.Log;

public class JsonUtils extends BaseClass{

	private JSONObject mJson;
	private String mFileName = "userinfo";
	private SharedPreferences mSharedPreferences;
	
	public JsonUtils(){
		SharedPreUtils sUtils = new SharedPreUtils();
		mSharedPreferences = sUtils.getSharedpre(mFileName);
	}
	
	/**
	 * 
	 * @param param 
	 * @return
	 */
	public JSONObject getRequestJson(String interCode,Map<String,String> param){
		String token = mSharedPreferences.getString("token","123456789");
		String requestid = getRequestId();
		String uid = mSharedPreferences.getString("uid","uid");
		HashMap<String ,Object> map = new HashMap<String,Object>();
		map.put("interfacecode", interCode);
		map.put("token", token);
		map.put("requestid",requestid);
		map.put("uid", uid);
		map.put("body", param);
		mJson = new JSONObject(map);
		Log.w(TAG,"mJson--->"+mJson.toString());
		return mJson;
	}
	
	
	
	
	private String getRequestId(){
		String id = System.currentTimeMillis()+"";
		return id;
	}
	
}
