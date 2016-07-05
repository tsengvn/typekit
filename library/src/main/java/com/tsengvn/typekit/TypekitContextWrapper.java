package com.tsengvn.typekit;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

/**
 *
 * @author Hien Ngo
 * @since 5/8/15
 */
public class TypekitContextWrapper extends ContextWrapper {
    private TypekitLayoutInflater mInflater;

    public TypekitContextWrapper(Context base) {
        super(base);
    }

    public static ContextWrapper wrap(Context base) {
        return new TypekitContextWrapper(base);
    }

    @Override
    public Object getSystemService(String name) {
        if (LAYOUT_INFLATER_SERVICE.equals(name)) {
            if (mInflater == null) {
                mInflater = new TypekitLayoutInflater(LayoutInflater.from(getBaseContext()), this, false);
            }
            return mInflater;
        }
        return super.getSystemService(name);
    }
}
