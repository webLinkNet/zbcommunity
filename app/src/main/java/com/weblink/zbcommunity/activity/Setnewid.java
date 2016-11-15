package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.weblink.zbcommunity.R;


public class Setnewid extends Activity implements OnClickListener {


	ImageView registe_back;
	Button authcode;
	EditText registe_authcode;
	EditText registe_phone;
	EditText registe_passwagain;
	EditText registe_passw;
	Button setnew;
	String phone;
	String yanzheng;
	String passw;
	String passwagain;


	@Override
	protected void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);
		setContentView(R.layout.setnewid);

		registe_back = (ImageView) findViewById(R.id.registe_back);//返回
		registe_back.setOnClickListener(this);
		authcode = (Button) findViewById(R.id.authcode);//验证
		authcode.setOnClickListener(this);
		registe_phone = (EditText) findViewById(R.id.registe_phone);//手机号
		setnew = (Button) findViewById(R.id.setnew);//注册
		setnew.setOnClickListener(this);
		registe_authcode = (EditText) findViewById(R.id.registe_authcode);//验证码
		registe_passw = (EditText) findViewById(R.id.registe_passw);//密码
		registe_passwagain = (EditText) findViewById(R.id.registe_passwagain);//两次密码


	}

	@Override
	public void onClick(View v) {

		//返回登录界面
		if (v == registe_back) {

			Intent intent = new Intent(Setnewid.this, Login.class);
			startActivity(intent);
		}
		//发送验证码
		if (v == authcode) {
			phone = registe_phone.getText().toString();
			if (phone == null || "".equals(phone.trim())) {
				Toast.makeText(Setnewid.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (phone.length() != 11) {
				Toast.makeText(Setnewid.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
				return;
			}
		}
		//注册
		if (v == setnew) {
			passwagain = registe_passwagain.getText().toString();
			passw = registe_passw.getText().toString();
			yanzheng = registe_authcode.getText().toString();
			phone = registe_phone.getText().toString();
			if (phone == null || "".equals(phone.trim())) {
				Toast.makeText(Setnewid.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (phone.length() != 11) {
				Toast.makeText(Setnewid.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
				return;
			}
			if (yanzheng == null || "".equals(yanzheng.trim())) {

				Toast.makeText(Setnewid.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (passw == null || "".equals(passw.trim())) {

				Toast.makeText(Setnewid.this, "密码不能为空", Toast.LENGTH_SHORT).show();
				return;
			}
			if (passw.length() < 6 || passw.length() > 16) {

				Toast.makeText(Setnewid.this, "密码长度请控制在6-16位", Toast.LENGTH_SHORT).show();
				return;
			}
			if (passwagain == null || "".equals(passwagain.trim())) {

				Toast.makeText(Setnewid.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
				return;
			}
			if (!passw.equals(passwagain)) {

				Toast.makeText(Setnewid.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
				return;
			}
			//加判断验证码的地方
			Intent intentzhuce = new Intent(Setnewid.this, Login.class);
			startActivity(intentzhuce);


		}


	}
}