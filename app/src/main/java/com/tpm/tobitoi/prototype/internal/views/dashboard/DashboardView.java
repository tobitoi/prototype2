package com.tpm.tobitoi.prototype.internal.views.dashboard;


import com.tpm.tobitoi.prototype.internal.views.base.IView;

public interface DashboardView extends IView {
    void onShowProgressBar();

    void onHideProgressBar();

    void onShowError(String error);

    void onShowForbiddenError(String error);

    void onConnectionError();

    void onNavigateLoginView();

}