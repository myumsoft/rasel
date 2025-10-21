package com.myumsoft.mylibrary;

import android.content.Context;
import android.content.Intent;

public class AppShare {

    Context context;
    String message;
    public AppShare (Context context,String messgeg){

        // এই লাইনটা ভুল ছিল: context = context.this; ❌
        // সঠিকভাবে 'this' ব্যবহার করতে হবে:
        this.context = context;
        this.message = message;

        shareApp();

    }

    private void shareApp() {
        String appPackageName = context.getPackageName();
        String playStoreLink = "https://play.google.com/store/apps/details?id=" + appPackageName;

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message + " " + playStoreLink);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, "Share app via");
        context.startActivity(shareIntent);
    }


}
