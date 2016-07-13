package service;

import model.GankData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:29
 */
public interface GankApi {

    @GET("福利/{num}/{page}")
    Observable<GankData> getDatas(@Path("num") int num, @Path("page") int page);
}
