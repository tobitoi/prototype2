package com.tpm.tobitoi.prototype.internal.views.profile;

import com.tpm.tobitoi.prototype.internal.views.base.IView;

/**
 * Created by Tobitoi on 22/10/2018.
 */

public interface ProfileView extends IView {

    void onShowError(String error);

    void onShowForbiddenError(String error);

    void onConnectionError();

    void onNavigateLoginView();

}
