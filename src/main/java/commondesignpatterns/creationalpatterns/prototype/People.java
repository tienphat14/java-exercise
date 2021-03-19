package commondesignpatterns.creationalpatterns.prototype;

public abstract class People {

    private String name;
    private int age;
    private String gender;

    public People(){}

    public People(People people) {
        this.name = people.name;
        this.age = people.age;
        this.gender = people.gender;
    }

    public abstract People clone();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
