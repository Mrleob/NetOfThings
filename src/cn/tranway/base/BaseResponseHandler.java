package cn.tranway.base;

import org.apache.http.Header;
import org.json.JSONObject;

import android.util.Log;
import cn.tranway.utils.HttpHelper;

import com.loopj.android.http.JsonHttpResponseHandler;

public class BaseResponseHandler extends JsonHttpResponseHandler {
	protected String TAG;
	protected HttpHelper mHelper;
	public BaseResponseHandler(){
		TAG = this.getClass().getSimpleName();
		mHelper = new HttpHelper();
	}
	
	@Override
	public void onFailure(int statusCode, Header[] headers,	Throwable throwable, JSONObject errorResponse) {
		if(null != errorResponse){
			Log.d(TAG, "errorResponse-->"+errorResponse.toString());
		}
	}
}
