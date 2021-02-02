package databaseaccess.springjdbctemplate;

import coaching.model.Staff;

import java.util.List;

public interface StaffDao {
    int save(Staff staff);
    List<Staff> findByFirstName(String firstName);
    int update(Staff staff);
    int delete(int id);
}
