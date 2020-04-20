package com.czwl.mvphigher.contract;

import com.czwl.mvphigher.app.base.BaseModel;
import com.czwl.mvphigher.app.base.BasePresenter;
import com.czwl.mvphigher.app.base.BaseView;
import com.czwl.mvphigher.model.LoginCallBack;
import com.czwl.mvphigher.model.bean.User;

/**
 * Date: 2020/4/19
 * Time:15:50
 * author:CZ
 * Describe:
 */
public interface LoginContract {
    interface View extends BaseView<Presenter> {
        String  getUserName();

        String  getPassWord();

        void clearUserName();

        void clearPassWord();

        void toMainActivity(User user);
        void showError();

    }

    interface Presenter extends BasePresenter {
        //登录行为
        public void login();
        public void clear();
    }

    interface Model extends BaseModel {
        void login(String name, String passWord, LoginCallBack loginCallBack);
    }
}
