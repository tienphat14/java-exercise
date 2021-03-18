package commondesignpatterns.creationalpatterns.prototype;

public class Student extends People {

    private double gpa;

    public Student(){}

    public Student(Student student) {
        super(student);
        this.gpa = student.gpa;
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
