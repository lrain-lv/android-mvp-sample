package presenter;

import android.os.Handler;

import java.util.List;

import model.GankData;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import service.GankApi;
import view.IHomeView;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:51
 */
public class HomePresenter implements IHomePresenter {

    private IHomeView mIHomeView;

    public HomePresenter(IHomeView IHomeView) {
        mIHomeView = IHomeView;
    }

    @Override
    public void showData(final GankApi api) {
        mIHomeView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                api.getDatas(20, 1)
                        .filter(new Func1<GankData, Boolean>() {
                            @Override
                            public Boolean call(GankData gankData) {
                                return gankData != null;
                            }
                        })
                        
                        .map(new Func1<GankData, List<GankData.ResultsBean>>() {
                            @Override
                            public List<GankData.ResultsBean> call(GankData gankData) {
                                return gankData.getResults();
                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<List<GankData.ResultsBean>>() {
                            @Override
                            public void onCompleted() {
                                mIHomeView.hideProgress();
                                mIHomeView.success();
                            }

                            @Override
                            public void onError(Throwable e) {
                                mIHomeView.hideProgress();
                                mIHomeView.showError();
                            }

                            @Override
                            public void onNext(List<GankData.ResultsBean> resultsBeanList) {
                                mIHomeView.setList(resultsBeanList);
                            }
                        });

            }
        }, 2000);

    }

    @Override
    public void detach() {
        mIHomeView = null;
    }
}
