package com.leozkt.commonbusiness;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static SharedPreferenceHelper getHelper(String name, Context context) {
        return new SharedPreferenceHelper(name, context);
    }

    public static SharedPreferences getSharedPreferences(String name, Context context) {
        return context.getApplicationContext().getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    private SharedPreferenceHelper(String name, Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }


    public void put(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void put(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void put(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    public void put(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public void put(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    public void put(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.commit();
    }

    public void put(final String key, final double value) {
        editor.putLong(key, Double.doubleToRawLongBits(value));
        editor.commit();
    }

    public void commit() {
        editor.commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    double getDouble(final String key, final double defaultValue) {
        return Double.longBitsToDouble(sharedPreferences.getLong(key, Double.doubleToLongBits(defaultValue)));
    }

    public float getFloat(String key) {
        return sharedPreferences.getFloat(key, 0);
    }

    public Set<String> getStringSet(String key) {
        return sharedPreferences.getStringSet(key, null);
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, "");
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }


    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, 0);
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, 0);
    }

    public float getFloat(String key, float defValue) {
        return sharedPreferences.getFloat(key, 0);
    }

    public Set<String> getStringSet(String key, Set<String> defValue) {
        return sharedPreferences.getStringSet(key, null);
    }

    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }

    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }
}
