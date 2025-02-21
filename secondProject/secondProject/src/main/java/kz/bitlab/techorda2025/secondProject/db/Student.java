package kz.bitlab.techorda2025.secondProject.db;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private String city;
    private int exam;
    private String mark;

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.city = builder.city;
        this.exam = builder.exam;
        this.mark = builder.mark;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String surname;
        private String city;
        private int exam;
        private String mark;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder exam(int exam) {
            this.exam = exam;
            return this;
        }

        public Builder mark(String mark) {
            this.mark = mark;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {return city;}

    public void setCity(String city) {
        this.city = city;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Student(Long id, String name, String surname, String city, int exam, String mark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.exam = exam;
        this.mark = mark;
    }

    public Student() {
    }
}