package cn.tranway.base;

public class BaseClass {

	protected String TAG;
	public BaseClass(){
		TAG = this.getClass().getSimpleName();
	}
}
