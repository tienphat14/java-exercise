package coaching.repository;

import coaching.model.Staff;

public final class RepositoryTestUtils {

    private RepositoryTestUtils() {
        // Empty constructor
    }

    public static Staff createMockStaff() {
        return new Staff();
    }
}
