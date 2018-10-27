package com.tpm.tobitoi.prototype.internal.views.home;

import android.content.Context;
import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;
import com.tpm.tobitoi.prototype.R;

import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.utils.Reactives;
import com.tpm.tobitoi.prototype.internal.views.base.BasePresenter;
import com.tpm.tobitoi.prototype.internal.views.base.IPresenter;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscription;


public class HomePresenter extends BasePresenter implements IPresenter<HomeView> {
    private HomeView mView;
    private Subscription mSubscription;

    @Inject
    @Named("core")
    IApi mApi;

    @Inject
    Reactives mReactives;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void onAttach(final HomeView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
        mReactives.setSafeUnsubscribe(mSubscription);
    }


    public AlertDialog initLogoutAlertDialog(final Context context, final String title, final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AppTheme_Dialog);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                dialog.dismiss();

            }
        });
        builder.setNegativeButton(R.string.button_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, final int which) {
                dialog.dismiss();
//                getView().onShowDashboard();
            }
        });

        final AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

    public HomeView getView() {
        return mView;
    }

}