package ioc;

@MyService
public class StudentServiceImpl implements StudentService {

    @Override
    public int getStudentNumber() {
        return 100;
    }
}
