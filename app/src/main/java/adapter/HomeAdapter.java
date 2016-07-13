package adapter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.app.android_mvp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import model.GankData;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:42
 */
public class HomeAdapter extends BaseAdapter {

    private List<GankData.ResultsBean> mGankDataList;

    public HomeAdapter(List<GankData.ResultsBean> gankDataList) {
        mGankDataList = gankDataList;
    }

    @Override
    public int getCount() {
        return mGankDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mGankDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomeViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new HomeViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.tvDec);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (HomeViewHolder) convertView.getTag();
        }
        GankData.ResultsBean resultsBean = mGankDataList.get(position);
        Picasso.with(parent.getContext()).load(resultsBean.getUrl()).config(Bitmap.Config.ARGB_8888).into(viewHolder.mImageView);
        viewHolder.mTextView.setText(resultsBean.getDesc());
        return convertView;
    }

    static class HomeViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
    }
}
