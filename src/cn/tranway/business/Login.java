package cn.tranway.business;

import java.util.Map;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import cn.tranway.base.ActivityTack;
import cn.tranway.base.BaseResponseHandler;
import cn.tranway.ui.MainActivity;
import cn.tranway.utils.SharedPreUtils;


public class Login  extends BaseResponseHandler {
	private ActivityTack mAtack = ActivityTack.getInstanse();
	private final Activity mActivity = mAtack.getActivityByClassName("LoginActivity");;
	
	
	public void login(String icode, Map<String,String> user){
		mHelper.login(icode, user,new Login());
	}
	
	@Override
	public void onSuccess(int statusCode, Header[] headers,	JSONObject response){
		try {
			Log.w(TAG,response.toString());
			if("0000".equals(response.getString("responsecode"))){
				mActivity.startActivity(new Intent(mActivity,MainActivity.class));
				SharedPreUtils sUtils = new SharedPreUtils();
				Editor editor = sUtils.getEditor("userinfo");
				editor.putString("token", response.getJSONObject("body").getString("token"));
				editor.putString("uid", response.getJSONObject("body").getString("uid"));
				editor.commit();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
