package view;

import java.util.List;

import model.GankData;

/**
 * User: LIU YAN
 * Date: 2016-07-13  10:37
 */
public interface IHomeView extends IBaseView {
    void setList(List<GankData.ResultsBean> list);
}
