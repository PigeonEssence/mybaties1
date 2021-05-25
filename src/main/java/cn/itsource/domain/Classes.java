package cn.itsource.domain;

public class Classes {
    private Long class_id;
    private String class_name;

    public Classes(Long class_id, String class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }

    public Classes() {
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "class_id=" + class_id +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
