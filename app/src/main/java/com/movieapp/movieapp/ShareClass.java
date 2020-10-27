package com.movieapp.movieapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import androidx.core.text.HtmlCompat;

public class ShareClass {
    private Snackbar snackbar;
    private Context context;

    public ShareClass(Context context) {
        this.context = context;
    }

    public ShareClass() {
    }

    public void showSnackbar(View view, String message, boolean isIconDone) {
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

    public void showLog(String className, String method, String message){
        Log.e("log " + className, method + " : " + message);
    }
}
