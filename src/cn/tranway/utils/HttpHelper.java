package cn.tranway.utils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import android.content.Context;
import cn.tranway.base.BaseClass;
import cn.tranway.business.Location;
import cn.tranway.business.Login;
import cn.tranway.business.Orbit;
import cn.tranway.business.Register;

import com.loopj.android.http.AsyncHttpClient;

public class HttpHelper extends BaseClass{
	private AsyncHttpClient mAsyncHttpClient;
	private String mUrl;
	private HttpEntity mEntity;
	private String mContentType;
	private Context mContext;
	public HttpHelper(){
		BaiduApplication appli = new BaiduApplication();
		mContext = appli.getContext();
	}

	public void initPost(String icode, Map<String, String> param) {
		mAsyncHttpClient = new AsyncHttpClient();
		JsonUtils jutils = new JsonUtils();
		JSONObject json = jutils.getRequestJson(icode, param);
		mUrl = "http://192.168.9.63:8099";
		mContentType = "application/json";
		try {
			mEntity = new StringEntity(json.toString());
			((AbstractHttpEntity) mEntity).setContentType(mContentType);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * œ‘ æ∂®Œª
	 * @param interfaceCode
	 * @param param
	 * @param map
	 * @param Location
	 * @return
	 */
	public void showLocation(String interfaceCode,Map<String, String> param, Location location) {
		initPost(interfaceCode, param);
		mAsyncHttpClient.post(mContext, mUrl, mEntity,	mContentType, location); 
	}

	public void showOrbit(String icode, Map<String, String> user, Orbit orbit) {
		initPost(icode, user);
		mAsyncHttpClient.post(mContext, mUrl, mEntity,	mContentType, orbit); 
	}
	
	public void login(String icode, Map<String,String> user, Login loginHandler){
		initPost(icode, user);
		mAsyncHttpClient.post(mContext, mUrl, mEntity, mContentType, loginHandler);
	}
	
	public void register(String icode,Map<String,String> user,Register regHandler){
		initPost(icode, user);
		mAsyncHttpClient.post(mContext, mUrl, mEntity, mContentType, regHandler);
	}
}
