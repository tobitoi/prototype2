package com.tpm.tobitoi.prototype.internal.views.dashboard;

import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.views.base.IPresenter;

import javax.inject.Inject;
import javax.inject.Named;
import rx.functions.Action0;
import rx.functions.Action1;

public class DashboardPresenter implements IPresenter<DashboardView> {
    private DashboardView mView;

    @Inject
    @Named("core")
    IApi mApi;

    @Inject
    RealmManagers mRealmManagers;

    @Inject
    Commons mCommonUtils;

    @Inject
    Dates mDates;

    @Inject
    DashboardPresenter() {
    }

    @Override
    public void onAttach(final DashboardView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;

    }

    public DashboardView getView() {
        return mView;
    }

    private Action0 getOnShowProgressBar() {
        return new Action0() {
            @Override
            public void call() {
                getView().onShowProgressBar();
            }
        };
    }

    private Action0 getOnHideProgressBar() {
        return new Action0() {
            @Override
            public void call() {
                getView().onHideProgressBar();
            }
        };
    }

    private Action1<String> getOnShowError() {
        return new Action1<String>() {
            @Override
            public void call(final String s) {
                getView().onShowError(s);
            }
        };
    }

    private Action0 getOnConnectionError(){
        return new Action0() {
            @Override
            public void call() {
                getView().onConnectionError();
            }
        };
    }

    private Action1<String> getOnForbiddenError(){
        return new Action1<String>() {
            @Override
            public void call(String s) {
                getView().onShowForbiddenError(s);
            }
        };
    }

    private Action0 getOnError() {
        return new Action0() {
            @Override
            public void call() {
                mRealmManagers.deleteAll();
                getView().onNavigateLoginView();
            }
        };
    }

}