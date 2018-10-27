package com.tpm.tobitoi.prototype.internal.views.login;


import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.views.base.IView;

public interface LoginView extends IView {
    void onValidationFailed();

    void onDoLogin(String email, String password);

    void onShowProgressDialog();

    void onDismissProgressDialog();

    void onShowError(String error);

    void onConnectionError();

    void onNavigateView(User user);
}