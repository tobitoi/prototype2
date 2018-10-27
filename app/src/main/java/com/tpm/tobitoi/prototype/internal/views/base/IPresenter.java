package com.tpm.tobitoi.prototype.internal.views.base;

public interface IPresenter<T extends IView> {
    void onAttach(T view);

    void onDetach();
}