package com.rexxie.OfflineBookmarksWebService.db.modules.ets2.services;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets2.dao.Ets2BookmarksCountDAO;
import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ets2BookmarksCountService {
    private Ets2BookmarksCountDAO ets2BookmarksCountDAO;

    @Autowired
    public void setEts2BookmarksCountDAO(Ets2BookmarksCountDAO ets2BookmarksCountDAO) {
        this.ets2BookmarksCountDAO = ets2BookmarksCountDAO;
    }

    public List<BookmarkCount> getBookmarksCountDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        return ets2BookmarksCountDAO.getBookmarksCountDuringThePeriod(first, last, limit, offset);
    }

    public List<BookmarkCount> getBookmarksCountByLastFewDays(Integer days, Integer limit, Integer offset) throws DaoException {
        DateTime last = DateTime.now();
        DateTime first = last.minusDays(days);
        return ets2BookmarksCountDAO.getBookmarksCountDuringThePeriod(first, last, limit, offset);
    }

    public List<BookmarkCount> getBookmarksCountByDate(DateTime date, Integer limit, Integer offset) throws DaoException {
        return ets2BookmarksCountDAO.getBookmarksCountDuringThePeriod(date, date, limit, offset);
    }
}
