package com.czwl.mvphigher.model;

import com.czwl.mvphigher.model.bean.User;

/**
 * Date: 2020/4/17
 * Time:16:53
 * author:CZ
 * Describe:用于登录的回调接口
 */
public interface LoginCallBack {
    public void loginSuccess(User user);
    public void loginFailed();

}
