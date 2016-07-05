package com.tsengvn.typekit;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.StyleSpan;

/**
 *
 * @author Hien Ngo
 * @since 7/5/16
 */
public class TypekitSpan extends StyleSpan {
    private final Typekit mTypekit;

    public TypekitSpan(int style, Typekit typekit) {
        super(style);
        mTypekit = typekit;
    }

    public TypekitSpan(Parcel src, Typekit typekit) {
        super(src);
        mTypekit = typekit;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        apply(ds, getStyle(), mTypekit);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        apply(paint, getStyle(), mTypekit);
    }

    private static void apply(Paint paint, int style, Typekit typekit) {
        int oldStyle;

        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int want = oldStyle | style;



        Typeface tf = null;

        switch (want) {
            case Typeface.BOLD:
                tf = typekit.get(Typekit.Style.Bold);
                break;
            case Typeface.ITALIC:
                tf = typekit.get(Typekit.Style.Italic);
                break;
            case Typeface.BOLD_ITALIC:
                tf = typekit.get(Typekit.Style.BoldItalic);
                break;
            default:
                tf = null;
                break;
        }

        if (tf == null) {
            if (old == null) {
                tf = Typeface.defaultFromStyle(want);
            } else {
                tf = Typeface.create(old, want);
            }

            int fake = want & ~tf.getStyle();

            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }

            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }
        }

        paint.setTypeface(tf);
    }
}