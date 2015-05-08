/**
 * 
 */
package cn.tranway.ui;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.tranway.base.BaseActivity;
import cn.tranway.business.Register;
import cn.tranway.utils.Constant;

/**
 * @author B03
 *
 */
public class RegisterActivity extends BaseActivity {
	
	@InjectView(R.id.register_user_uphone)
	TextView mUphone;
	@InjectView(R.id.register_user_password)
	TextView mUpassWord;
	@InjectView(R.id.register_user_password_again)
	TextView mUpassWordAgain;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_register);
	}
	
	@OnClick(R.id.register_register)
	public void register(){
		Map<String,String> user = new HashMap<String,String>();
		String uphone = mUphone.getText().toString();
		String upassWord = mUpassWord.getText().toString();
		String pass = mUpassWordAgain.getText().toString();
		if(upassWord.equals(pass)){
			user.put("uphone", uphone);
			user.put("upass", upassWord);
			new Register().register(Constant.REGISTE,user);
		}
	}
}
