package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.weblink.zbcommunity.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */
public class EditAdressActivity extends Activity {
    @BindView(R.id.iv_left)
    ImageButton ivLeft;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.edit_top_view)
    View editTopView;
    @BindView(R.id.ed_r1)
    TextView edR1;
    @BindView(R.id.ed_r2)
    TextView edR2;
    @BindView(R.id.edit_Spinn)
    Spinner editSpinn;
    @BindView(R.id.ed_r3)
    TextView edR3;
    @BindView(R.id.edit_adress)
    EditText editAdress;
    @BindView(R.id.ed_r4)
    TextView edR4;
    @BindView(R.id.edit_home)
    EditText editHome;
    @BindView(R.id.ed_r5)
    TextView edR5;
    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.ed_r6)
    TextView edR6;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.ed_r0)
    LinearLayout edR0;
    @BindView(R.id.ed_save)
    Button edSave;
    @BindView(R.id.edit_delelt)
    Button editDelelt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_adress);

        ButterKnife.bind(this);

        ArrayList<String> list=new ArrayList<String>();
        list.add("博山");
        list.add("张店");
        list.add("淄川");
        list.add("高清");
        list.add("桓台");

        ArrayAdapter<String> aaa=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editSpinn.setAdapter(aaa);





        Intent intent = getIntent();
        String kind = intent.getStringExtra("kind");
        //新增页面跳转
        if(kind.equals("xinzeng")){

            tvTitle.setText("新增收货地址");
            editDelelt.setVisibility(View.GONE);

        }
        //编辑页面跳转
        if(kind.equals("bianji")){
            tvTitle.setText("编辑收货地址");

        }




    }
}
