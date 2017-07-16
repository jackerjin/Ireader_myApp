package com.example.tarena.ireader_myapp.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tarena on 2017/6/8.
 */

public class BookRank implements Serializable {

    /**
     * error_code : 0
     * reason : Success!
     * result : {"GetRankTypeRsp":{"RankList":{"Rank":[{"rankTypeID":"1","rankName":"点击排行"},{"rankTypeID":"2","rankName":"搜索排行"},{"rankTypeID":"3","rankName":"收藏排行"},{"rankTypeID":"4","rankName":"人气排行"}]},"RankTimeList":{"RankTime":[{"rankTimeID":"1","rankTimeName":"日排行"},{"rankTimeID":"2","rankTimeName":"周排行"},{"rankTimeID":"3","rankTimeName":"月排行"},{"rankTimeID":"4","rankTimeName":"总排行"}]},"ContentTypeList":{"ContentType":[{"contentTypeID":"1","contentType":"图书"},{"contentTypeID":"2","contentType":"杂志"},{"contentTypeID":"3","contentType":"漫画"}]}}}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * GetRankTypeRsp : {"RankList":{"Rank":[{"rankTypeID":"1","rankName":"点击排行"},{"rankTypeID":"2","rankName":"搜索排行"},{"rankTypeID":"3","rankName":"收藏排行"},{"rankTypeID":"4","rankName":"人气排行"}]},"RankTimeList":{"RankTime":[{"rankTimeID":"1","rankTimeName":"日排行"},{"rankTimeID":"2","rankTimeName":"周排行"},{"rankTimeID":"3","rankTimeName":"月排行"},{"rankTimeID":"4","rankTimeName":"总排行"}]},"ContentTypeList":{"ContentType":[{"contentTypeID":"1","contentType":"图书"},{"contentTypeID":"2","contentType":"杂志"},{"contentTypeID":"3","contentType":"漫画"}]}}
         */

        private GetRankTypeRspBean GetRankTypeRsp;

        public GetRankTypeRspBean getGetRankTypeRsp() {
            return GetRankTypeRsp;
        }

        public void setGetRankTypeRsp(GetRankTypeRspBean GetRankTypeRsp) {
            this.GetRankTypeRsp = GetRankTypeRsp;
        }

        public static class GetRankTypeRspBean {
            /**
             * RankList : {"Rank":[{"rankTypeID":"1","rankName":"点击排行"},{"rankTypeID":"2","rankName":"搜索排行"},{"rankTypeID":"3","rankName":"收藏排行"},{"rankTypeID":"4","rankName":"人气排行"}]}
             * RankTimeList : {"RankTime":[{"rankTimeID":"1","rankTimeName":"日排行"},{"rankTimeID":"2","rankTimeName":"周排行"},{"rankTimeID":"3","rankTimeName":"月排行"},{"rankTimeID":"4","rankTimeName":"总排行"}]}
             * ContentTypeList : {"ContentType":[{"contentTypeID":"1","contentType":"图书"},{"contentTypeID":"2","contentType":"杂志"},{"contentTypeID":"3","contentType":"漫画"}]}
             */

            private RankListBean RankList;
            private RankTimeListBean RankTimeList;
            private ContentTypeListBean ContentTypeList;

            public RankListBean getRankList() {
                return RankList;
            }

            public void setRankList(RankListBean RankList) {
                this.RankList = RankList;
            }

            public RankTimeListBean getRankTimeList() {
                return RankTimeList;
            }

            public void setRankTimeList(RankTimeListBean RankTimeList) {
                this.RankTimeList = RankTimeList;
            }

            public ContentTypeListBean getContentTypeList() {
                return ContentTypeList;
            }

            public void setContentTypeList(ContentTypeListBean ContentTypeList) {
                this.ContentTypeList = ContentTypeList;
            }

            public static class RankListBean {
                private List<RankBean> Rank;

                public List<RankBean> getRank() {
                    return Rank;
                }

                public void setRank(List<RankBean> Rank) {
                    this.Rank = Rank;
                }

                public static class RankBean {
                    /**
                     * rankTypeID : 1
                     * rankName : 点击排行
                     */

                    private String rankTypeID;
                    private String rankName;

                    public String getRankTypeID() {
                        return rankTypeID;
                    }

                    public void setRankTypeID(String rankTypeID) {
                        this.rankTypeID = rankTypeID;
                    }

                    public String getRankName() {
                        return rankName;
                    }

                    public void setRankName(String rankName) {
                        this.rankName = rankName;
                    }
                }
            }

            public static class RankTimeListBean {
                private List<RankTimeBean> RankTime;

                public List<RankTimeBean> getRankTime() {
                    return RankTime;
                }

                public void setRankTime(List<RankTimeBean> RankTime) {
                    this.RankTime = RankTime;
                }

                public static class RankTimeBean {
                    /**
                     * rankTimeID : 1
                     * rankTimeName : 日排行
                     */

                    private String rankTimeID;
                    private String rankTimeName;

                    public String getRankTimeID() {
                        return rankTimeID;
                    }

                    public void setRankTimeID(String rankTimeID) {
                        this.rankTimeID = rankTimeID;
                    }

                    public String getRankTimeName() {
                        return rankTimeName;
                    }

                    public void setRankTimeName(String rankTimeName) {
                        this.rankTimeName = rankTimeName;
                    }
                }
            }

            public static class ContentTypeListBean {
                private List<ContentTypeBean> ContentType;

                public List<ContentTypeBean> getContentType() {
                    return ContentType;
                }

                public void setContentType(List<ContentTypeBean> ContentType) {
                    this.ContentType = ContentType;
                }

                public static class ContentTypeBean {
                    /**
                     * contentTypeID : 1
                     * contentType : 图书
                     */

                    private String contentTypeID;
                    private String contentType;

                    public String getContentTypeID() {
                        return contentTypeID;
                    }

                    public void setContentTypeID(String contentTypeID) {
                        this.contentTypeID = contentTypeID;
                    }

                    public String getContentType() {
                        return contentType;
                    }

                    public void setContentType(String contentType) {
                        this.contentType = contentType;
                    }
                }
            }
        }
    }
}
