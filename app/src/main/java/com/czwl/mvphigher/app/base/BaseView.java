package com.czwl.mvphigher.app.base;

/**
 * Date: 2020/4/18
 * Time:11:53
 * author:CZ
 * Describe:View需要绑定一个presenter
 */
public interface BaseView<T> {

 void setPresenter(T presenter);
 void showLoading();
void hideLoading();


}
