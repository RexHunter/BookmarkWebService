package com.rexxie.OfflineBookmarksWebService.db.modules.ets1.services;

import com.rexxie.OfflineBookmarksWebService.db.modules.ets1.dao.Ets1BookmarksDAO;
import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ets1BookmarksService {
    private Ets1BookmarksDAO ets1BookmarksDAO;

    @Autowired
    public void setEts1BookmarksDAO(Ets1BookmarksDAO ets1BookmarksDAO) {
        this.ets1BookmarksDAO = ets1BookmarksDAO;
    }

    public List<Bookmark> getBookmarksDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        return ets1BookmarksDAO.getBookmarksDuringThePeriod(first, last, limit, offset);
    }

    public List<Bookmark> getBookmarksByLastFewDays(Integer days, Integer limit, Integer offset) throws DaoException {
        DateTime last = DateTime.now();
        DateTime first = last.minusDays(days);
        return ets1BookmarksDAO.getBookmarksDuringThePeriod(first, last, limit, offset);
    }

    public List<Bookmark> getBookmarksByDate(DateTime date, Integer limit, Integer offset) throws DaoException {
        return ets1BookmarksDAO.getBookmarksDuringThePeriod(date, date, limit, offset);
    }

    public void deleteBookmarksDuringThePeriod(DateTime first, DateTime last) throws DaoException {
        ets1BookmarksDAO.deleteBookmarksDuringThePeriod(first, last);
    }

    public void deleteBookmarksDuringThePeriod(DateTime date) throws DaoException {
        ets1BookmarksDAO.deleteBookmarksDuringThePeriod(date, date);
    }
}
