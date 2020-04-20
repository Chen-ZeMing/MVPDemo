package com.czwl.mvphigher.presenter;

import android.os.Handler;

import com.czwl.mvphigher.contract.LoginContract;
import com.czwl.mvphigher.model.LoginCallBack;
import com.czwl.mvphigher.model.UserModel;
import com.czwl.mvphigher.model.bean.User;

/**
 * Date: 2020/4/17
 * Time:17:12
 * author:CZ
 * Describe:
 *
 */
public class UserLoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;
    private Handler mHandler=new Handler();
    private UserModel userModel;

    public UserLoginPresenter(LoginContract.View View) {
        this.mView = View;
        userModel=new UserModel();

    }

    @Override
    public void login() {
        mView.showLoading();
        userModel.login(mView.getUserName(), mView.getPassWord(), new LoginCallBack() {
            @Override
            public void loginSuccess(User user) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        User user=new User();
                        user.setUserName(mView.getUserName());
                        user.setPassWord(mView.getPassWord());

                        mView.toMainActivity(user);
                        mView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
              mHandler.post(new Runnable() {
                  @Override
                  public void run() {
                      mView.showError();
                      mView.hideLoading();
                  }
              });
            }
        });
    }
    public void clear(){
        mView.clearPassWord();
        mView.clearUserName();
    }



}
