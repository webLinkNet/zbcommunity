package com.weblink.zbcommunity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.adapter.ChooseadressAdpter;
import com.weblink.zbcommunity.bean.AdressBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class ChooseAdressActivity extends Activity {
    List<AdressBean> data = new ArrayList<>();
    ChooseadressAdpter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooseadress);
        initdata();
        TextView total=(TextView)findViewById(R.id.tv_title);
        total.setText("选择收货地址");
       ImageButton left=(ImageButton)findViewById(R.id.iv_left);
        Button chooseadress_setnew=(Button)findViewById(R.id.chooseadress_setnew);
        chooseadress_setnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt = new Intent(ChooseAdressActivity.this, EditAdressActivity.class);
                intentt.putExtra("kind","xinzeng");
                startActivity(intentt);
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ListView lv=(ListView)findViewById(R.id.chooseadre_lv);
        lv.setDivider(null);
        ad=new ChooseadressAdpter(this,data);
        lv.setAdapter(ad);


    }
    //数据

    public void initdata() {

        AdressBean a=new AdressBean();
        AdressBean a1=new AdressBean();
        AdressBean a2=new AdressBean();
        AdressBean a3=new AdressBean();
        AdressBean a4=new AdressBean();
        AdressBean a5=new AdressBean();
        AdressBean b=new AdressBean();
        AdressBean c=new AdressBean();

        a.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a.setAdressname("焦泽");
        a.setAdressphone("18753377455");
        a.setMoren(1);
        b.setAdressadress("中信大厦B座2501");
        b.setAdressname("梦石头");
        b.setAdressphone("18753377666");
        b.setMoren(2);
        c.setAdressadress("某某小区某某楼某某户");
        c.setAdressname("宋哥");
        c.setAdressphone("18753377777");
        c.setMoren(2);
        a1.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a1.setAdressname("焦泽");
        a1.setAdressphone("18753377455");
        a1.setMoren(2);
        a2.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a2.setAdressname("焦泽");
        a2.setMoren(2);
        a2.setAdressphone("18753377455");
        a3.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a3.setAdressname("焦泽");
        a3.setAdressphone("18753377455");
        a3.setMoren(2);
        a4.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a4.setAdressname("焦泽");
        a4.setMoren(2);
        a4.setAdressphone("18753377455");
        a5.setAdressadress("山东理工大学西校区六号楼335宿舍");
        a5.setAdressname("焦泽");
        a5.setMoren(2);
        a5.setAdressphone("18753377455");

        data.add(a);
        data.add(b);
        data.add(c);
        data.add(a1);
        data.add(a2);
        data.add(a3);
        data.add(a4);
        data.add(a5);




    }
}
