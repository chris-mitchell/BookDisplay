package com.possible.myapplication.ui.bindings;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewBindings {

    @BindingAdapter(value = {"imageUrl", "placeHolderDrawable"})
    public static void setBackground(ImageView view, String imageUrl, Drawable placeHolderDrawable) {
        Picasso.get()
                .load(getPicassoSafeImageUrl(imageUrl))
                .placeholder(placeHolderDrawable)
                .fit()
                .into(view);
    }

    @Nullable
    private static String getPicassoSafeImageUrl(@Nullable String imageUrl) {
        return TextUtils.isEmpty(imageUrl) ? null : imageUrl;
    }

}
