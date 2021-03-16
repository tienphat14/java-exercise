package ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@MyService
public class PrintServiceImpl implements PrintService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

    @MyAutoWired
    public StaffService staffService;

    @MyAutoWired
    public StudentService studentService;

    @Override
    public void print() {
        if (Objects.isNull(staffService)) {
            LOGGER.info("Staff is null");
        } else {
            LOGGER.info("Staff number: {}", staffService.getStaffNumber());
        }

        if (Objects.isNull(studentService)) {
            LOGGER.info("Student is null");
        } else {
            LOGGER.info("Student number: {}", studentService.getStudentNumber());
        }
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
