package coaching.repository;

import coaching.model.Staff;
import databaseaccess.ConnectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        template = new JdbcTemplate();
        template.setDataSource(dataSource);
    }

    /**
     * {@inheritDoc}
     *
     * @param data Data
     */
    @Override
    public void save(Collection<Staff> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        } else {
            String sql = "insert into staff (id, firstName, middleName, lastName, dob, gender, phone, address) values (?, ?, ?, ?, ?, ?, ?, ?)";
            for (Staff s : data) {
                template.update(sql,
                        s.getId(),
                        s.getFirstName(),
                        s.getMiddleName(),
                        s.getLastName(),
                        s.getDob(),
                        1,
                        s.getPhone(),
                        s.getAddress());
            }
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int[] saveBatch(Collection<Staff> data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        } else {
 //           try {
                String sql = "insert into staff (id, firstName, middleName, lastName, dob, gender, phone, address) values (?, ?, ?, ?, ?, ?, ?, ?)";
                List<Staff> listStaff = new ArrayList<>(data);
                return template.batchUpdate(sql, new BatchPreparedStatementSetter() {

                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        Staff s = listStaff.get(i);
                        ps.setInt(1, s.getId());
                        ps.setString(2, s.getFirstName());
                        ps.setString(3, s.getMiddleName());
                        ps.setString(4, s.getLastName());
                        ps.setDate(5, Date.valueOf(s.getDob().toLocalDate()));
                        ps.setInt(6, 1);
                        ps.setString(7, s.getPhone());
                        ps.setString(8, s.getAddress());
                    }

                    @Override
                    public int getBatchSize() {
                        return data.size();
                    }
                });

//            } catch (DataIntegrityViolationException e) {
//                LOGGER.info(e.getMessage());
//            }
//            return new int[0];
        }
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Staff> findAll() {
        return template.query("Select * from staff", ConnectionUtil.staffMapper);
    }
}
