package cn.itsource.domain;

public class Students {
    private Long id;
    private String name;
    private Long age;

    //多對一對象關係維護
    private Classes classes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Students(String name, Long age, Classes classes) {
        this.name = name;
        this.age = age;
        this.classes = classes;
    }

    public Students() {
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classes=" + classes +
                '}';
    }
}
