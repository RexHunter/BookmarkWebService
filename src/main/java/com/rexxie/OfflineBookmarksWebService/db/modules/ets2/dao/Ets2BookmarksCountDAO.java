package com.rexxie.OfflineBookmarksWebService.db.modules.ets2.dao;

import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;

import java.util.List;

public interface Ets2BookmarksCountDAO {
    List<BookmarkCount> getBookmarksCountDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException;
}
