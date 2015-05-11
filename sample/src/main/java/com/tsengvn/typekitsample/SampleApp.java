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
                .addNormal(Typekit.createFromAsset(this, "Wedding Chardonnay.ttf"))
                .addBold(Typekit.createFromAsset(this, "Double_Bubble_shadow.otf"))
                .addItalic(Typekit.createFromAsset(this, "Double_Bubble_shadow_italic.otf"))
                .addBoldItalic(Typekit.createFromAsset(this, "Double_Bubble_shadow_italic.otf"))
                .addCustom1(Typekit.createFromAsset(this, "soopafre.ttf"))
                .addCustom2(Typekit.createFromAsset(this, "Break It Down.ttf"));
    }
}
