package com.tpm.tobitoi.prototype.internal.views.home;

import com.tpm.tobitoi.prototype.internal.views.base.IView;

public interface HomeView extends IView {

    void onShowLogoutDialog();

    void onShowDashboard();

//    void onDoLogout();

    void onShowProgressDialog();

    void onDismissProgressDialog();

    void onNavigateMenu();

    void onNavigateLoginView();

}