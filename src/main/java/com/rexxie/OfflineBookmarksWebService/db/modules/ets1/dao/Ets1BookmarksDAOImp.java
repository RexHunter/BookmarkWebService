package com.rexxie.OfflineBookmarksWebService.db.modules.ets1.dao;

import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.mappers.BookmarkRowMapper;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

@Component
public class Ets1BookmarksDAOImp implements Ets1BookmarksDAO {
    private static String DATABASE = "secretary";

    private static String ETS1_DATE_TEMPLATE = "yyyyMMdd";

    private Connection connection;
    private JdbcTemplate jdbcTemplate;
    private QueryLoader queryLoader;

    @Autowired
    public void setQueryLoader(QueryLoader queryLoader) {
        this.queryLoader = queryLoader;
    }

    @Autowired
    public void setJdbcTemplate(@Qualifier("secretaryDataSource") DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Bookmark> getBookmarksDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        String query;
        try {
            query = queryLoader.loadQueryFromResourceFile("sql/ets1/select_bookmarks_ets1_during_the_period.sql");
        } catch (QueryFileDoesNotExistsException e) {
            throw new DaoException(e.getMessage());
        }

        QueryEditor qe = new QueryEditor(query);
        qe.setString(":first", first.toString(ETS1_DATE_TEMPLATE));
        qe.setString(":last", last.toString(ETS1_DATE_TEMPLATE));
        qe.setInt(":offset", offset);
        qe.setInt(":limit", limit);

        String build = qe.build();

        long startTime = System.nanoTime();
        List<Bookmark> bookmarks = jdbcTemplate.query(build, new BookmarkRowMapper());
        long endTime = System.nanoTime() - startTime;
        return bookmarks;
    }

    @Override
    public void deleteBookmarksDuringThePeriod(DateTime first, DateTime last) throws DaoException {
        String query;
        try {
            query = queryLoader.loadQueryFromResourceFile("sql/ets1/delete_bookmarks_ets1_during_the_period.sql");
        } catch (QueryFileDoesNotExistsException e) {
            throw new DaoException(e.getMessage());
        }

        QueryEditor qe = new QueryEditor(query);
        qe.setString(":first", first.toString(ETS1_DATE_TEMPLATE));
        qe.setString(":last", last.toString(ETS1_DATE_TEMPLATE));
        String build = qe.build();

        jdbcTemplate.execute(build);
    }
}
