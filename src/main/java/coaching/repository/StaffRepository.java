package coaching.repository;

import coaching.model.Staff;
import databaseaccess.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Staff repository
 */
public class StaffRepository implements CrudRepository<Staff> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffRepository.class);

    private JdbcTemplate template;

    /**
     * Initialize
     *
     * @param dataSource Data source
     */
    public StaffRepository(DataSource dataSource) {
        if (Objects.isNull(dataSource)) {
            throw new IllegalArgumentException("Datasource cannot be null");
        }
        template = new JdbcTemplate(dataSource);
    }

    /**
     * {@inheritDoc}
     *
     * @param data Data
     */
    @Override
    public int save(Collection<Staff> data) {
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (Staff staff : data) {
            if (saveSingle(staff) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] saveBatch(Collection<Staff> data) {
        if (Objects.isNull(data)) {
            throw new IllegalArgumentException();
        }
        String sql = "insert into staff values (null, ?, ?, ?, ?, ?, ?)";
        List<Staff> staffList = new ArrayList<>(data);
        try {
            return template.batchUpdate(sql, new BatchPreparedStatementSetter(){
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    Staff staff = staffList.get(i);
                    ps.setString(1, staff.getFirstName());
                    ps.setString(2, staff.getMiddleName());
                    ps.setString(3, staff.getLastName());
                    ps.setTimestamp(4, Timestamp.valueOf(staff.getDob()));
                    ps.setString(5, staff.getPhone());
                    ps.setString(6, staff.getAddress());
                }

                @Override
                public int getBatchSize() {
                    return data.size();
                }
            });
        } catch (Exception e) {
            LOGGER.error("failed to savebatch", e);
            return new int[]{};
        }
    }

    @Override
    public int saveSingle(Staff staff) {
        if (Objects.isNull(staff)) {
            throw new IllegalArgumentException();
        }
        String sql = "insert into staff values (null, ?, ?, ?, ?, ?, ?)";
        try {
            return template.update(sql,
                    staff.getFirstName(),
                    staff.getMiddleName(),
                    staff.getLastName(),
                    staff.getDob(),
                    staff.getPhone(),
                    staff.getAddress());
        } catch (Exception e) {
            LOGGER.error("Failed to save staff {}", staff.getFirstName(), e);
            return -1;
        }
    }

    @Override
    public int[] saveBatch(Collection<Staff> data) {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Staff> findAll() {
        String sql = "select * from staff";
        return template.query(sql, ConnectionUtil.staffMapper);
    }
}
