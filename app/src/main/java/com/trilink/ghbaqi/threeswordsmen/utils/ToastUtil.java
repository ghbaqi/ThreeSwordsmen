package com.trilink.ghbaqi.threeswordsmen.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ghbaqi on 2017/4/23.
 */

public class ToastUtil {
//    private static ToastUtil mInstance;
    private static Toast toast;

    private ToastUtil() {
    }


//    public static ToastUtil getInstance() {
//        if (mInstance == null) {
//            synchronized (ToastUtil.class) {
//                if (mInstance == null) {
//                    mInstance = new ToastUtil();
//                }
//            }
//        }
//        return mInstance;
//    }

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }

}
