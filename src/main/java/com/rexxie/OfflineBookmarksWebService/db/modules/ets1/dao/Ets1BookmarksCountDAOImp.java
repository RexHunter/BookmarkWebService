package com.rexxie.OfflineBookmarksWebService.db.modules.ets1.dao;

import com.rexxie.OfflineBookmarksWebService.db.modules.exceptions.DaoException;
import com.rexxie.OfflineBookmarksWebService.db.modules.mappers.BookmarkCountRowMapper;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class Ets1BookmarksCountDAOImp implements Ets1BookmarksCountDAO {
    private static String ETS1_DATE_TEMPLATE = "yyyyMMdd";

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

    public List<BookmarkCount> getBookmarksCountDuringThePeriod(DateTime first, DateTime last, Integer limit, Integer offset) throws DaoException {
        String query;
        try {
            query = queryLoader.loadQueryFromResourceFile("sql/ets1/select_bookmarks_ets1_count_during_the_period.sql");
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
        List<BookmarkCount> bookmarks = jdbcTemplate.query(build, new BookmarkCountRowMapper());
        long endTime = System.nanoTime() - startTime;
        return bookmarks;
    }
}
