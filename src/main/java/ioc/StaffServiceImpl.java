package ioc;

@MyService
public class StaffServiceImpl implements StaffService {

    @Override
    public int getStaffNumber() {
        return 10;
    }
}
