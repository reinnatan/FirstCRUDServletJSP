package connectiondb;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

//https://www.baeldung.com/hikaricp
public class DataSource {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc_url");
        config.setUsername("database_username");
        config.setPassword("database_password");
        config.addDataSourceProperty("cachePrepStmt","true");
        config.addDataSourceProperty("prepStmtCacheSize","250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
