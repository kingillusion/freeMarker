package com.king.modelpdf.vo;



public class User {
    private String name;

    private String birth;

    private Integer age;

    private Integer sex;

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public User(String name, String birth, Integer age, Integer sex) {
        this.name = name;
        this.birth = birth;
        this.age = age;
        this.sex = sex;
    }

    public User() {
    }
}
