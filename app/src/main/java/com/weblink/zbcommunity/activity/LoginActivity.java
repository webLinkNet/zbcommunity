package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.weblink.zbcommunity.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity implements OnClickListener {
    TextView title;
    TextView login_regNewId;
    Button login_Btn_login;
    EditText login_Edt_Name;
    EditText login_Edt_Pwd;
    TextView login_link_FindPwd;
    ImageButton left;


    String phone;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        left = (ImageButton) findViewById(R.id.iv_left);
        left.setVisibility(View.GONE);
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
            if(isMobileNO(phone)==false){
                Toast.makeText(LoginActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if (pass == null || "".equals(pass.trim())) {
                Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }


            //获取系统当前的时间
            SimpleDateFormat formatter   =   new    SimpleDateFormat    ("yyyy-MM-dd HH:mm:ss     ");
            Date curDate    =   new    Date(System.currentTimeMillis());
            String    str    =    formatter.format(curDate);

            Intent intentmine = new Intent(LoginActivity.this, MainActivity.class);
            SharedPreferences settings = getSharedPreferences("checklogin",0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("checklogin","1");
            editor.commit();
            startActivity(intentmine);


        }

    }
    public static boolean isMobileNO(String mobiles){

        String regExp = "^[1][0-9]{10}$";

       Pattern p = Pattern.compile(regExp);

        Matcher m = p.matcher(mobiles);

        return m.matches();
    }
}

