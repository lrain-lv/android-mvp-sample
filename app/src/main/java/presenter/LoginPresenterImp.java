package presenter;

import android.os.Handler;

import view.ILoginView;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:15
 */
public class LoginPresenterImp implements ILoginPresenter {

    private ILoginView mView;

    public LoginPresenterImp(ILoginView view) {
        mView = view;

    }

    @Override
    public void login(final String phone, final String password) {
        mView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("rain".equals(phone) && "123456".equals(password)) {
                    mView.hideProgress();
                    mView.success();
                } else {
                    mView.hideProgress();
                    mView.showError();
                }

            }
        }, 3000);
    }

    @Override
    public void detach() {
        mView = null;
    }

    @Override
    public void clear() {
        mView.clear();
    }
}
