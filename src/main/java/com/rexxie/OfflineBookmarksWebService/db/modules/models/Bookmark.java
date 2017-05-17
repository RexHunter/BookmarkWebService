package com.rexxie.OfflineBookmarksWebService.db.modules.models;

import java.sql.Date;

public class Bookmark {
    public static String TABLE = "etl_bookmark_new_workers";

    public static String ETL_KEY = "etl_key";
    public static String LAST_DATE = "last_date";
    public static String LAST_HOUR = "last_hour";
    public static String LAST_ID = "last_id";
    public static String LAST_RUN_STATUS = "last_run_status";

    private String etlKey;
    private Date lastDate;
    private Integer lastHour;
    private Long lastId;
    private LastRunStatus lastRunStatus;

    private Bookmark() {
    }

    public String getEtlKey() {
        return etlKey;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public Integer getLastHour() {
        return lastHour;
    }

    public Long getLastId() {
        return lastId;
    }

    public LastRunStatus getLastRunStatus() {
        return lastRunStatus;
    }

    public static Builder createBuilder() {
        return new Bookmark().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setEtlKey(String etlKey) {
            Bookmark.this.etlKey = etlKey;
            return this;
        }

        public Builder setLastDate(Date lastDate) {
            Bookmark.this.lastDate = lastDate;
            return this;
        }

        public Builder setLastHour(Integer lastHour) {
            Bookmark.this.lastHour = lastHour;
            return this;
        }

        public Builder setLastId(Long lastId) {
            Bookmark.this.lastId = lastId;
            return this;
        }

        public Builder setLastRunStatus(LastRunStatus lastRunStatus) {
            Bookmark.this.lastRunStatus = lastRunStatus;
            return this;
        }

        public Bookmark build() {
            return Bookmark.this;
        }
    }
}
