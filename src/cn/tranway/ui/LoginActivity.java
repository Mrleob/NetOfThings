/**
 * 
 */
package cn.tranway.ui;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.tranway.base.BaseActivity;
import cn.tranway.business.Login;
import cn.tranway.service.TcpService;
import cn.tranway.utils.Constant;

/**
 * @author B03
 *
 */
public class LoginActivity extends BaseActivity {

	@InjectView(R.id.user_uphone)
	TextView mUphone;
	@InjectView(R.id.user_password)
	TextView mPassword;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
//		Intent intent = new Intent(this,TcpService.class);
//		startService(intent);
	}
	
	@OnClick(R.id.login)
	public void login(Button button){
		String uphone = mUphone.getText().toString();
		String upassword = mPassword.getText().toString();
		Map<String,String> user = new HashMap<String,String>();
		user.put("uphone", uphone);
		user.put("upass", upassword);
		//mHttpHepler.login(this,Constant.LOGIN, user);
		new Login().login(Constant.LOGIN, user);
	}
	
	@OnClick(R.id.login_register)
	public void toRegister(TextView view){
		startActivity(RegisterActivity.class);
	}
}
