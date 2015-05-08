package cn.tranway.base;


import cn.tranway.utils.HttpHelper;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import butterknife.ButterKnife;

public class BaseActivity extends FragmentActivity{

	/**
	 * 屏幕的宽度、高度、密度
	 */
	protected int mScreenWidth;
	protected int mScreenHeight;
	protected float mDensity;
	protected Context mContext;
	protected String TAG; // 打印的名称
	protected HttpHelper mHttpHepler ;
	
	protected Boolean isfinish = false;
	protected ActivityTack tack = ActivityTack.getInstanse();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	     requestWindowFeature(Window.FEATURE_NO_TITLE);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mContext = this;
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mScreenWidth = metric.widthPixels;
		mScreenHeight = metric.heightPixels;
		mDensity = metric.density;
		TAG = this.getClass().getSimpleName();
		mHttpHepler = new HttpHelper();
		tack.addActivity(this);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
		ButterKnife.inject(this);

	}
	
	/** 通过Class跳转界面 **/
	protected void startActivity(Class<?> cls) {
		startActivity(cls, null);
	}

	/** 含有Bundle通过Class跳转界面 **/
	protected void startActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/** 通过Action跳转界面 **/
	protected void startActivity(String action) {
		startActivity(action, null);
	}

	/** 含有Bundle通过Action跳转界面 **/
	protected void startActivity(String action, Bundle bundle) {
		Intent intent = new Intent();
		intent.setAction(action);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

//	/**
//	* Toast
//	* @param message
//	*/
//	protected void showShort(String message) {
//		T.showShort(mContext, message);
//	}
//
//	/**
//	* Toast
//	* @param message
//	*/
//	protected void showLong(String message) {
//		T.showLong(mContext, message);
//	}

	@Override
	public void finish() {
		super.finish();
		tack.removeActivity(this);

	}
	
}
