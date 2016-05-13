package cn.it.homework6;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cn.it.homework6.db.dao.DBUtils;
import cn.it.homework6.utils.Constants;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText mAccountEdt;//账号编辑框
	private EditText mPwdEdt;//密码编辑框
	private Context context;//上下文
	private CheckBox mRemenberChx;//复选框
	private SharedPreferences mSp;//偏好设置存储对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		//1.初始化视图
		initView();
		
		//2.自动填充数据
		autoFill();
	}
	
	//自动填充数据
	private void autoFill() {
		if(mSp.getBoolean("isChecked", false)){ //存储的复选状态为 真 
			mAccountEdt.setText(mSp.getString("username", null));
			try {
				mPwdEdt.setText( mSp.getString("password", null));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mRemenberChx.setChecked(true);
		}
		
	}
	private void initView() {
		mAccountEdt=(EditText)findViewById(R.id.account_et);
		mPwdEdt=(EditText)findViewById(R.id.pwd_et);
		mRemenberChx=(CheckBox)findViewById(R.id.remenber_chb);
		context=this;
		mSp=getSharedPreferences("info", Context.MODE_PRIVATE);		
	}
	//登录方法
	public void login(View v){
		final String account=mAccountEdt.getText().toString().trim();//用户输入的账号
		final String pwd=mPwdEdt.getText().toString().trim();//用户输入的密码
		//1.用户名和密码都不能为空 ,前端验证格式
		if(TextUtils.isEmpty(account)||TextUtils.isEmpty(pwd)){
			Toast.makeText(context, "用户名或者密码不能为空", Toast.LENGTH_SHORT).show();
			return;
		}
		
		
		// 通过AndroidAsyncHttp框架访问网络，从网络中验证用户名和密码
		AsyncHttpClient httpClient=new AsyncHttpClient();
		//2. 设置请求参数
		RequestParams params=new RequestParams();
		params.add("account", account);
		params.add("pwd", pwd);
		// 发送请求
		httpClient.post(Constants.WEB_LOGIN, params, new AsyncHttpResponseHandler() {
			//访问网络成功 ，包含验证成功和验证失败的返回信息
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
						remenberInfo(account,pwd);
				try {
					JSONObject jsonObject=new JSONObject(new String(responseBody));
					if(jsonObject.getBoolean("success")){//验证成功
						//保存账号信息
						remenberInfo(account, pwd);
						
						// 把账号信息通过SharedPreferes保存 
						mSp.edit().putString("nick", jsonObject.getString("msg")).commit();
						//进入到HomeActivity
						Intent intent=new Intent();
						intent.setClass(context, HomeActivity.class);
						startActivity(intent);//执行意图
						finish();//关闭当前的Activity
					}else{//验证失败
						Toast.makeText(getApplicationContext(), jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
						mAccountEdt.setText(null);
						mPwdEdt.setText(null);
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			//访问网络失败
			@Override
			public void onFailure(int statusCode, Header[] headers,
					byte[] responseBody, Throwable error) {
				Toast.makeText(getApplicationContext(), "网络访问异常-直接进入系统", 0).show();
				Intent intent=new Intent();
				intent.setClass(context, HomeActivity.class);
				startActivity(intent);//执行意图
				finish();//关闭当前的Activity
			}
		});
	
	}
	
	//记住用户信息
	private void remenberInfo(String account, String pwd) {
		Editor edit = mSp.edit();//取得编辑器
		//先判断复选框是否选择
		if(mRemenberChx.isChecked()){
			
			edit.putString("username", account);
			// seed :加密的种子，密钥     clearText ：明文，原文
			try {
				edit.putString("password", pwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			edit.putBoolean("isChecked", true);
		}else{
			edit.putBoolean("isChecked", false);
		}
		edit.commit();//提交数据
	}
	
	//注册
	public void register(View v){
		Toast.makeText(getApplicationContext(), "注册太晚了", 0).show();
	}
	
	

}
