package com.tpm.tobitoi.prototype.internal.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.hdodenhof.circleimageview.CircleImageView;

public final class Images {

    public void loadImage(final Context context,
                          final String url,
                          final int resourceId,
                          final ImageView imageView) {
        setMemoryCategory(context);
        Glide.with(context)
             .load(url)
             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
             .placeholder(resourceId)
             .error(resourceId)
             .dontAnimate()
             .into(imageView);
    }

    public void loadImageCircle(final Context context,
                                final String url,
                                final int resourceId,
                                final CircleImageView circleImageView) {
        setMemoryCategory(context);
        Glide.with(context)
             .load(url)
             .centerCrop()
             .diskCacheStrategy(DiskCacheStrategy.SOURCE)
             .placeholder(resourceId).error(resourceId)
             .dontAnimate()
             .into(circleImageView);
    }

    private void setMemoryCategory(final Context context) {
        Glide.get(context).setMemoryCategory(MemoryCategory.HIGH);
    }
}