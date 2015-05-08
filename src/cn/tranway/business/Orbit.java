package cn.tranway.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;

import cn.tranway.base.BaseResponseHandler;

public class Orbit extends BaseResponseHandler {

	private static BaiduMap mBaiduMap;
	private JSONObject mBody;
	private JSONArray mPoslist;
	
	public void showOrbit(String icode, Map<String, String> user, BaiduMap map){
		mBaiduMap = map;
		mHelper.showOrbit(icode, user, new Orbit());
	}
	
	@Override
	public void onSuccess(int statusCode, Header[] headers,	JSONObject response) {
		Log.w("liubin", "onSuccess");
		List<LatLng> points = new ArrayList<LatLng>();
		LatLng point;
		LatLng cenpt;
		try {
			mBody = (JSONObject) response.get("body");
			mPoslist = mBody.getJSONArray("poslist");
			JSONObject centerj = mPoslist.getJSONObject(0);
			cenpt = new LatLng(centerj.getDouble("lat"), centerj.getDouble("lon"));
			MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(cenpt);
			mBaiduMap.animateMapStatus(status);
			for (int i = 0; i < mPoslist.length(); i++) {
				JSONObject json = mPoslist.getJSONObject(i);
				point = new LatLng(json.getDouble("lat"), json
						.getDouble("lon"));
				points.add(point);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mBaiduMap.clear();
		OverlayOptions ooPolyline = new PolylineOptions().width(10).color(0xAAFF0000).points(points);
		mBaiduMap.addOverlay(ooPolyline);
	}
}
