package com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.dao.Ets1BookmarksCountDAO;
import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ets1BookmarksCountService {
    private Ets1BookmarksCountDAO ets1BookmarksCountDAO;

    @Autowired
    public void setEts1BookmarksCountDAO(Ets1BookmarksCountDAO ets1BookmarksCountDAO) {
        this.ets1BookmarksCountDAO = ets1BookmarksCountDAO;
    }

    public List<BookmarkCount> getBookmarksCountDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        return ets1BookmarksCountDAO.getBookmarksCountDuringThePeriod(first, last, limit, offset);
    }

    public List<BookmarkCount> getBookmarksCountByLastFewDays(Integer days, Integer limit, Integer offset) throws DaoException {
        DateTime last = DateTime.now();
        DateTime first = last.minusDays(days);
        return ets1BookmarksCountDAO.getBookmarksCountDuringThePeriod(first, last, limit, offset);
    }

    public List<BookmarkCount> getBookmarksCountByDate(DateTime date, Integer limit, Integer offset) throws DaoException {
        return ets1BookmarksCountDAO.getBookmarksCountDuringThePeriod(date, date, limit, offset);
    }

}
