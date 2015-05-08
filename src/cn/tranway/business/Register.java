package cn.tranway.business;

import java.util.Map;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import cn.tranway.base.ActivityTack;
import cn.tranway.base.BaseResponseHandler;
import cn.tranway.ui.MainActivity;

public class Register extends BaseResponseHandler {
	private ActivityTack mAtack = ActivityTack.getInstanse();
	private final Activity mActivity = mAtack.getActivityByClassName("LoginActivity");;
	
	public void register(String icode, Map<String,String> user){
		mHelper.register(icode, user,new Register());
	}
	
	@Override
	public void onSuccess(int statusCode, Header[] headers,	JSONObject response){
		try {
			Log.w(TAG,response.toString());
			if("0000".equals(response.getString("responsecode"))){
				mActivity.startActivity(new Intent(mActivity,MainActivity.class));
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
