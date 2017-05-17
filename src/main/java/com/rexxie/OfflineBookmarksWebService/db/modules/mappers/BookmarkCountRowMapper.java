package com.rexxie.OfflineBookmarksWebService.db.modules.mappers;

import com.rexxie.OfflineBookmarksWebService.db.modules.models.BookmarkCount;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.EtsSource;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookmarkCountRowMapper implements RowMapper<BookmarkCount> {

    @Override
    public BookmarkCount mapRow(ResultSet resultSet, int i) throws SQLException {
        String date = resultSet.getString(BookmarkCount.DATE);
        Integer count = resultSet.getInt(BookmarkCount.COUNT);
        EtsSource etsSource = EtsSource.valueOf(resultSet.getString(BookmarkCount.ETS_SOURCE).toUpperCase());

        return BookmarkCount.createBuilder()
                .setDate(date)
                .setCount(count)
                .setEtsSource(etsSource)
                .build();
    }
}
