package com.weblink.zbcommunity.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {
	public static String SPATH = Environment.getExternalStorageDirectory()+
			"/jz/";
	
	public static File saveBitmap(Bitmap bm, String picName){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int option = 100;
		bm.compress(Bitmap.CompressFormat.JPEG, option, baos);
		//如果目录不存在，则创建目录
		if(!isFileExist(picName)){
			try {
				createSDDir("");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream fos = null;
		File f = new File(SPATH+picName+".JPEG");
		if(f.exists()){
			f.delete();
		}
		try {
			fos = new FileOutputStream(f);
			fos.write(baos.toByteArray());
			fos.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return f;
	}
	
	public static Bitmap decodeSampleBitmapFromResource(String path,
														int reqWith, int reqHeight){
		//第一次解析将inJustDecodeBounds设置为true,来获取图片大小 
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Config.RGB_565;
		options.inJustDecodeBounds = true;
		//BitmapFactory.decodeStream(path,options);
		BitmapFactory.decodeFile(path, options);
		//根据传入的宽和高，计算出和合适的inSampleSize的值
		options.inSampleSize = calInSampleSize(options,reqWith,reqHeight);
		//使用获取到的inSampleSize值再次解析图片
		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeFile(path, options);
	}
	/**
	 * 根据传入的宽和高，计算出和合适的inSampleSize的值
	 * @param options
	 * @param reqWidth
	 * @param reqHeight
	 * @return
	 */
	public static int calInSampleSize(BitmapFactory.Options options, int reqWidth,
									  int reqHeight){
		//源图片的高度和宽度
		int width = options.outWidth;
		int height = options.outHeight;
		int inSampleSize = 1;
		if(height>reqHeight || width>reqWidth){
			//计算出实际宽高和目标宽高的比例
			int heightRatio = Math.round((float)height/(float)reqHeight);
			int widthRatio = Math.round((float)width/(float)reqWidth);
			inSampleSize = heightRatio<widthRatio?heightRatio:widthRatio;
		}
		return inSampleSize;
	}
	private static boolean isFileExist(String fileName){
		File f = new File(SPATH + fileName);
		return f.exists();
	}
	private static File createSDDir(String dirName) throws IOException {
		File dir = new File(SPATH+dirName);
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			System.out.println("createSDDir:"+dir.getAbsolutePath());
			System.out.println("createSDDir:"+dir.mkdirs());
		}
		return dir;
	}
}
