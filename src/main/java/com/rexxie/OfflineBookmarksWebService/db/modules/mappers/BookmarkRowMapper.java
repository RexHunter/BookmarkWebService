package com.rexxie.OfflineBookmarksWebService.db.modules.mappers;

import com.rexxie.OfflineBookmarksWebService.db.modules.models.Bookmark;
import com.rexxie.OfflineBookmarksWebService.db.modules.models.LastRunStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookmarkRowMapper implements RowMapper<Bookmark> {

    @Override
    public Bookmark mapRow(ResultSet resultSet, int i) throws SQLException {
        String etlKey = resultSet.getString(Bookmark.ETL_KEY);
        java.sql.Date lastDate = resultSet.getDate(Bookmark.LAST_DATE);
        Integer lastHour = resultSet.getInt(Bookmark.LAST_HOUR);
        Long lastId = resultSet.getLong(Bookmark.LAST_ID);
        LastRunStatus lastRunStatus = LastRunStatus.valueOf(resultSet.getString(Bookmark.LAST_RUN_STATUS).toUpperCase());

        return Bookmark.createBuilder()
                .setEtlKey(etlKey)
                .setLastDate(lastDate)
                .setLastHour(lastHour)
                .setLastId(lastId)
                .setLastRunStatus(lastRunStatus)
                .build();
    }
}
