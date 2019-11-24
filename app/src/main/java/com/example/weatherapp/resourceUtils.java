package com.example.weatherapp;

import android.app.Activity;

import java.util.ArrayList;

public class resourceUtils {
    static String[] getLocalizedStringArray(Activity activity, String[] arrayList) {
        ArrayList<String> resultAL = new ArrayList<String>();
        for (String s: arrayList){
            int resId = activity.getResources().getIdentifier(s, "string", activity.getPackageName());
            resultAL.add(activity.getResources().getString(resId));
        }
        String[] result = resultAL.toArray(new String[resultAL.size()]);
        return result;
    }
}
