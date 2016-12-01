package com.weblink.zbcommunity.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.weblink.zbcommunity.R;

public class ChangeActivity extends Activity implements OnClickListener{

    private TextView title;
    private TextView back;
    private ImageButton backk;
    Button change_authcode;
    EditText change_authcodeedtext;
    EditText change_phone;
    EditText change_passwagain;
    EditText change_passw;
    Button change;
    String phone;
    String yanzheng;
    String passw;
    String passwagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);
        title=(TextView)findViewById(R.id.tv_title);
        title.setText("忘记密码");
        back = (TextView) findViewById(R.id.tv_left);//返回
        backk=(ImageButton)findViewById(R.id.iv_left);
        back.setVisibility(View.GONE);
        backk.setVisibility(View.VISIBLE);
        backk.setOnClickListener(this);
        change_authcode = (Button) findViewById(R.id.change_authcode);//验证
        change_authcode.setOnClickListener(this);
        change_phone = (EditText) findViewById(R.id.change_phone);//手机号
        change = (Button) findViewById(R.id.change);//修改
        change.setOnClickListener(this);
        change_authcodeedtext = (EditText) findViewById(R.id.change_authcodeedtext);//验证码
        change_passw = (EditText) findViewById(R.id.change_passw);//密码
        change_passwagain = (EditText) findViewById(R.id.change_passwagain);//两次密码
    }

    @Override
    public void onClick(View v) {

//返回登录界面
        if (v == backk) {

            Intent intent = new Intent(ChangeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
//发送验证码
        if (v == change_authcode) {
            phone = change_phone.getText().toString();
            if (phone == null || "".equals(phone.trim())) {
                Toast.makeText(ChangeActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (phone.length() != 11) {
                Toast.makeText(ChangeActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if(LoginActivity.isMobileNO(phone)==false){
                Toast.makeText(ChangeActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //注册
        if (v == change) {
            passwagain = change_passwagain.getText().toString();
            passw = change_passw.getText().toString();
            yanzheng = change_authcodeedtext.getText().toString();
            phone = change_phone.getText().toString();
            if (phone == null || "".equals(phone.trim())) {
                Toast.makeText(ChangeActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (phone.length() != 11) {
                Toast.makeText(ChangeActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if(LoginActivity.isMobileNO(phone)==false){
                Toast.makeText(ChangeActivity.this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                return;
            }
            if (yanzheng == null || "".equals(yanzheng.trim())) {

                Toast.makeText(ChangeActivity.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (passw == null || "".equals(passw.trim())) {

                Toast.makeText(ChangeActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            if (passwagain == null || "".equals(passwagain.trim())) {

                Toast.makeText(ChangeActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!passw.equals(passwagain)) {

                Toast.makeText(ChangeActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                return;
            }
            //加判断验证码的地方
            Intent intentzhuce = new Intent(ChangeActivity.this, LoginActivity.class);
            startActivity(intentzhuce);


        }


    }

}
