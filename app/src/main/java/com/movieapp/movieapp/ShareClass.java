package com.movieapp.movieapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.movieapp.movieapp.models.UsersModel;

import androidx.core.text.HtmlCompat;

public class ShareClass {
    private static ShareClass shareClass;
    private Snackbar snackbar;
    private static UsersModel usersModel;

    public static ShareClass getInstance() {
        if (shareClass == null)
            shareClass = new ShareClass();
        return shareClass;
    }

    public void showSnackbar(Context context, View view, String message, boolean isIconDone) {
        snackbar = Snackbar.make(view, HtmlCompat.fromHtml("<font color=\"#ffffff\">" + message + "</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)
                , Snackbar.LENGTH_SHORT);
        View view1 = snackbar.getView();
        TextView textView = (TextView) view1.findViewById(R.id.snackbar_text);
        if (isIconDone)
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.ic_check), null, null, null);
        else
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.ic_error), null, null, null);

        textView.setCompoundDrawablePadding(5);
        snackbar.show();

    }

    public void showLog(String className, String method, String message) {
        Log.e("log " + className, method + " : " + message);
    }

    public static UsersModel getUsersModel() {
        return usersModel;
    }

    public static void setUsersModel(UsersModel usersModel) {
        ShareClass.usersModel = usersModel;
    }

}
