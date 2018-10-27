package com.tpm.tobitoi.prototype.internal.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;

public final class Commons {
    /**
     * @param view    View container
     * @param message Error message
     * @return Snackbar with LENGTH_LONG
     */
    public Snackbar showGeneralError(final ViewGroup view, final String message) {
        return Snackbar.make(view, message, Snackbar.LENGTH_LONG);
    }

    /**
     * @param message Error message
     * @return Toast with LENGTH_LONG
     */
    public Toast showGeneralError(final Context context, final String message) {
        return Toast.makeText(context, message, Toast.LENGTH_LONG);
    }

    /**
     * @param context Application context
     * @return ProgressDialog
     */
    public ProgressDialog getProgressDialog(final Context context) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(final DialogInterface dialog, final int keyCode, final KeyEvent event) {
                return true;
            }
        });

        return progressDialog;
    }

    /**
     * @param context Application context
     * @param pixels  Size in pixel
     * @return DensityPixel from pixel
     */
    public int getDpFromPixel(final Context context, final float pixels) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

    /**
     * @param context Application context
     */
    public void setLocaleConfigurations(final Context context, final String language) {
        if (!TextUtils.isEmpty(language) && !Locale.getDefault().getLanguage().equalsIgnoreCase(language)) {
            final Locale locale = new Locale("en");
            updateLocaleConfigurations(context, locale);
        }
    }

    /**
     * @param context Application context
     * @param locale  Updated locale
     */
    public void updateLocaleConfigurations(final Context context, final Locale locale) {
        final Resources resources = context.getApplicationContext().getResources();
        final Configuration configuration = resources.getConfiguration();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale);
        } else {
            //noinspection deprecation
            configuration.locale = locale;
        }

        // Set default locale
        Locale.setDefault(locale);

        //noinspection deprecation
        resources.updateConfiguration(configuration, displayMetrics);
    }
}