package com.czwl.mvphigher.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.czwl.mvphigher.contract.LoginContract;
import com.czwl.mvphigher.model.bean.User;
import com.czwl.mvphigher.presenter.UserLoginPresenter;
import com.czwl.mvphigher.R;

/**
 * Date: 2020/4/17
 * Time:17:22
 * author:CZ
 * Describe:view的实现类 里面的逻辑 由presenter来实现
 */
public class UserLoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginContract.Presenter mPresenter;

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void showLoading() {
        mProg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProg.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mPresenter = new UserLoginPresenter(this);//View里面有了Presenter的引用
        initView();
    }

    private EditText userName, passWord;
    private Button login, clear;
    private ProgressBar mProg;

    private void initView() {
        userName = findViewById(R.id.user_name);
        passWord = findViewById(R.id.pass_word);
        login = findViewById(R.id.login);
        clear = findViewById(R.id.clear);
        mProg = findViewById(R.id.progress);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassWord() {
        return passWord.getText().toString();
    }

    @Override
    public void clearUserName() {
        userName.setText("");
    }

    @Override
    public void clearPassWord() {
        passWord.setText("");
    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登录成功:" + user.getUserName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "登录失败>_<", Toast.LENGTH_SHORT).show();
    }
}
