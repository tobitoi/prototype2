package com.tpm.tobitoi.prototype.internal.views.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseDialog extends DialogFragment {
    protected View view;
    protected Unbinder unbinder;

    protected abstract int getLayoutInflater();

    protected abstract void initComponents(final Bundle savedInstanceState);

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initComponents(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutInflater(), container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        if (null != getDialog().getWindow()) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().setCanceledOnTouchOutside(false);
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        view = null;
        super.onDestroyView();
    }
}