package com.android.app.android_mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.HomeAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import model.GankData;
import presenter.HomePresenter;
import presenter.IHomePresenter;
import service.GankRetrofit;
import view.IHomeView;

public class MainActivity extends AppCompatActivity implements IHomeView {

    @Bind(R.id.listview)
    ListView mListview;

    private List<GankData.ResultsBean> mResultsBeen = new ArrayList<>();
    private HomeAdapter mHomeAdapter;

    private IHomePresenter mPresenter;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new HomePresenter(this);
        mHomeAdapter = new HomeAdapter(mResultsBeen);
        mListview.setAdapter(mHomeAdapter);
        mPresenter.showData(GankRetrofit.getGankApi());
    }

    @Override
    public void showProgress() {
        mDialog = ProgressDialog.show(MainActivity.this, "", "", false);
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
        Toast.makeText(MainActivity.this, "加载失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        mHomeAdapter.notifyDataSetChanged();
    }

    @Override
    public void setList(List<GankData.ResultsBean> list) {
        if (list != null) {
            mResultsBeen.addAll(list);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismiss();
        ButterKnife.unbind(this);
        mPresenter.detach();
    }
}
