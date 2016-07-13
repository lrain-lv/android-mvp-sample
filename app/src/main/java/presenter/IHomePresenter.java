package presenter;

import service.GankApi;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:50
 */
public interface IHomePresenter {
    void showData(GankApi api);

    void detach();
}
