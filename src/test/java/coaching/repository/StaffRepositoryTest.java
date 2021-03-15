package coaching.repository;

import coaching.model.Staff;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StaffRepositoryTest extends DatabaseTestSupport {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Test(expected = IllegalArgumentException.class)
    public void whenSave_NullData_ThenReject() throws IllegalArgumentException {
        new StaffRepository(dataSource).save(null);
    }

    @Test
    public void whenSave_MultipleStaffs_ThenSave() throws IllegalArgumentException {
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
        final Staff staffA = RepositoryTestUtils.createMockStaff(1, "John", "R", "Biden", LocalDateTime.parse("1965-12-03 00:00",formatter),
                                                                "092392555", "21st Jump Street");
        final Staff staffB = RepositoryTestUtils.createMockStaff(2, "Donald", "C", "Trump",  LocalDateTime.parse("1971-04-11 00:00",formatter),
                                                                "023222111", "Somewhere else");

        // Execute
        repository.save(Arrays.asList(staffA, staffB));

        // Assertion
        assertEquals(1L, (long) staffA.getId());
        assertEquals(2L, (long) staffB.getId());

    }

    @Test
    public void saveBatch_exceptionOccurs_shouldRollBack() {
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
        final Staff staffD = RepositoryTestUtils.createMockStaff(1, "John", "R", "Biden", LocalDateTime.parse("1965-12-03 00:00",formatter),
                                                                "092392555", "21st Jump Street");
        final Staff staffE = RepositoryTestUtils.createMockStaff(2, "Donald", "C", "Trump",  LocalDateTime.parse("1971-04-11 00:00",formatter),
                                                                "023222111", "Somewhere else");
        final Staff staffF = RepositoryTestUtils.createMockStaff(3, "Donald", "C", "Trump",  LocalDateTime.parse("1971-04-11 00:00",formatter),
                                                                "023222111", "Somewhere else");
        staffE.setPhone("Long phone number");

        repository.saveBatch(Arrays.asList(staffD, staffE, staffF));
        List<Staff> staffList = new ArrayList<>(repository.findAll());

        assertTrue(staffList.isEmpty());
    }
}
