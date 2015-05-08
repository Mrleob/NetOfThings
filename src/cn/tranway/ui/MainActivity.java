package cn.tranway.ui;


import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import butterknife.OnClick;
import cn.tranway.base.BaseActivity;
import cn.tranway.business.Location;
import cn.tranway.business.Orbit;
import cn.tranway.utils.Constant;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;

public class MainActivity extends BaseActivity {

	/**
	 * MapView��ͼ���ؼ�
	 */
	private MapView mMapView;
	
	private BaiduMap mBaiduMap;

	private BitmapDescriptor mLocation = BitmapDescriptorFactory
			.fromResource(R.drawable.icon_gcoding);
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		init();
		//���õ�ͼ���ż���
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(14.0f);
		mBaiduMap.setMapStatus(msu);
	}
	
	private void init(){
		mMapView = (MapView)findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
	}
	
	@Override
	protected void onPause() {
		// MapView������������Activityͬ������activity����ʱ�����MapView.onPause()
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// MapView������������Activityͬ������activity����ʱ�����MapView.onResume()
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// MapView������������Activityͬ������activity����ʱ�����MapView.destroy()
		mMapView.onDestroy();
		super.onDestroy();
		//���� bitmap ��Դ
		mLocation.recycle();
	}
	 
	@OnClick(R.id.getLocation)
	public void showLocation(Button button){
		Log.d(TAG,"showLocation()");
		Map<String,String> user = new HashMap<String, String>();
		user.put("tphone", "123123");
		Location loca = new Location();
		loca.showLocation(Constant.GET_LOCATION,user,mBaiduMap,mLocation);
	}
	
	@OnClick(R.id.getOrbit)
	public void showOrbit(Button button){
		Log.d(TAG,"showOrbit()");
		Map<String,String> user = new HashMap<String, String>();
		user.put("tphone", "123123");
		new Orbit().showOrbit(Constant.GET_ORBIT,user,mBaiduMap);
	}
	


}
