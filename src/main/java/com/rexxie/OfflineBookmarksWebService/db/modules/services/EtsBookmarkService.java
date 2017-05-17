package com.rexxie.OfflineBookmarksWebService.db.modules.services;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services.Ets1BookmarksService;
import com.rexxie.OfflineBookmarksWebService.db.modules.ets2.services.Ets2BookmarksService;
import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.EtsBookmarkList;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtsBookmarkService {
    private Ets1BookmarksService ets1BookmarksService;
    private Ets2BookmarksService ets2BookmarksService;

    @Autowired
    public void setEts2BookmarksService(Ets2BookmarksService ets2BookmarksService) {
        this.ets2BookmarksService = ets2BookmarksService;
    }

    @Autowired
    public void setEts1BookmarksService(Ets1BookmarksService ets1BookmarksService) {
        this.ets1BookmarksService = ets1BookmarksService;
    }

    public EtsBookmarkList getBookmarksDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        List<Bookmark> ets1bookmarks = ets1BookmarksService.getBookmarksDuringThePeriod(first, last, limit, offset);
        List<Bookmark> ets2bookmarks = ets2BookmarksService.getBookmarksDuringThePeriod(first, last, limit, offset);

        return EtsBookmarkList.createBuilder()
                .setEts1Bookmarks(ets1bookmarks)
                .setEts2Bookmarks(ets2bookmarks)
                .build();
    }

    public EtsBookmarkList getBookmarksByLastFewDays(Integer days, Integer limit, Integer offset) throws DaoException {
        DateTime last = DateTime.now();
        DateTime first = last.minusDays(days);

        List<Bookmark> ets1bookmarks = ets1BookmarksService.getBookmarksDuringThePeriod(first, last, limit, offset);
        List<Bookmark> ets2bookmarks = ets2BookmarksService.getBookmarksDuringThePeriod(first, last, limit, offset);

        return EtsBookmarkList.createBuilder()
                .setEts1Bookmarks(ets1bookmarks)
                .setEts2Bookmarks(ets2bookmarks)
                .build();

    }

    public EtsBookmarkList getBookmarksByDate(DateTime date, Integer limit, Integer offset) throws DaoException {
        List<Bookmark> ets1bookmarks = ets1BookmarksService.getBookmarksDuringThePeriod(date, date, limit, offset);
        List<Bookmark> ets2bookmarks = ets2BookmarksService.getBookmarksDuringThePeriod(date, date, limit, offset);

        return EtsBookmarkList.createBuilder()
                .setEts1Bookmarks(ets1bookmarks)
                .setEts2Bookmarks(ets2bookmarks)
                .build();
    }


}
