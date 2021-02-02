package databaseaccess.springjdbctemplate;

import coaching.model.Staff;
import databaseaccess.ConnectionUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;

public class StaffDaoJdbcTemplate implements StaffDao {

    private JdbcTemplate template;

    public StaffDaoJdbcTemplate() throws IOException {
        template = new JdbcTemplate();
        template.setDataSource(ConnectionUtil.getMysqlDatasource());
    }

    @Override
    public int save(Staff staff){
        String sql = "insert into basicjava.staff values (null, ?, ?, ?, ?, ?, ?)";
        return template.update(sql,
                staff.getFirstName(),
                staff.getMiddleName(),
                staff.getLastName(),
                staff.getDob(),
                staff.getPhone(),
                staff.getAddress());
    }

    @Override
    public List<Staff> findByFirstName(String firstName) {
        String sql = "select * from basicjava.staff where firstName = ?";
        return template.query(sql, ConnectionUtil.staffMapper, firstName);
    }

    @Override
    public int update(Staff staff) {
        String sql = "update basicjava.staff set " +
                "firstName = ?, " +
                "middleName = ?, " +
                "lastName = ?, " +
                "dob = ?, " +
                "phone = ?, " +
                "address = ? " +
                "where id = ?";
        return template.update(sql,
                staff.getFirstName(),
                staff.getMiddleName(),
                staff.getLastName(),
                staff.getDob(),
                staff.getPhone(),
                staff.getAddress(),
                staff.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "delete from basicjava.staff where id = ?";
        return template.update(sql, id);
    }
}
