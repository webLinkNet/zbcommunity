/**
 *
 */
package com.weblink.zbcommunity.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.weblink.zbcommunity.ZBApplication;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug,coding是一种情怀
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p>
 * /**
 *
 * @author longya
 * @version 创建时间：2015-6-11 下午3:46:16
 *          类说明 :
 * @E-mail: xueyelongya@126.com
 */

public class PrefUtils {

    private static SharedPreferences sp =
            PreferenceManager.getDefaultSharedPreferences(ZBApplication.getContext());


    public static void remove(String key) {
        sp.edit().remove(key).commit();
    }

    public static void putInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public static void putLong(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }

    public static void putString(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public static void putBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public static void putFloat(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    public static int getInt(String key) {
        return sp.getInt(key, -1);
    }

    public static long getLong(String key) {
        return sp.getLong(key, -1L);
    }

    public static String getString(String key) {
        return sp.getString(key, null);
    }

    public static String getString(String key, String defa) {
        return sp.getString(key, defa);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return sp.getBoolean(key, defaultValue);
    }

    public static float getFloat(String key) {
        return sp.getFloat(key, -1f);
    }
}
