package com.rexxie.OfflineBookmarksWebService.db.modules.ets2.services;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets2.dao.Ets2BookmarksDAO;
import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ets2BookmarksService {
    private Ets2BookmarksDAO ets2BookmarksDAO;

    @Autowired
    public void setEts2BookmarksDAO(Ets2BookmarksDAO ets2BookmarksDAO) {
        this.ets2BookmarksDAO = ets2BookmarksDAO;
    }

    public List<Bookmark> getBookmarksDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        return ets2BookmarksDAO.getBookmarksDuringThePeriod(first, last, limit, offset);
    }

    public List<Bookmark> getBookmarksByLastFewDays(Integer days, Integer limit, Integer offset) throws DaoException {
        DateTime last = DateTime.now();
        DateTime first = last.minusDays(days);
        return ets2BookmarksDAO.getBookmarksDuringThePeriod(first, last, limit, offset);
    }

    public List<Bookmark> getBookmarksByDate(DateTime date, Integer limit, Integer offset) throws DaoException {
        return ets2BookmarksDAO.getBookmarksDuringThePeriod(date, date, limit, offset);
    }

}
