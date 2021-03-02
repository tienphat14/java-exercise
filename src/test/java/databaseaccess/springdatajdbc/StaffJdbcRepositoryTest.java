package databaseaccess.springdatajdbc;

import databaseaccess.DatabaseConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatabaseConfiguration.class)
public class StaffJdbcRepositoryTest {

    @Autowired
    private StaffJdbcRepository staffJdbcRepository;

    @Test
    public void testAll() {
        Staff staff = createStaff();
        staff = staffJdbcRepository.save(staff);
        List<Staff> staffList = staffJdbcRepository.findByFirstName("TestStaff");
        Assert.assertEquals(1, staffList.size());
        Assert.assertEquals("TestStaff", staff.getFirstName());

        staff.setFirstName("UpdateTestStaff");
        staff = staffJdbcRepository.save(staff);
        staffList = staffJdbcRepository.findByFirstName("UpdateTestStaff");
        Assert.assertEquals(1, staffList.size());
        Assert.assertEquals("UpdateTestStaff", staff.getFirstName());

        staffJdbcRepository.delete(staff);
        Assert.assertTrue(staffJdbcRepository.findByFirstName("UpdateTestStaff").isEmpty());
    }

    private Staff createStaff() {
        Staff staff = new Staff();
        staff.setFirstName("TestStaff");
        staff.setDob(LocalDateTime.now());
        return staff;
    }
}