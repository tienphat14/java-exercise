package ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MyService
public class PrintServiceImpl implements PrintService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

    @MyAutoWired
    private StaffService staffService;

    @MyAutoWired
    private StudentService studentService;

    @Override
    public void print() {
        LOGGER.info("Staff number: {}", staffService.getStaffNumber());
        LOGGER.info("Student number: {}", studentService.getStudentNumber());
    }
}
