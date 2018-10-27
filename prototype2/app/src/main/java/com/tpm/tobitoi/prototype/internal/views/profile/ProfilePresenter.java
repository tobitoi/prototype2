package com.tpm.tobitoi.prototype.internal.views.profile;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.tpm.tobitoi.prototype.R;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.utils.Images;
import com.tpm.tobitoi.prototype.internal.views.base.IPresenter;
import com.tpm.tobitoi.prototype.internal.views.dashboard.DashboardView;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by Tobitoi on 22/10/2018.
 */

public class ProfilePresenter implements IPresenter<ProfileView> {

    private ProfileView mView;

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
    Images images;

    @Inject
    ProfilePresenter() {
    }

    @Override
    public void onAttach(final ProfileView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;

    }

    public ProfileView getView() {
        return mView;
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

    public void setImageProfile(final Context context, final User user, final CircleImageView circleImageView){
        try{
            final UserData data = mRealmManagers.getUser();
            String image;
            if(data != null){
                image = data.getAvatar();
            }else {
                image = user.getAvatar();
            }

            images.loadImageCircle(context,image, R.mipmap.ic_default_user,circleImageView);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setUsername(final User user, final TextView textView){
        try{
            final UserData data = mRealmManagers.getUser();
            String name = "name cannot found";
            if(data != null){
                name = data.getName();
            }else {
                name = user.getUsername();
            }

            textView.setText(name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
