package com.tsengvn.typekitsample;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Copyright (c) 2015, Posiba. All rights reserved.
 *
 * @author Hien Ngo
 * @since 5/11/15
 */
public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "soopafre.ttf"))
                .addBold(Typekit.createFromAsset(this, "Double_Bubble_shadow.otf"))
                .addItalic(Typekit.createFromAsset(this, "Double_Bubble_shadow_italic.otf"))
                .addBoldItalic(Typekit.createFromAsset(this, "Break It Down.ttf"))
                .addCustom1(Typekit.createFromAsset(this, "Wedding Chardonnay.ttf"))
                .addCustom2(Typekit.createFromAsset(this, "Break It Down.ttf"))
                .add("disney", Typekit.createFromAsset(this, "waltographUI.ttf"));
    }
}
