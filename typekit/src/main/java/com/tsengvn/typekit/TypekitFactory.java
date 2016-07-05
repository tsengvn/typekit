package com.tsengvn.typekit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 *
 * @author Hien Ngo
 * @since 5/8/15
 */
public class TypekitFactory {
    public TypekitFactory() {
    }

    public View onViewCreated(View view, String name, View parent, Context context, AttributeSet attrs) {
        if (view == null) {
            return null;
        }

        if (view instanceof TextView) {
            TextView textView = (TextView) view;

            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Typekit);
            int fontValue = (array != null) ? array.getInt(R.styleable.Typekit_font, -1) : -1;
            if (fontValue != -1) {
                switch (fontValue) {
                    case 1:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom1));
                        break;
                    case 2:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom2));
                        break;
                    case 3:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom3));
                        break;
                    case 4:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom4));
                        break;
                    case 5:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom5));
                        break;
                    case 6:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom6));
                        break;
                    case 7:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom7));
                        break;
                    case 8:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom8));
                        break;
                    case 9:
                        textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Custom9));
                        break;
                    case 10:
//                        textView.setTypeface(Typekit.getInstance().get());
                        break;
                }
            } else {
                Typeface typeface = textView.getTypeface();
                if (typeface == null || (!typeface.isBold() && !typeface.isItalic())) {
                    textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Normal));
                } else if (typeface.isBold() && typeface.isItalic()) {
                    textView.setTypeface(Typekit.getInstance().get(Typekit.Style.BoldItalic));
                } else if (typeface.isBold()) {
                    textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Bold));
                } else {
                    textView.setTypeface(Typekit.getInstance().get(Typekit.Style.Italic));
                }
                if (textView.getText() instanceof Spanned) {

//                    Spanned spanned = (Spanned) textView.getText();
//                    StyleSpan[] spans = spanned.getSpans(0, spanned.length(), StyleSpan.class);
//                    if (spans != null && spans.length > 0) {
//                        SpannableStringBuilder builder = new SpannableStringBuilder(textView.getText());
//                        builder.setSpan();
//                        for (StyleSpan styleSpan : spans) {
//                            int start = spanned.getSpanStart(styleSpan);
//                            int end = spanned.getSpanEnd(styleSpan);
//                            if (styleSpan.getStyle() == Typeface.BOLD) {
//
//                            } else if (styleSpan.getStyle() == Typeface.BOLD_ITALIC) {
//
//                            } else if (styleSpan.getStyle() == Typeface.Italic) {
//
//                            }
//                        }
//                    }


                }
            }


        }

        return view;
    }

    public View onViewCreated(View view, Context context, AttributeSet attrs) {
        //TODO: implement
        return view;
    }
}
