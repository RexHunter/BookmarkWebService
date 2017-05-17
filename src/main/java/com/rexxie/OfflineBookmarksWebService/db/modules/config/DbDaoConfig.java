package com.rexxie.OfflineBookmarksWebService.db.modules.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DbDaoConfig {

    @Bean
    public DbConfig provideDbConfig() throws DbException {
        return new DbConfig("./config/db.config.json");
    }

    @Bean
    public ConnectionProvider provideConnectionProvider(DbConfig dbConfig) {
        return new ConnectionProvider(dbConfig);
    }

    @Bean("secretaryDataSource")
    public DataSource secretaryDataSource(ConnectionProvider connectionProvider) throws SQLException {
        return connectionProvider.getDataSource("secretary");
    }

    @Bean
    public QueryLoader queryLoader() {
        return new QueryLoader();
    }
}
