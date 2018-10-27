package com.tpm.tobitoi.prototype.internal.utils;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.views.home.HomeActivity;
import com.tpm.tobitoi.prototype.internal.views.login.LoginActivity;

import org.parceler.Parcels;

public final class Navigators {

    private static final String TAG = Navigators.class.getSimpleName();

    public void openLoginActivity(final Activity activity, final boolean isNewActivity) {
        try {
            final Intent intent = new Intent(activity, LoginActivity.class);
            if (isNewActivity) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }

            activity.startActivity(intent);
            activity.finish();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void openHomeActivity(final Activity activity, final User user) {
        try {
            final Intent intent = new Intent(activity, HomeActivity.class);
            final Bundle bundle = new Bundle();
            bundle.putParcelable(IConstant.IBundles.USER, Parcels.wrap(user));
            intent.putExtras(bundle);
            activity.startActivity(intent);
            activity.finish();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void openHomeActivity(final Activity activity, final boolean isNewActivity) {
        try {
            final Intent intent = new Intent(activity, HomeActivity.class);
            if (isNewActivity) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }

            activity.startActivity(intent);
            activity.finish();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void openHomeActivity(final Activity activity, final User user, final boolean isNewActivity) {
        try {
            final Intent intent = new Intent(activity, HomeActivity.class);
            final Bundle bundle = new Bundle();
            bundle.putParcelable(IConstant.IBundles.USER, Parcels.wrap(user));
            intent.putExtras(bundle);

            if (isNewActivity) {
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            }

            activity.startActivity(intent);
            activity.finish();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

}