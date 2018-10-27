package com.tpm.tobitoi.prototype.internal.views.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;

import com.tpm.tobitoi.prototype.R;
import com.tpm.tobitoi.prototype.internal.App;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.injectors.component.ActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.ActivityModule;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Keyboards;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.views.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {
    private ActivityComponent mComponent;
    private ProgressDialog mProgressDialog;

    @Inject
    LoginPresenter mPresenter;

    @Inject
    RealmManagers mRealmManagers;

    @Inject
    Commons mCommonUtils;

    @Inject
    Keyboards mKeyboards;

    @Inject
    Navigators mNavigators;

    @BindView(R.id.cl_login)
    CoordinatorLayout clLogin;

    @BindView(R.id.tiet_login_email)
    TextInputEditText tietLoginEmail;

    @BindView(R.id.tiet_login_password)
    TextInputEditText tietLoginPassword;

    @BindString(R.string.message_authenticate)
    String messsageAuthenticate;

    @BindString(R.string.error_unknown)
    String errorUnknown;

    @BindString(R.string.validation_login)
    String validationLogin;

    @BindString(R.string.expired)
    String mExpired;

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initComponents(final Bundle savedInstanceState) {
        inject();
        onAttach();
    }

    @Override
    public void inject() {
        mComponent = DaggerActivityComponent.builder().applicationComponent(App.getComponent())
                                                      .activityModule(new ActivityModule(this))
                                                      .build();
        getComponent().inject(this);
    }

    @Override
    public void onAttach() {
        mPresenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        mPresenter.onDetach();
    }

    @Override
    public void onValidationFailed() {
        showError(this, validationLogin);
    }

    @Override
    public void onDoLogin(final String email, final String password) {
        mPresenter.doLogin(email, password);
    }

    @Override
    public void onShowProgressDialog() {
        mProgressDialog = mCommonUtils.getProgressDialog(this);
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(messsageAuthenticate);
            mProgressDialog.show();
        }
    }

    @Override
    public void onDismissProgressDialog() {
        if (this.isFinishing()) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (this.isDestroyed()) {
                return;
            }
        }

        if ((null != mProgressDialog) && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onShowError(final String error) {
        showError(this, error);
    }

    @Override
    public void onConnectionError() {
        showError(this, errorUnknown);
    }

    @Override
    public void onNavigateView(final User user) {
        onDismissProgressDialog();
        mNavigators.openHomeActivity(this, user);
    }

    @Override
    protected void onDestroy() {
        onDismissProgressDialog();
        onDetach();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        onDismissProgressDialog();
    }

//    @OnClick(R.id.tv_login_forgetpassword)
//    public void onTvLoginForgetPasswordClick() {
//        mNavigators.openForgetPasswordActivity(this);
//    }
//    @OnClick(R.id.tv_login_forgetpassword)
//    public void onForgotPassword(){
//        Uri uri = Uri.parse("http://ppe-jurnal.ip6udzpkpp.ap-southeast-1.elasticbeanstalk.com/en/users/password/new");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        startActivity(intent);
//
//    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClick() {
        final String username = tietLoginEmail.getText().toString();
        final String password = tietLoginPassword.getText().toString();

        mPresenter.validateLogin(username, password);
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }

    private void showError(final Context context, final String message) {
        if (!TextUtils.isEmpty(message)) {
            mCommonUtils.showGeneralError(clLogin, message).show();
        }

        tietLoginEmail.requestFocus();
        mKeyboards.toggle(context);
    }
}