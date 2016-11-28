package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.weblink.zbcommunity.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */
public class EditAdressActivity extends Activity implements View.OnClickListener {
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
        edSave.setOnClickListener(this);
        editDelelt.setOnClickListener(this);
        ivLeft.setVisibility(View.VISIBLE);
        ivLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<String> list=new ArrayList<String>();
        list.add("博山");
        list.add("张店");
        list.add("淄川");
        list.add("高清");
        list.add("桓台");

        ArrayAdapter<String> aaa=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list);
        aaa.setDropDownViewResource(R.layout.spinner);
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

    @Override
    public void onClick(View v) {
        if(v==edSave){
            //后台交互添加收货地址 修改收货地址
            ToastUtils.showToast(this,"新添加收货地址成功！");
            finish();
        }
        if(v==editDelelt){
            //后台交互删除收货地址
            new AlertDialog.Builder(this)
                    .setTitle("删除收货地址")
                    .setMessage("确定删除此收货地址么？")
                    .setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //传输后台设为默认地址
                            finish();

                        }
                    })
                    .setNegativeButton("否", null)
                    .show();


        }
    }
}
