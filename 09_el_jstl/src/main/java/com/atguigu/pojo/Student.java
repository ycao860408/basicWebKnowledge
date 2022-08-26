package com.atguigu.pojo;

public class Student {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private String phoneNum;

    public Student() {
    }

    public Student(Integer id, String name, Integer gender, Integer age, String phoneNum) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
