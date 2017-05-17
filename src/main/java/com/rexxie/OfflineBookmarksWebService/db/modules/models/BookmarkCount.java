package com.rexxie.OfflineBookmarksWebService.db.modules.models;

public class BookmarkCount {

    public static String DATE = "date";
    public static String COUNT = "count";
    public static String ETS_SOURCE = "ets_source";

    private String date;
    private Integer count;
    private EtsSource etsSource;

    private BookmarkCount() {
    }

    public String getDate() {
        return date;
    }

    public Integer getCount() {
        return count;
    }

    public EtsSource getEtsSource() {
        return etsSource;
    }

    public static Builder createBuilder() {
        return new BookmarkCount().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setDate(String date) {
            BookmarkCount.this.date = date;
            return this;
        }

        public Builder setCount(Integer count) {
            BookmarkCount.this.count = count;
            return this;
        }

        public Builder setEtsSource(EtsSource etsSource) {
            BookmarkCount.this.etsSource = etsSource;
            return this;
        }

        public BookmarkCount build() {
            return BookmarkCount.this;
        }
    }
}
