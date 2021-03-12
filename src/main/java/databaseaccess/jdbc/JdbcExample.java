package databaseaccess.jdbc;

import databaseaccess.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Objects;

public class JdbcExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcExample.class);

    public static void main(String[] args) {
        JdbcExample example = new JdbcExample();
        example.queryWithStatement("Tuan");
        example.queryWithStatement("Tuan' or '1'='1");
        example.queryWithPreparedStatement("Tuan");
        example.queryWithPreparedStatement("Tuan' or '1'='1");

        example.insertBatch();
        example.insertWithTransactionManager();
    }

    private void queryWithStatement(String firstName) {
        String query = "select * from basicjava.staff where firstName = '" + firstName + "'";
        try (Connection con = ConnectionUtil.getConnectionFromDataSource();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            LOGGER.info("{}", stmt);
            ConnectionUtil.parseResultSet(rs).forEach(s -> LOGGER.info("{}", s));
            LOGGER.info("No more record!");
        } catch (Exception e) {
            LOGGER.error("Exception {}", e.getMessage(), e);
        }
    }

    private void queryWithPreparedStatement(String firstName) {
        String query = "select * from basicjava.staff where firstName = ?";
        try (Connection con = ConnectionUtil.getConnectionFromDataSource();
             PreparedStatement ps = createPreparedStatement(con, query, firstName);
             ResultSet rs = ps.executeQuery()) {
            LOGGER.info("{}", ps);
            ConnectionUtil.parseResultSet(rs).forEach(s -> LOGGER.info("{}", s));
            LOGGER.info("No more record!");
        } catch (Exception e) {
            LOGGER.error("Exception {}", e.getMessage(), e);
        }
    }

    private void insertBatch() {
        String query = "insert into basicjava.staff(firstName) values (?)";
        PreparedStatement ps =  null;
        try (Connection con = ConnectionUtil.getConnectionFromDataSource()) {
            ps = con.prepareStatement(query);
            for (int i = 0; i < 5; i++) {
                ps.setString(1, "FirstName" + i);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            LOGGER.error("Exception {}", e.getMessage(), e);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Exception {}", e.getMessage(), e);
            }
        }
    }

    private void insertWithTransactionManager() {
        String query = "insert into basicjava.staff(id, firstName) values (?, ?)";
        PreparedStatement ps =  null;
        Connection con = null;
        Savepoint savepoint = null;
        try {
            con = ConnectionUtil.getConnectionFromDataSource();
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);

            ps.setInt(1, 5);
            ps.setString(2, "ABC");
            ps.execute();

            savepoint = con.setSavepoint("insert ABC save point");

            ps.setInt(1, 6);
            ps.setString(2, "XYZ");
            ps.execute();

            ps.setInt(1, 1);
            ps.setString(2, "MNP");
            ps.execute();

            con.commit();
        } catch (SQLException e) {
            LOGGER.error("SQLException {}", e.getMessage(), e);
            try {
                if (savepoint == null) {
                    Objects.requireNonNull(con).rollback();
                } else {
                    Objects.requireNonNull(con).rollback(savepoint);
                    con.commit();
                }
                LOGGER.info("JDBC Transaction rolled back successfully");
            } catch (SQLException ex) {
                LOGGER.error("SQLException in rollback {}", ex.getMessage(), ex);
            }
        } catch (Exception e) {
            LOGGER.error("Exception {}", e.getMessage(), e);
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Exception {}", e.getMessage(), e);
            }
        }
    }

    private PreparedStatement createPreparedStatement(Connection con, String query, Object... params) throws SQLException {
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, String.valueOf(params[0]));
        return ps;
    }
}
