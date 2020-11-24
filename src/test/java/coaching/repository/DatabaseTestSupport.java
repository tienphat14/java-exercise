package coaching.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.reporters.Files;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import static org.junit.Assert.fail;

public class DatabaseTestSupport {

    // For database accessibility
    protected static DataSource dataSource;

    @BeforeClass
    public static void init() {
        // Data source setup
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:" + UUID.randomUUID().toString());   // In-memory database
        config.setDriverClassName("org.h2.Driver");                         // H2 driver
        dataSource = new HikariDataSource(config);

        // Create staff table
        try (final Connection connection = dataSource.getConnection();
             final Statement statement = connection.createStatement()) {

            final File staffTable = new File(DatabaseTestSupport.class.getResource("/staff-table.sql").toURI());
            statement.execute(Files.readFile(staffTable));

        } catch (Exception ex) {
            fail();
        }
    }

    // Truncate all data in staff table to avoid from side-impact
    @Before
    public void truncateData() {
        try (final Connection connection = dataSource.getConnection();
             final Statement statement = connection.createStatement()) {

            statement.execute("truncate table staff;");

        } catch (SQLException ex) {
            fail();
        }
    }
}
