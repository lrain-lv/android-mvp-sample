package presenter;

/**
 * User: LIU YAN
 * Date: 2016-07-13  10:09
 */
public interface ILoginPresenter {
    void login(String phone,String password);
    void detach();
    void clear();
}
