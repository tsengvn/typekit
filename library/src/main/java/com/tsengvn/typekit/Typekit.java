package com.tsengvn.typekit;
import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2015, Posiba. All rights reserved.
 *
 * @author Hien Ngo
 * @since 5/8/15
 */
public class Typekit {
    public enum Style {
        Normal, Bold, Italic, BoldItalic, Custom1, Custom2, Custom3, Custom4, Custom5, Custom6, Custom7, Custom8, Custom9;
    }

    private static Typekit ourInstance = new Typekit();

    public static Typekit getInstance() {
        return ourInstance;
    }

    private Map<Style, Typeface> mFonts = new HashMap<>();
    private Typekit() {
    }

    public Typeface get(Style style){
        return mFonts.get(style);
    }

    public Typekit addNormal(Typeface typeface){
        mFonts.put(Style.Normal, typeface);
        return this;
    }

    public Typekit addItalic(Typeface typeface){
        mFonts.put(Style.Italic, typeface);
        return this;
    }

    public Typekit addBold(Typeface typeface){
        mFonts.put(Style.Bold, typeface);
        return this;
    }

    public Typekit addBoldItalic(Typeface typeface){
        mFonts.put(Style.BoldItalic, typeface);
        return this;
    }

    public Typekit addCustom1(Typeface typeface){
        mFonts.put(Style.Custom1, typeface);
        return this;
    }

    public Typekit addCustom2(Typeface typeface){
        mFonts.put(Style.Custom2, typeface);
        return this;
    }

    public Typekit addCustom3(Typeface typeface){
        mFonts.put(Style.Custom3, typeface);
        return this;
    }

    public Typekit addCustom4(Typeface typeface){
        mFonts.put(Style.Custom4, typeface);
        return this;
    }

    public Typekit addCustom5(Typeface typeface){
        mFonts.put(Style.Custom5, typeface);
        return this;
    }

    public Typekit addCustom6(Typeface typeface){
        mFonts.put(Style.Custom6, typeface);
        return this;
    }

    public Typekit addCustom7(Typeface typeface){
        mFonts.put(Style.Custom7, typeface);
        return this;
    }

    public Typekit addCustom8(Typeface typeface){
        mFonts.put(Style.Custom8, typeface);
        return this;
    }

    public Typekit addCustom9(Typeface typeface){
        mFonts.put(Style.Custom9, typeface);
        return this;
    }

    public static Typeface createFromAsset(Context context, String path){
        return Typeface.createFromAsset(context.getAssets(), path);
    }

}
