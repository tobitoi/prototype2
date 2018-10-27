package com.tpm.tobitoi.prototype.internal.views.profile;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.tpm.tobitoi.prototype.R;
import com.tpm.tobitoi.prototype.internal.App;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerFragmentComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.FragmentComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.FragmentModule;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.views.base.BaseFragment;
import com.tpm.tobitoi.prototype.internal.views.dashboard.DashboardFragment;
import com.tpm.tobitoi.prototype.internal.views.dashboard.DashboardPresenter;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import rx.functions.Action1;

/**
 * Created by Tobitoi on 22/10/2018.
 */

public class ProfileFragment  extends BaseFragment implements ProfileView{
    private FragmentComponent mComponent;
    private User mUser;

    @Inject
    RealmManagers mRealmManagers;

    @Inject
    ProfilePresenter mPresenter;

    @Inject
    Commons mCommonUtils;

    @Inject
    Navigators mNavigators;

    @Inject
    Dates mDates;

    @BindView(R.id.images)
    CircleImageView imageView;

    @BindView(R.id.name)
    TextView name;

    @BindString(R.string.connection_error)
    String connectionError;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    protected int getLayoutInflater() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initComponents(final Bundle savedInstanceState) {
        inject();
        onAttach();
        getData();
    }

    @Override
    public void inject() {
        mComponent = DaggerFragmentComponent.builder().applicationComponent(App.getComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
        getComponent().inject(this);
    }

    public FragmentComponent getComponent() {
        return mComponent;
    }

    @Override
    public void onAttach() {
        mPresenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.onDetach();
    }


    @Override
    public void onShowError(final String error) {
        showError(error);
    }

    @Override
    public void onShowForbiddenError(final String error) {
        showForbiddenError(error);
    }

    @Override
    public void onConnectionError() {
        showError(connectionError);
    }

    @Override
    public void onNavigateLoginView() {
        mNavigators.openLoginActivity(getActivity(), true);
    }

    private void showError(final String message) {
        if (!TextUtils.isEmpty(message)) {
            mCommonUtils.showGeneralError(getActivity(), message).show();
        }
    }

    private void showForbiddenError(final String message) {
        if (!TextUtils.isEmpty(message)) {
            mCommonUtils.showGeneralError(getContext(), message).show();
        }
    }

    public void getData(){
        mPresenter.setImageProfile(getContext(),getUser(),imageView);
        mPresenter.setUsername(getUser(), name);
    }

    public User getUser(){
        return mUser;
    }
}
