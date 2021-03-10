package databaseaccess;

import coaching.model.Staff;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import databaseaccess.jdbc.JdbcExample;
import org.springframework.jdbc.core.RowMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class ConnectionUtil {

    private static final String DB_FILE = "db.properties";

    public static final RowMapper<Staff> staffMapper = (rs, rowNum) -> {
        Staff staff = new Staff();
        staff.setId(rs.getInt("id"));
        staff.setFirstName(rs.getString("firstName"));
        staff.setMiddleName(rs.getString("middleName"));
        staff.setLastName(rs.getString("lastName"));
        staff.setDob(rs.getTimestamp("dob").toLocalDateTime());
        staff.setPhone(rs.getString("phone"));
        staff.setAddress(rs.getString("address"));
        return staff;
    };

    public static Connection getConnectionFromDriverManager() throws IOException, ClassNotFoundException, SQLException {
        try (Reader reader = new FileReader(Objects.requireNonNull(ConnectionUtil.class.getClassLoader().getResource(DB_FILE)).getFile())) {
            Properties properties = new Properties();
            properties.load(reader);
            Class.forName(properties.getProperty("driverClassName"));
            return DriverManager.getConnection(
                    properties.getProperty("jdbcUrl"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        }
    }

    public static Connection getConnectionFromDataSource() throws IOException, SQLException {
        return getMysqlDatasource().getConnection();
    }

    public static Connection getConnectionFromConnectionPool() throws IOException, SQLException {
        HikariConfig config = new HikariConfig();
        config.setDataSource(getMysqlDatasource());
        HikariDataSource hikariDataSource = new HikariDataSource(config);
        return hikariDataSource.getConnection();
    }

    public static MysqlDataSource getMysqlDatasource() throws IOException {
        try (Reader reader = new FileReader(Objects.requireNonNull(JdbcExample.class.getClassLoader().getResource(DB_FILE)).getFile())) {
            Properties properties = new Properties();
            properties.load(reader);

            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(properties.getProperty("jdbcUrl"));
            dataSource.setUser(properties.getProperty("username"));
            dataSource.setPassword(properties.getProperty("password"));

            dataSource.setLogger("com.mysql.jdbc.log.Slf4JLogger");
            dataSource.setProfileSQL(true);
            dataSource.setRewriteBatchedStatements(true);

            return dataSource;
        }
    }

    public static List<Staff> parseResultSet(ResultSet rs) throws SQLException {
        List<Staff> staffList = new ArrayList<>();
        while(rs.next()){
            staffList.add(staffMapper.mapRow(rs, rs.getRow()));
        }
        return staffList;
    }
}
