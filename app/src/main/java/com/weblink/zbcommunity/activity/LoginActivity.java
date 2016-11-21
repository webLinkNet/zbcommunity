package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.weblink.zbcommunity.MainActivity;
import com.weblink.zbcommunity.R;

public class LoginActivity extends Activity implements OnClickListener {
    TextView title;
    TextView login_regNewId;
    Button login_Btn_login;
    EditText login_Edt_Name;
    EditText login_Edt_Pwd;
    TextView login_link_FindPwd;


    String phone;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        login_regNewId = (TextView) findViewById(R.id.login_regNewId);
        login_regNewId.setOnClickListener(this);

        login_Btn_login = (Button) findViewById(R.id.login_Btn_login);
        login_Btn_login.setOnClickListener(this);

        login_Edt_Name = (EditText) findViewById(R.id.login_Edt_Name);
        login_Edt_Pwd = (EditText) findViewById(R.id.login_Edt_Pwd);

        login_link_FindPwd = (TextView) findViewById(R.id.login_link_FindPwd);
        login_link_FindPwd.setOnClickListener(this);

        title = (TextView) findViewById(R.id.tv_title);
        title.setText("登录");


    }


    @Override
    public void onClick(View v) {

        //注册新账户

        if (v == login_regNewId) {

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

        //忘记密码
        if (v == login_link_FindPwd) {

            Intent intentchange = new Intent(LoginActivity.this, ChangeActivity.class);
            startActivity(intentchange);

        }

        //登录按钮

        if (v == login_Btn_login) {

            phone = login_Edt_Name.getText().toString();
            pass = login_Edt_Pwd.getText().toString();
            if (phone == null || "".equals(phone.trim())) {
                Toast.makeText(LoginActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (phone.length() != 11) {
                Toast.makeText(LoginActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pass == null || "".equals(pass.trim())) {
                Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intentmine = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intentmine);


        }

    }

}

