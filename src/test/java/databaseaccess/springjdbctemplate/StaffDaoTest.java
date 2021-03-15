package databaseaccess.springjdbctemplate;

import coaching.model.Staff;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class StaffDaoTest {

    private StaffDao staffDao;

    {
        try {
            staffDao = new StaffDaoJdbcTemplate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAll() {
        Staff staff = createStaff();
        Assert.assertEquals(1, staffDao.save(staff));

        List<Staff> staffList = staffDao.findByFirstName("TestStaff");
        Staff savedStaff = staffList.get(0);
        Assert.assertEquals(1, staffList.size());
        Assert.assertEquals("TestStaff", savedStaff.getFirstName());

        staff = savedStaff;
        staff.setFirstName("UpdateTestStaff");
        Assert.assertEquals(1, staffDao.update(staff));

        staffList = staffDao.findByFirstName("UpdateTestStaff");
        savedStaff = staffList.get(0);
        Assert.assertEquals(1, staffList.size());
        Assert.assertEquals("UpdateTestStaff", savedStaff.getFirstName());

        Assert.assertEquals(1, staffDao.delete(staff.getId()));
        Assert.assertTrue(staffDao.findByFirstName("UpdateTestStaff").isEmpty());
    }

    private Staff createStaff() {
        Staff staff = new Staff();
        staff.setFirstName("TestStaff");
        staff.setDob(LocalDate.now());
        return staff;
    }
}