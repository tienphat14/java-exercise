package coaching.repository;

import coaching.model.Staff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public final class RepositoryTestUtils {

    private RepositoryTestUtils() {
        // Empty constructor
    }

    public static Staff createMockStaffA() {
        Staff staff = new Staff();
        staff.setId(1);
        staff.setFirstName("John");
        staff.setMiddleName("R");
        staff.setLastName("Biden");
        staff.setDob(LocalDate.parse("1965-12-03"));
        staff.setGender("M");
        staff.setPhone("092-392-555");
        staff.setAddress("21st Jump Street");
        return staff;
    }

    public static Staff createMockStaffB() {
        Staff staff = new Staff();
        staff.setId(2);
        staff.setFirstName("Donald");
        staff.setMiddleName("J");
        staff.setLastName("Trump");
        staff.setDob(LocalDate.parse("1965-12-03"));
        staff.setGender("M");
        staff.setPhone("092-392-555");
        staff.setAddress("21st Jump Street");
        return staff;
    }
}
