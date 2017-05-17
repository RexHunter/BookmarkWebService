package com.rexxie.OfflineBookmarksWebService.db.modules.models;


import java.util.List;

public class EtsBookmarkList {
    private List<Bookmark> ets1Bookmarks;
    private List<Bookmark> ets2Bookmarks;

    private EtsBookmarkList() {
    }

    public List<Bookmark> getEts1Bookmarks() {
        return ets1Bookmarks;
    }

    public List<Bookmark> getEts2Bookmarks() {
        return ets2Bookmarks;
    }

    public static Builder createBuilder() {
        return new EtsBookmarkList().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setEts1Bookmarks(List<Bookmark> ets1Bookmarks) {
            EtsBookmarkList.this.ets1Bookmarks = ets1Bookmarks;
            return this;
        }

        public Builder setEts2Bookmarks(List<Bookmark> ets2Bookmarks) {
            EtsBookmarkList.this.ets2Bookmarks = ets2Bookmarks;
            return this;
        }

        public EtsBookmarkList build() {
            return EtsBookmarkList.this;
        }
    }
}
