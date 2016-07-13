package com.android.app.android_mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import presenter.ILoginPresenter;
import presenter.LoginPresenterImp;
import view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Bind(R.id.etPhone)
    EditText mEtPhone;
    @Bind(R.id.etPwd)
    EditText mEtPwd;
    @Bind(R.id.login)
    Button mLogin;
    @Bind(R.id.clear)
    Button mClear;

    private ILoginPresenter mPresenter;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenterImp(this);
    }

    @Override
    public void showProgress() {
        mDialog = ProgressDialog.show(LoginActivity.this, "", "", false);
        mDialog.setContentView(R.layout.progress);
        mDialog.setCancelable(false);
    }

    @Override
    public void hideProgress() {
        dismiss();
    }

    private void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(LoginActivity.this, "手机号或密码输入错误，请重新输入！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void clear() {
        mEtPhone.setText("");
        mEtPwd.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismiss();
        ButterKnife.unbind(this);
        mPresenter.detach();
    }

    @OnClick({R.id.login, R.id.clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                String phone = mEtPhone.getText().toString().trim();
                String pwd = mEtPwd.getText().toString().trim();
                mPresenter.login(phone, pwd);
                break;
            case R.id.clear:
                mPresenter.clear();
                break;
        }
    }
}
