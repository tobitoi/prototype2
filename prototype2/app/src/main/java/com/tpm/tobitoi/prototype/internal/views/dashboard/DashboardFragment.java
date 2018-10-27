package com.tpm.tobitoi.prototype.internal.views.dashboard;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.tpm.tobitoi.prototype.R;
import com.tpm.tobitoi.prototype.internal.App;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerFragmentComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.FragmentComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.FragmentModule;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.views.base.BaseFragment;


import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;

import rx.functions.Action1;

public class DashboardFragment extends BaseFragment implements DashboardView {
	private FragmentComponent mComponent;

	@Inject
	RealmManagers mRealmManagers;

	@Inject
	DashboardPresenter mPresenter;

	@Inject
	Commons mCommonUtils;

	@Inject
	Navigators mNavigators;

	@Inject
	Dates mDates;

	@BindView(R.id.pb_dashboard)
	ProgressBar mProgressBar;

	@BindView(R.id.refreshDashboard)
	SwipeRefreshLayout mSwipeRefreshLayout;

	@BindString(R.string.connection_error)
	String connectionError;

	public static DashboardFragment newInstance() {
		return new DashboardFragment();
	}

	@Override
	protected int getLayoutInflater() {
		return R.layout.fragment_dashboard;
	}

	@Override
	protected void initComponents(final Bundle savedInstanceState) {
		inject();
		onAttach();


		onRefreshLayout();
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
	public void onShowProgressBar() {
		mProgressBar.setVisibility(View.VISIBLE);

	}

	@Override
	public void onHideProgressBar() {
		mProgressBar.setVisibility(View.GONE);
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


    public void onRefreshLayout() {
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {

				mSwipeRefreshLayout.setRefreshing(false);
			}
		});
	}


	private void setSpinnerListner(final Spinner spinner, final Action1<Integer> callApi){
		spinner.setSelection(3);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
				switch (position) {
					case 0: {

//						final DashboardBottomSheet dashboardBottomSheet = DashboardBottomSheet.newInstance();
//						dashboardBottomSheet.show(getFragmentManager(), dashboardBottomSheet.getTag());
						break;
					}
					default: {
						callApi.call(position);
						break;
					}
				}
			}

			@Override
			public void onNothingSelected(final AdapterView<?> parent) {
			}

		});
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
}
