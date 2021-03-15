package coaching.repository;

import coaching.model.Staff;

import java.time.LocalDateTime;

public final class RepositoryTestUtils {

    private RepositoryTestUtils() {
        // Empty constructor
    }

    public static Staff createMockStaff(int id, String firstName, String middleName, String lastName, LocalDateTime dob, String phone, String address) {
        Staff staff = new Staff();
        staff.setId(id);
        staff.setFirstName(firstName);
        staff.setMiddleName(middleName);
        staff.setLastName(lastName);
        staff.setDob(dob);
        staff.setPhone(phone);
        staff.setAddress(address);
        return staff;
    }
}
