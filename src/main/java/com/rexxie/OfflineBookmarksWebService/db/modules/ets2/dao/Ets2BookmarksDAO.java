package com.rexxie.OfflineBookmarksWebService.db.modules.ets2.dao;

import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;

import java.util.List;

public interface Ets2BookmarksDAO {
    List<Bookmark> getBookmarksDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException;
    void deleteBookmarksDuringThePeriod(DateTime first, DateTime last) throws DaoException;
}
