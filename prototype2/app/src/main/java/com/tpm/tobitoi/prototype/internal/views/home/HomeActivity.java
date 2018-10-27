package com.tpm.tobitoi.prototype.internal.views.home;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tpm.tobitoi.prototype.R;
import com.tpm.tobitoi.prototype.internal.App;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.injectors.component.ActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.ActivityModule;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.IConstant;
import com.tpm.tobitoi.prototype.internal.utils.IConstants;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.views.base.BaseActivity;
import com.tpm.tobitoi.prototype.internal.views.dashboard.DashboardFragment;
import com.tpm.tobitoi.prototype.internal.views.profile.ProfileFragment;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class HomeActivity extends BaseActivity implements HomeView {
    private ActivityComponent mComponent;
    private ProgressDialog mProgressDialog;

    @Inject
    HomePresenter mPresenter;

    @Inject
    Commons mCommonUtils;

    @Inject
    Navigators mNavigators;

    @BindView(R.id.toolbar_home)
    Toolbar toolbarHome;

    @BindString(R.string.message_logout_title)
    String messageLogoutTitle;

    @BindString(R.string.message_logout_description)
    String messageLogoutDescription;

    @BindString(R.string.message_pleasewait)
    String messagePleaseWait;

    @BindString(R.string.error_unknown)
    String errorUnknown;

    @BindString(R.string.connection_error)
    String connectionError;

    @BindString(R.string.expired)
    String mExpired;

    MenuItem menuItem;
    int menuItemId;

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void initComponents(final Bundle savedInstanceState) {

        inject();
        onAttach();
        setToolbar();
        onShowDashboard();
        onNavigateMenu();
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
    public void onShowDashboard() {
        final String tag = DashboardFragment.class.getSimpleName();
        final Fragment fragment = DashboardFragment.newInstance();
        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    public void onShowLogoutDialog() {
        mPresenter.initLogoutAlertDialog(this, messageLogoutTitle, messageLogoutDescription).show();
    }

//    @Override
//    public void onDoLogout() {
//        mPresenter.doLogout();
//    }

    @Override
    public void onShowProgressDialog() {
        mProgressDialog = mCommonUtils.getProgressDialog(this);
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(messagePleaseWait);
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
    public void onNavigateMenu() {
        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    @Override
    public void onNavigateLoginView() {
        onDismissProgressDialog();
        mNavigators.openLoginActivity(this, true);
    }


    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_home_top, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }


    private void setToolbar() {
        toolbarHome.setPadding(0, getStatusBarHeight(), 0, 0);
        setSupportActionBar(toolbarHome);

        // Disabled application title on toolbar
        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new DashboardFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.nav_search:
//                            selectedFragment = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_home,
                            selectedFragment).commit();

                    return true;
                }
            };

    private void showError(final String message) {

    }

    private void showForbiddenError(final String message) {
        if (!TextUtils.isEmpty(message)) {
            mCommonUtils.showGeneralError(this, message).show();
        }
    }



}