package coaching.repository;

import coaching.model.Staff;

import java.time.LocalDateTime;

public final class RepositoryTestUtils {

    private RepositoryTestUtils() {
        // Empty constructor
    }

    public static Staff createMockStaff() {
        Staff staff = new Staff();
        staff.setDob(LocalDateTime.now());
        return staff;
    }
}
