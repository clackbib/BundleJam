package com.habibokanla.bundlejam.bundlejam.processor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.habibokanla.bundlejam.bundlejam.Jam;
import com.habibokanla.bundlejam.bundlejam.UnJam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * Created by habibokanla on 11/09/2014.
 */
public class JamProcessor {
    public static String defaultKey = "HABIB_COM_JAMPROCESSOR";

    @SuppressLint("NewApi")
    public static void jamVariables(Object object) {
        try {
            Class target = object.getClass();
            for (Field field : target.getDeclaredFields()) {
                try {
                    for (Annotation a : field.getDeclaredAnnotations()) {
                        if (a.annotationType() == Jam.class) {
                            Jam jamField = (Jam) a;
                            field.setAccessible(true);
                            Object fieldObject = field.get(object);
                            if (fieldObject != null) {
                                addToPreferences(object, jamField.key(), fieldObject);
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


    public static void unjamVariables(Object object) {
        try {
            Class target = object.getClass();
            for (Field field : target.getDeclaredFields()) {
                try {
                    for (Annotation a : field.getDeclaredAnnotations()) {
                        if (a.annotationType() == UnJam.class) {
                            UnJam unJamField = (UnJam) a;
                            field.setAccessible(true);
                            Object jt = getFromPreferences(object, unJamField.key(), field.getType());
                            field.set(object, jt);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addToPreferences(Object object, String key, Object fieldObject) {
        SharedPreferences preferences = getSharedPreferences(object);
        if (preferences == null) {
            return;
        }

        if (fieldObject instanceof String) {
            preferences.edit().putString(key, (String) fieldObject).apply();
        } else if (fieldObject instanceof Number) {
            preferences.edit().putFloat(key, ((Number) fieldObject).floatValue()).apply();
        } else if (fieldObject instanceof Boolean) {
            preferences.edit().putBoolean(key, ((Boolean) fieldObject)).apply();
        }
    }

    private static Object getFromPreferences(Object object, String key, Class objectClass) throws IllegalAccessException, InstantiationException {
        SharedPreferences preferences = getSharedPreferences(object);
        if (preferences == null) {
            return null;
        }
        Object fieldObject = objectClass.newInstance();
        if (fieldObject instanceof String) {
            return preferences.getString(key, null);
        } else if (fieldObject instanceof Integer) {
            return (int) preferences.getFloat(key, 0);
        } else if (fieldObject instanceof Double) {
            return (double) preferences.getFloat(key, 0);
        } else if (fieldObject instanceof Long) {
            return (long) preferences.getFloat(key, 0);
        } else if (fieldObject instanceof Float) {
            return preferences.getFloat(key, 0);
        } else if (fieldObject instanceof Boolean) {
            return preferences.getBoolean(key, false);
        } else {
            return null;
        }
    }

    private static SharedPreferences getSharedPreferences(Object object) {
        SharedPreferences preferences;
        if (object instanceof Activity) {
            preferences = ((Activity) object).getSharedPreferences(defaultKey, Context.MODE_PRIVATE);
        } else if (object instanceof android.app.Fragment) {
            preferences = ((android.app.Fragment) object).getActivity().getSharedPreferences(defaultKey, Context.MODE_PRIVATE);
        } else if (object instanceof Fragment) {
            preferences = ((Fragment) object).getActivity().getSharedPreferences(defaultKey, Context.MODE_PRIVATE);
        } else {
            return null;
        }
        return preferences;
    }


}
