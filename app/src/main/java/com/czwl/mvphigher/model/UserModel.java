package com.czwl.mvphigher.model;

import com.czwl.mvphigher.contract.LoginContract;
import com.czwl.mvphigher.model.bean.User;

/**
 * Date: 2020/4/17
 * Time:16:45
 * author:CZ
 * Describe:Model实现类
 */
public class UserModel implements LoginContract.Model {

   //模拟用户登录的行为 在Model中具体实现实现
    @Override
    public void login(final String name, final String passWord, final LoginCallBack loginCallBack) {
        //耗时操作 在子线程中运行
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               if("czm".equals(name)&&"123".equals(passWord)){
                   User user = new User();
                   user.setPassWord(passWord);
                   user.setUserName(name);
                   loginCallBack.loginSuccess(user);
               }
               else loginCallBack.loginFailed();
            }
        }.start();
    }
}
