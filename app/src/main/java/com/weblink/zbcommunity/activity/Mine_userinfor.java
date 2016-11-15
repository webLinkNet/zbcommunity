package com.weblink.zbcommunity.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.weblink.zbcommunity.R;
import com.weblink.zbcommunity.utils.CircleUtils;
import com.weblink.zbcommunity.utils.FileUtils;
import java.io.File;

/**
 * Created by jz on 2016/11/14.
 */
public class Mine_userinfor extends Activity implements View.OnClickListener {
    ImageView mine_user_back;
    RelativeLayout mine_user_re_img;
    Button mine_user_set;
    CircleUtils mine_userinfor_img;
    EditText mine_userinfor_name;
    public static final int PIC_TAKE_PHOTO = 1;
    public static final int PIC_SELECT_FROM_ALBUM = 2;
    //拍照地址
    private String capturePath = null;
    //选择摄像头，相册弹框
    private PopupWindow mPopupwindow;
    private View view_pop;
    //选择上传进度弹框
    private PopupWindow loadPopupWindow;
    private View view_writeupload;
    //popupWindow里面的按钮
    private TextView tv_takePhoto;
    private TextView tv_takeImage;
    private TextView tv_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_userinfor);
        mine_user_re_img=(RelativeLayout) findViewById(R.id.mine_user_re_img);
        mine_user_re_img.setOnClickListener(this);
        mine_user_set=(Button) findViewById(R.id.mine_user_set);
        mine_user_set.setOnClickListener(this);
        mine_userinfor_name=(EditText)findViewById(R.id.mine_userinfor_name);
        mine_user_back=(ImageView)findViewById(R.id.mine_user_back);
        mine_user_back.setOnClickListener(this);
        mine_userinfor_img = (CircleUtils) findViewById(R.id.mine_userinfor_img);
        view_pop = LayoutInflater.from(this).inflate(
                R.layout.mine_change_head, null);
        tv_cancel = (TextView)view_pop.findViewById(R.id.mine_change_head_cancel);
        tv_takePhoto = (TextView)view_pop.findViewById(R.id.mine_change_head_takePhoto);
        tv_takeImage = (TextView)view_pop.findViewById(R.id.mine_change_head_takeImage);
        tv_cancel.setOnClickListener(this);
        tv_takePhoto.setOnClickListener(this);
        tv_takeImage.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //头像
        if(v==mine_user_re_img){
            if(mPopupwindow == null){
                //新建一个popupWindow
                mPopupwindow = new PopupWindow(view_pop,
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
                        true);
                //设置popupWindow的背景颜色
                mPopupwindow.setBackgroundDrawable(new ColorDrawable(0xAA000000));
            }
            //设置popupWindow的位置,
            mPopupwindow.showAtLocation(v, Gravity.CENTER| Gravity.BOTTOM, 0, 0);
            mPopupwindow.setFocusable(true);
            mPopupwindow.update();
        }

        if(v == tv_cancel){
            mPopupwindow.dismiss();
        }
        if(v == tv_takePhoto){		//拍照
            //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
//申请WRITE_EXTERNAL_STORAGE权限
                ActivityCompat.requestPermissions(this, new
                                String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                       1);
            }
            getImageFromCamera();

        }
        if(v == tv_takeImage){		//相册选择
            //判断用户是否给与权限
            if(ContextCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
             //申请WRITE_EXTERNAL_STORAGE权限
                ActivityCompat.requestPermissions(this, new
                                String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,PIC_SELECT_FROM_ALBUM);
        }
        //确定
       if(v==mine_user_set){

        }
        //返回
        if(v==mine_user_back){
            finish();
        }
    }
    private void getImageFromCamera(){
        String state = Environment.getExternalStorageState();
        if(state.equals(Environment.MEDIA_MOUNTED)){
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            String out_file_path = FileUtils.SPATH;
            File dir = new File(out_file_path);
            if(!dir.exists())
                dir.mkdirs();
            capturePath = out_file_path + System.currentTimeMillis()+".jpg";
            //指定摄像头拍照后图片的存盘路径!!!必须Uri类型
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
                    new File(capturePath)));
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            startActivityForResult(intent,PIC_TAKE_PHOTO);
        }
        else{
            Toast.makeText(this,"请确定已经插入SD卡", Toast.LENGTH_SHORT).show();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PIC_TAKE_PHOTO:					//用户选择从摄像头拍照后返回处理
                if(resultCode == Activity.RESULT_OK){
                    File file = new File(capturePath);
                    //对图片进行预处理
                    Bitmap bitmap = FileUtils.decodeSampleBitmapFromResource(file.getAbsolutePath(),
                            100, 100);
                    mine_userinfor_img.setImageBitmap(bitmap);
                    file = FileUtils.saveBitmap(bitmap, file.getName());
                    if(file.exists()){
                        //开始上传文件到服务器端
                       // upload(file);
                        mPopupwindow.dismiss();
                    }
                }
                break;
            case PIC_SELECT_FROM_ALBUM:				//用户选择从相册选择图片后返回处理
                if(resultCode == Activity.RESULT_OK){
                    Uri selectedImage = data.getData();
                    String path = selectedImage.getPath();
                    String[] filePathCols = {MediaStore.Images.Media.DATA};
                    //Cursor相当于游标,类似于jdbc ResultSet
                    Cursor c = this.getContentResolver().query(selectedImage, filePathCols,
                            null, null, null);
                    c.moveToFirst();
                    int c1 = c.getColumnCount();
                   // Log.d(Setting.TAG, String.valueOf(c1));
                    int colIdx = c.getColumnIndex(filePathCols[0]);
                    String picPath = c.getString(colIdx);
                    //Log.d(Setting.TAG, picPath);
                    File file = new File(picPath);
                    Bitmap bitmap = FileUtils.decodeSampleBitmapFromResource(picPath,100,100);
                    mine_userinfor_img.setImageBitmap(bitmap);
                    c.close();
                    //upload(FileUtils.saveBitmap(bitmap, file.getName()));
                    mPopupwindow.dismiss();
                }
                break;
            default:
                break;
        }
    }
}
