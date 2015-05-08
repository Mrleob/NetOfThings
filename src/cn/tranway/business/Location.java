package cn.tranway.business;

import java.util.Map;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import cn.tranway.base.BaseResponseHandler;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class Location extends BaseResponseHandler {

	private static BaiduMap mBaiduMap;
	private static BitmapDescriptor mLocation;
	
	public void showLocation(String icode, Map<String, String> user, BaiduMap map, BitmapDescriptor location){
		mBaiduMap = map;
		mLocation = location;
		mHelper.showLocation(icode, user, new Location());
	}
	
	@Override
	public void onSuccess(int statusCode, Header[] headers,	JSONObject response) {
		Log.d(TAG, "response-->" + response.toString());
		JSONObject body;
		try {
			body = (JSONObject) response.get("body");
			LatLng location = new LatLng(body.getDouble("lat"), body.getDouble("lon"));
			MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(location);
			mBaiduMap.animateMapStatus(status);
			mBaiduMap.clear();
			OverlayOptions point = new MarkerOptions().position(location)
					.icon(mLocation).zIndex(9).draggable(true);
			mBaiduMap.addOverlay(point);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
