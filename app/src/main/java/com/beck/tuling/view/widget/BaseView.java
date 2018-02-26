package com.beck.tuling.view.widget;

/**
 * Created by beck on 2018/1/22.
 * BaseView
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    T getPresenter();
}
