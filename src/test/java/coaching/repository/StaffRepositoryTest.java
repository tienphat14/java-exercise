package coaching.repository;

import coaching.model.Staff;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StaffRepositoryTest extends DatabaseTestSupport {

    @Test(expected = IllegalArgumentException.class)
    public void whenSave_NullData_ThenReject() {
        new StaffRepository(dataSource).save(null);
    }

    @Test
    public void whenSave_MultipleStaffs_ThenSave() {
        final CrudRepository<Staff> repository = new StaffRepository(dataSource);
        final Staff staffA = RepositoryTestUtils.createMockStaffA();
        final Staff staffB = RepositoryTestUtils.createMockStaffB();

        // Execute
        repository.save(Arrays.asList(staffA, staffB));

        // Assertion
        assertEquals(1L, (long) staffA.getId());
        assertEquals(2L, (long) staffB.getId());
    }
}
