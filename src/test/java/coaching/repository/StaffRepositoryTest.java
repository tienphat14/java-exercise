package coaching.repository;

import coaching.model.Staff;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StaffRepositoryTest extends DatabaseTestSupport {

    @Test(expected = IllegalArgumentException.class)
    public void whenSave_NullData_ThenReject() {
        new StaffRepository(dataSource).save(null);
    }

    @Test
    public void whenSave_MultipleStaffs_ThenSave() {
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
        final Staff staffA = RepositoryTestUtils.createMockStaff();
        final Staff staffB = RepositoryTestUtils.createMockStaff();

        // Execute
        repository.save(Arrays.asList(staffA, staffB));
        List<Staff> staffList = new ArrayList<>(repository.findAll());

        // Assertion
        assertEquals(2, staffList.size());
        assertEquals(1L, (long) staffList.get(0).getId());
        assertEquals(2L, (long) staffList.get(1).getId());
    }

    @Test
    public void saveBatch_exceptionOccurs_shouldRollBack() {
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
        final Staff staffD = RepositoryTestUtils.createMockStaff();
        final Staff staffE = RepositoryTestUtils.createMockStaff();
        final Staff staffF = RepositoryTestUtils.createMockStaff();
        staffE.setPhone("Long phone number");

        repository.saveBatch(Arrays.asList(staffD, staffE, staffF));
        List<Staff> staffList = new ArrayList<>(repository.findAll());

        assertTrue(staffList.isEmpty());
    }
}
