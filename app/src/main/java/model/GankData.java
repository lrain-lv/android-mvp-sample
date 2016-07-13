package model;

import java.util.List;

/**
 * User: LIU YAN
 * Date: 2016-07-13 10:30
 */
public class GankData {

    /**
     * error : false
     * results : [{"_id":"57846575421aa90de83c1b6a","createdAt":"2016-07-12T11:35:17.922Z","desc":"7.12","publishedAt":"2016-07-12T12:00:59.523Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f5qyx2wpohj20xc190tr7.jpg","used":true,"who":"代码家"},{"_id":"578319de421aa90dea11e9ac","createdAt":"2016-07-11T12:00:30.299Z","desc":"佐佐木希","publishedAt":"2016-07-11T12:27:19.231Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1f5pu0w0r56j20m80rsjuy.jpg","used":true,"who":"代码家"},{"_id":"577f245a421aa9202555b93b","createdAt":"2016-07-08T11:56:10.441Z","desc":"7.8","publishedAt":"2016-07-08T11:58:56.336Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1f5md1e68p9j20fk0ncgo0.jpg","used":true,"who":"daimajia"},{"_id":"577dce02421aa94944970eeb","createdAt":"2016-07-07T11:35:30.946Z","desc":"三吉彩花","publishedAt":"2016-07-07T11:58:33.45Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f5l6tgzc2sj20zk0nqgq0.jpg","used":true,"who":"daimajia"},{"_id":"577c7f77421aa90191bc2a67","createdAt":"2016-07-06T11:48:07.778Z","desc":"堀未央奈","publishedAt":"2016-07-06T12:16:53.218Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg","used":true,"who":"代码家"},{"_id":"577b277a421aa9019c09f2e1","createdAt":"2016-07-05T11:20:26.261Z","desc":"7.5","publishedAt":"2016-07-05T11:36:50.61Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1f5iv5babirj20zk0nptcn.jpg","used":true,"who":"代码家"},{"_id":"5779d9c4421aa964a66e5893","createdAt":"2016-07-04T11:36:36.327Z","desc":"7.4","publishedAt":"2016-07-04T12:21:38.653Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1f5hpzuy3r7j20np0zkgpd.jpg","used":true,"who":"代码家"},{"_id":"5775db69421aa97f5186e455","createdAt":"2016-07-01T10:54:33.55Z","desc":"本田翼","publishedAt":"2016-07-01T11:06:20.244Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f5e7x5vlfyj20dw0euaax.jpg","used":true,"who":"代码家"},{"_id":"5774911c421aa97a566cc153","createdAt":"2016-06-30T11:25:16.598Z","desc":"6.30","publishedAt":"2016-06-30T11:40:10.110Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f5d36vpqyuj20zk0qo7fc.jpg","used":true,"who":"代码家"},{"_id":"577348a5421aa95e542023e8","createdAt":"2016-06-29T12:03:49.269Z","desc":"6.29","publishedAt":"2016-06-29T12:08:28.744Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1f5byokn81tj20dw0hiwfe.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    /**
     * _id : 57846575421aa90de83c1b6a
     * createdAt : 2016-07-12T11:35:17.922Z
     * desc : 7.12
     * publishedAt : 2016-07-12T12:00:59.523Z
     * source : chrome
     * type : 福利
     * url : http://ww2.sinaimg.cn/large/610dc034jw1f5qyx2wpohj20xc190tr7.jpg
     * used : true
     * who : 代码家
     */

    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
