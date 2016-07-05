package com.tsengvn.typekit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
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
            applyFontForTextView(context, attrs, textView);

        } else if (view instanceof android.support.v7.widget.Toolbar) {
            Toolbar toolbar = (Toolbar) view;
            for (int i=0 ; i<toolbar.getChildCount() ; i++) {
                View child = toolbar.getChildAt(i);
                if (child instanceof TextView) {
                    applyFontForTextView(context, attrs, (TextView) child);
                }
            }
        }

        return view;
    }

    public View onViewCreated(View view, Context context, AttributeSet attrs) {
        //TODO: implement
        return view;
    }

    private void applyFontForTextView(Context context, AttributeSet attrs, TextView textView) {
        if (textView.getTag(R.id.typekit) != null) return;

        Typekit typekit = Typekit.getInstance();

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Typekit);
        String fontKey = (array != null) ? array.getString(R.styleable.Typekit_font) : null;

        if (!TextUtils.isEmpty(fontKey)) {
            textView.setTypeface(typekit.get(fontKey));
        } else {
            Typeface typeface = textView.getTypeface();
            if (typeface == null || (!typeface.isBold() && !typeface.isItalic())) {
                textView.setTypeface(typekit.get(Typekit.Style.Normal));
            } else if (typeface.isBold() && typeface.isItalic()) {
                textView.setTypeface(typekit.get(Typekit.Style.BoldItalic));
            } else if (typeface.isBold()) {
                textView.setTypeface(typekit.get(Typekit.Style.Bold));
            } else {
                textView.setTypeface(typekit.get(Typekit.Style.Italic));
            }
            if (textView.getText() instanceof Spanned) {
                Spanned spanned = (Spanned) textView.getText();
                StyleSpan[] spans = spanned.getSpans(0, spanned.length(), StyleSpan.class);

                SpannableStringBuilder builder = new SpannableStringBuilder(textView.getText());
                builder.setSpan(new TypekitSpan(Typeface.NORMAL, typekit), 0, spanned.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

                if (spans != null && spans.length > 0) {
                    for (StyleSpan styleSpan : spans) {
                        int start = spanned.getSpanStart(styleSpan);
                        int end = spanned.getSpanEnd(styleSpan);
                        if (styleSpan.getStyle() == Typeface.BOLD) {
                            builder.setSpan(new TypekitSpan(Typeface.BOLD, typekit), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                        } else if (styleSpan.getStyle() == Typeface.BOLD_ITALIC) {
                            builder.setSpan(new TypekitSpan(Typeface.BOLD_ITALIC, typekit), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                        } else if (styleSpan.getStyle() == Typeface.ITALIC) {
                            builder.setSpan(new TypekitSpan(Typeface.ITALIC, typekit), start, end, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
                        }
                    }
                }
                textView.setText(builder);
            }
        }

        if (array != null) {
            array.recycle();
        }

        textView.setTag(R.id.typekit, true);
    }
}
